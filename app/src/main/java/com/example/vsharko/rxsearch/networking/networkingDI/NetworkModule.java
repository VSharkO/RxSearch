package com.example.vsharko.rxsearch.networking.networkingDI;

import com.example.vsharko.rxsearch.networking.helper.NetworkingHelper;
import com.example.vsharko.rxsearch.networking.helper.NetworkingHelperImpl;
import com.example.vsharko.rxsearch.networking.Service;
import com.example.vsharko.rxsearch.utils.Constants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

@Module(includes = OkHttpModule.class)
public class NetworkModule {

    @Singleton
    @Provides
    public NetworkingHelper provideNetworkingHelper(Service service){
        return new NetworkingHelperImpl(service);
    }

    @Singleton
    @Provides
    public Retrofit provideRestClient(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(Constants.NEWS_API_BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();
    }

    @Singleton
    @Provides
    public Service provideNewsAPIService(Retrofit retrofit) {
        return retrofit.create(Service.class);
    }
}
