package com.example.vsharko.rxsearch.ui;

import com.example.vsharko.rxsearch.networking.networkingDI.NetworkModule;

import dagger.Component;

@Component(modules = NetworkModule.class)
public interface fakeMainComponent {
    void inject(MainActivity mainActivity);
}
