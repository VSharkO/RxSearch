package com.example.vsharko.rxsearch.networking;

import com.example.vsharko.rxsearch.model.Products;
import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Service {
    @POST("/")
    Call<Products> getProducts(@Query("search") String search);
}
