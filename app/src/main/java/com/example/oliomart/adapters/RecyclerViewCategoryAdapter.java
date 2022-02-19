package com.example.oliomart.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.oliomart.R;

public class RecyclerViewCategoryAdapter extends RecyclerView.Adapter<CategoryViewHolder> {

    Context context;
    String[] stringCategory;
    int[] categoryImages;

    public RecyclerViewCategoryAdapter(Context context, String[] stringCategory, int[] categoryImages) {
        this.context = context;
        this.stringCategory = stringCategory;
        this.categoryImages = categoryImages;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CategoryViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.category_recyclerview_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        holder.categoryName.setText(stringCategory[position]);
        holder.categoryImage.setImageResource(categoryImages[position]);
        holder.category_itemLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, stringCategory[position], Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return stringCategory.length;
    }
}
