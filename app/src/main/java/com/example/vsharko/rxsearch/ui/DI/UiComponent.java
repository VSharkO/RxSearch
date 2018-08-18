package com.example.vsharko.rxsearch.ui.DI;

import com.example.vsharko.rxsearch.AppComponent;
import com.example.vsharko.rxsearch.Scopes.PerActivity;
import com.example.vsharko.rxsearch.ui.view.MainActivity;

import dagger.Component;

@PerActivity
@Component(modules = {MainActivityModule.class, MainModule.class}, dependencies = AppComponent.class)
public interface UiComponent {
    void inject(MainActivity mainActivity);
}
