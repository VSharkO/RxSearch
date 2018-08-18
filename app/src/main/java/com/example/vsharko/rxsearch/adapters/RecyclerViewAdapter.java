package com.example.vsharko.rxsearch.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.vsharko.rxsearch.R;
import com.example.vsharko.rxsearch.model.Product;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {
    private List<Product> productList = new ArrayList<>();

    public void fillData(List<Product> productList){
        this.productList.clear();
        this.productList = productList;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_layout,parent,false);
        return new RecyclerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        Product product = productList.get(position);
        Glide.with(holder.image.getContext())
                .load(product.getBig_image())
                .into(holder.image);
        holder.text.setText(product.getName());
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.productImage)
        CircleImageView image;
        @BindView(R.id.productText)
        TextView text;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
