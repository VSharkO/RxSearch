package com.example.vsharko.rxsearch;

import com.example.vsharko.rxsearch.networking.helper.NetworkingHelper;
import com.example.vsharko.rxsearch.networking.networkingDI.NetworkModule;

import dagger.Component;

@Component(modules = NetworkModule.class)
public interface AppComponent {
    NetworkingHelper injectNetworkingHelper();
}
