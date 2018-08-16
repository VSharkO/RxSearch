package com.example.vsharko.rxsearch.networking.networkingDI;

import com.example.vsharko.rxsearch.BuildConfig;
import com.example.vsharko.rxsearch.utils.Constants;
import java.io.IOException;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import timber.log.Timber;

@Module
public class OkHttpModule {

    @Provides
    public OkHttpClient provideOkHttpClient(Interceptor interceptor, HttpLoggingInterceptor logging){
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder().addInterceptor(interceptor);
        if(BuildConfig.DEBUG) {
            okHttpClientBuilder.addInterceptor(logging);
        }
        return okHttpClientBuilder.build();
    }


    @Provides
    public Interceptor provideInterceptor() {
        Interceptor interceptor = new Interceptor(){
            @Override
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request original = chain.request();
                HttpUrl httpUrl = original.url();

                HttpUrl newHttpUrl = httpUrl.newBuilder()
                        .addPathSegments(Constants.LANGUAGE)
                        .addPathSegments(Constants.FORMAT)
                        .addPathSegments(Constants.REQUEST_TYPE)
                        .addPathSegments(Constants.ACTION)
                        .addQueryParameter("q", original.url().queryParameterValue(0))
                        .build();

                Request.Builder requestBuilder = original.newBuilder().url(newHttpUrl);
                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        };
        return interceptor;
    }

    @Provides
    public HttpLoggingInterceptor provideLogging() {
        HttpLoggingInterceptor.Logger logger = new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Timber.d(message);
            }
        };

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor(logger);
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        return logging;
    }
}
