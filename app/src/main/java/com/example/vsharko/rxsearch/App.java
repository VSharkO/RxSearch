package com.example.vsharko.rxsearch;

import android.app.Application;

import timber.log.Timber;

public class App extends Application{
    private static App sInstance;
    private AppComponent mAppComponent;
    @Override
    public void onCreate(){
        super.onCreate();
        sInstance = this;
        Timber.plant(new Timber.DebugTree());
//        mAppComponent = DaggerAppComponent.builder()
//                .repositoryModule(new RepositoryModule(this))
//                .build();
    }

    public static App getInstance() {
        return sInstance;
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
