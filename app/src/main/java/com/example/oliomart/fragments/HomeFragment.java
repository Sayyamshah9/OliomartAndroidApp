package com.example.oliomart.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.oliomart.R;
import com.example.oliomart.adapters.RecyclerViewCategoryAdapter;
import com.example.oliomart.config.SharedPreferenceClass;
import com.example.oliomart.requests.GetProducts;


public class HomeFragment extends Fragment {

    RecyclerView category_recyclerView, allProducts_recyclerView;
    String[] stringCategories = {"Fashion", "Package Food", "Handicrafts", "Jewellery", "Beauty Products"};
    int[] imagesCategories = {R.drawable.fashion_category, R.drawable.packagefood_category, R.drawable.handicrafts_category, R.drawable.jewellery_category, R.drawable.beautyproducts_category};
    String tokenAuth, stringNameOfUser;
    TextView nameOfUser;
//    BottomNavigationView bottomNavigationView;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_home, container, false);

        SharedPreferenceClass spClass = new SharedPreferenceClass(getContext());
        GetProducts getProducts = new GetProducts(getContext());
//        CommonBottomNavigationBar commonBottomNavigationBarForMainActivity = new CommonBottomNavigationBar();

//FETCHING VIEWS
        category_recyclerView = view.findViewById(R.id.category_recyclerView_id);
//        bottomNavigationView = view.findViewById(R.id.bottomBarContainer_id);
        allProducts_recyclerView = view.findViewById(R.id.allProducts_recyclerView_id);
        nameOfUser = view.findViewById(R.id.name_of_user_id);

//GETTING DATA FROM SHARED PREFERENCES
        stringNameOfUser = spClass.getDataFromSharedPreferences("USER_NAME");
        nameOfUser.setText(stringNameOfUser);

//CATEGORY RECYCLERVIEW CODE
        category_recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        RecyclerViewCategoryAdapter recyclerViewCategoryAdapter = new RecyclerViewCategoryAdapter(getContext(), stringCategories, imagesCategories);
        category_recyclerView.setAdapter(recyclerViewCategoryAdapter);

//GETTING TOKEN FROM SHARED PREFERENCES
        tokenAuth = spClass.getDataFromSharedPreferences("TOKEN");
//SENDING DATA TO GET PRODUCT FUNCTION
        getProducts.getProductsData(tokenAuth, allProducts_recyclerView);

//BOTTOM NAVIGATION BAR
//        commonBottomNavigationBarForMainActivity.getBottomNavigationBar(bottomNavigationView, getContext());

        // Inflate the layout for this fragment
        return view;
    }
}