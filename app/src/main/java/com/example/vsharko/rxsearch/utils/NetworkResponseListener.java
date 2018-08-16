package com.example.vsharko.rxsearch.utils;

public interface NetworkResponseListener<T> {
    void onSuccess(T callback);
    void onFailure(Throwable throwable);
}
