package com.example.oliomart.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.oliomart.OnClickProductActivity;
import com.example.oliomart.R;
import com.example.oliomart.modals.ProductModalClass;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RecyclerViewProductAdapter extends RecyclerView.Adapter<ProductViewHolder> {

    Context context;
    List<ProductModalClass> productList;
    ArrayList<String> productImages = new ArrayList<>();
    String thumbNailImage, ProductPriceStr;

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
        ProductPriceStr = "₹ " + productList.get(holder.getAdapterPosition()).getPrice() + " /-";
        holder.productName.setText(productList.get(holder.getAdapterPosition()).getProductName());
        holder.productSubCategory.setText(productList.get(holder.getAdapterPosition()).getSubCategory());
        holder.productPrice.setText(ProductPriceStr);

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

//                Toast.makeText(context, productList.get(holder.getAdapterPosition()).getDescription(), Toast.LENGTH_SHORT).show();
                Intent i = new Intent(context, OnClickProductActivity.class);
                i.putExtra("ProductNameDetail", productList.get(holder.getAdapterPosition()).getProductName());
//                i.putExtra("ProductDescriptionDetail", productList.get(holder.getAdapterPosition()).getDescription());
                i.putExtra("ProductPriceDetail", productList.get(holder.getAdapterPosition()).getPrice());
                i.putExtra("ProductCatDetail", productList.get(holder.getAdapterPosition()).getCategory());
                i.putExtra("ProductSubCatDetail", productList.get(holder.getAdapterPosition()).getSubCategory());
                i.putExtra("ProductImgDetail", productList.get(holder.getAdapterPosition()).getPimages());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}
