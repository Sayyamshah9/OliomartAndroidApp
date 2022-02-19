package com.example.oliomart.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.oliomart.R;

public class CategoryViewHolder extends RecyclerView.ViewHolder {

        TextView categoryName;
        ImageView categoryImage;
        LinearLayoutCompat category_itemLinearLayout;

    public CategoryViewHolder(@NonNull View itemView) {
        super(itemView);
        categoryName = itemView.findViewById(R.id.category_name_textview_id);
        categoryImage = itemView.findViewById(R.id.category_img_id);
        category_itemLinearLayout = itemView.findViewById(R.id.item_linearLayout_id);
    }
}
