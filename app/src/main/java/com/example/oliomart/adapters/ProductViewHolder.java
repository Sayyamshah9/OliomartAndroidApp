package com.example.oliomart.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.oliomart.R;

public class ProductViewHolder extends RecyclerView.ViewHolder {

    TextView productName, productSubCategory, productPrice;
    ImageView thumbnailImage, addToWishlistBtn;
    LinearLayoutCompat productContainer;

    public ProductViewHolder(@NonNull View itemView) {

        super(itemView);

        productName = itemView.findViewById(R.id.product_title_id);
        productSubCategory = itemView.findViewById(R.id.product_subCategory_id);
        productPrice = itemView.findViewById(R.id.priceTag_id);
        thumbnailImage = itemView.findViewById(R.id.product_image_id);
        addToWishlistBtn = itemView.findViewById(R.id.addToWishlistBtn_id);
        productContainer = itemView.findViewById(R.id.product_containerId);

    }
}
