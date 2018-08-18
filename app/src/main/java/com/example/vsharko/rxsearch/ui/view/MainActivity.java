package com.example.vsharko.rxsearch.ui.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.EditText;

import com.example.vsharko.rxsearch.App;
import com.example.vsharko.rxsearch.R;
import com.example.vsharko.rxsearch.adapters.RecyclerViewAdapter;
import com.example.vsharko.rxsearch.model.Product;
import com.example.vsharko.rxsearch.networking.helper.NetworkingHelper;
import com.example.vsharko.rxsearch.networking.helper.NetworkingHelperImpl;
import com.example.vsharko.rxsearch.ui.DI.DaggerUiComponent;
import com.example.vsharko.rxsearch.ui.DI.MainActivityModule;
import com.example.vsharko.rxsearch.ui.presenter.MainActivityPresenter;
import com.example.vsharko.rxsearch.ui.view.MainActivityView;
import com.example.vsharko.rxsearch.utils.NetworkResponseListener;
import com.jakewharton.rxbinding.widget.RxTextView;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscription;
import rx.functions.Action1;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity implements MainActivityView{

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.editText)
    EditText mEditText;

    public RecyclerViewAdapter adapter;

    @Inject
    public MainActivityPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        DaggerUiComponent.builder().appComponent(App.getInstance().getAppComponent())
                .mainActivityModule(new MainActivityModule(this))
                .build()
                .inject(this);

        provideRecyclerViewAdapter();
        setTextWatcher();
    }

    @Override
    public void updateAdapterData(List<Product> products) {
        adapter.fillData(products);
        adapter.notifyDataSetChanged();
    }

    public void setTextWatcher(){
        RxTextView.textChanges(mEditText)
                .debounce(200, TimeUnit.MILLISECONDS)
                .subscribe(charSequence -> mPresenter.sendRequest(mEditText.getText().toString()));
    }

    public void provideRecyclerViewAdapter() {
        adapter = new RecyclerViewAdapter();
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        mRecyclerView.setAdapter(adapter);
    }
}
