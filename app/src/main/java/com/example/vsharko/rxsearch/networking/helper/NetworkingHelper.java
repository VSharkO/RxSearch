package com.example.vsharko.rxsearch.networking.helper;

import com.example.vsharko.rxsearch.model.Product;
import com.example.vsharko.rxsearch.utils.NetworkResponseListener;

import java.util.List;

public interface NetworkingHelper {
    void getProductsFromAPI(NetworkResponseListener<List<Product>> listener,String search);
}
