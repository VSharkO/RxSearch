package com.example.vsharko.rxsearch.ui.view;

import com.example.vsharko.rxsearch.model.Product;

import java.util.List;

public interface MainActivityView {
    void updateAdapterData(List<Product> products);
}
