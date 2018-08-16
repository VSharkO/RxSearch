package com.example.vsharko.rxsearch.networking.helper;

import android.support.annotation.NonNull;

import com.example.vsharko.rxsearch.model.Product;
import com.example.vsharko.rxsearch.model.Products;
import com.example.vsharko.rxsearch.networking.Service;
import com.example.vsharko.rxsearch.utils.NetworkResponseListener;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkingHelperImpl implements NetworkingHelper {

    private Service mService;

    public NetworkingHelperImpl(Service service) {
        mService = service;
    }


    @Override
    public void getProductsFromAPI(final NetworkResponseListener<List<Product>> listener,String search) {
        mService.getProducts(search).enqueue(new Callback<Products>() {
            @Override
            public void onResponse(@NonNull Call<Products> call, @NonNull Response<Products> response) {
                if (response.body()!=null){
                    Products data = response.body();
                    if(data!=null)
                        listener.onSuccess(data.getProductArrayList());
                }

            }

            @Override
            public void onFailure(@NonNull Call<Products> call,@NonNull Throwable t) {
                listener.onFailure(t);
            }
        });
    }
}
