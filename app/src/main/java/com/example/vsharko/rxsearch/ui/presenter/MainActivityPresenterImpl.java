package com.example.vsharko.rxsearch.ui.presenter;

import com.example.vsharko.rxsearch.model.Product;
import com.example.vsharko.rxsearch.networking.helper.NetworkingHelper;
import com.example.vsharko.rxsearch.ui.view.MainActivityView;
import com.example.vsharko.rxsearch.utils.NetworkResponseListener;
import java.util.List;

import timber.log.Timber;

public class MainActivityPresenterImpl implements MainActivityPresenter {

    private MainActivityView mView;
    private NetworkingHelper mHelper;

    public MainActivityPresenterImpl(MainActivityView view, NetworkingHelper helper) {
        mView = view;
        mHelper = helper;
    }

    @Override
    public void sendRequest(String searchText){

        mHelper.getProductsFromAPI(new NetworkResponseListener<List<Product>>() {

            @Override
            public void onSuccess(List<Product> callback) {
                mView.updateAdapterData(callback);
            }

            @Override
            public void onFailure(Throwable throwable) {
                Timber.e(throwable.toString());
            }

        }, searchText);
    }
}


