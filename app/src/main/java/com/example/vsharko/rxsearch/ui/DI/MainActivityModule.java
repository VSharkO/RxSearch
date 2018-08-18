package com.example.vsharko.rxsearch.ui.DI;

import com.example.vsharko.rxsearch.scopes.PerActivity;
import com.example.vsharko.rxsearch.ui.view.MainActivity;
import com.example.vsharko.rxsearch.ui.view.MainActivityView;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {

    private MainActivity mMainActivity;

    public MainActivityModule(MainActivity mainActivity) {
        mMainActivity = mainActivity;
    }

    @PerActivity
    @Provides
    public MainActivityView provideMainActivity(){
        return mMainActivity;
    }
}
