package com.example.oliomart.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.oliomart.OnClickProductActivity;
import com.example.oliomart.R;
import com.example.oliomart.config.CommonMethods;
import com.example.oliomart.modals.ProductModalClass;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RecyclerViewProductAdapter extends RecyclerView.Adapter<ProductViewHolder> {

    Context context;
    List<ProductModalClass> productList;
    ArrayList<String> productImages = new ArrayList<>();
    String thumbNailImage;

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
        holder.productName.setText(productList.get(holder.getAdapterPosition()).getProductName());
        holder.productSubCategory.setText(productList.get(holder.getAdapterPosition()).getSubCategory());
        holder.productPrice.setText(productList.get(holder.getAdapterPosition()).getPrice());

//        LOADING IMAGES TO IMAGEVIEW CODE
//        productImages = productList.get(holder.getAdapterPosition()).getPimages();
//        thumbNailImage = productImages.get(0);
//        Toast.makeText(context, "ImgURL: " + Uri.parse(thumbNailImage), Toast.LENGTH_SHORT).show();
//        if ( productImages.get(0) != null) {
//            Picasso.get().load(Uri.parse(thumbNailImage)).into(holder.thumbnailImage);
//        }

        //ONCLICK LISTENER TO PRODUCT
        holder.productContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(context, OnClickProductActivity.class);
//                Bundle args = new Bundle();
//                args.putSerializable("productDetailsBundle", (Serializable) holder.getAdapterPosition());
                i.putExtra("ProductDetails", holder.getAdapterPosition());
                context.startActivity(i);

//                i.putStringArrayListExtra("productDetails", holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}
