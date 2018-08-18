package com.example.vsharko.rxsearch.ui.DI;

import com.example.vsharko.rxsearch.Scopes.PerActivity;
import com.example.vsharko.rxsearch.networking.helper.NetworkingHelper;
import com.example.vsharko.rxsearch.ui.presenter.MainActivityPresenter;
import com.example.vsharko.rxsearch.ui.presenter.MainActivityPresenterImpl;
import com.example.vsharko.rxsearch.ui.view.MainActivityView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = MainActivityModule.class)
public class MainModule {

    @PerActivity
    @Provides
    public MainActivityPresenter providePresenter(MainActivityView mainActivityView, NetworkingHelper helper){
        return new MainActivityPresenterImpl(mainActivityView,helper);
    }

}
