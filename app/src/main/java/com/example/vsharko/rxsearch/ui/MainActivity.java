package com.example.vsharko.rxsearch.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.vsharko.rxsearch.R;
import com.example.vsharko.rxsearch.model.Product;
import com.example.vsharko.rxsearch.networking.helper.NetworkingHelper;
import com.example.vsharko.rxsearch.networking.helper.NetworkingHelperImpl;
import com.example.vsharko.rxsearch.utils.NetworkResponseListener;

import java.util.List;

import javax.inject.Inject;

import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    @Inject
    NetworkingHelperImpl helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DaggerfakeMainComponent.create()
                .inject(this);


        helper.getProductsFromAPI(new NetworkResponseListener<List<Product>>() {
            @Override
            public void onSuccess(List<Product> callback) {
                Log.i("DADA",callback.get(2).getName());
            }

            @Override
            public void onFailure(Throwable throwable) {
                Log.e("NE",throwable.toString());
            }
        }, "lo");
    }
}