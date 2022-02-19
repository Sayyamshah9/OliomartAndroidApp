package com.example.oliomart.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.oliomart.R;
import com.example.oliomart.modals.ProductModalClass;

import java.util.List;

public class RecyclerViewProductAdapter extends RecyclerView.Adapter<ProductViewHolder> {

    Context context;
    List<ProductModalClass> productList;

    public RecyclerViewProductAdapter(Context context, List<ProductModalClass> productList) {
        this.context = context;
        this.productList = productList;
    }


    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProductViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.allproducts_recyclerview_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        holder.productName.setText(productList.get(position).getProductName());
        holder.productSubCategory.setText(productList.get(position).getSubCategory());
        holder.productPrice.setText(productList.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}
