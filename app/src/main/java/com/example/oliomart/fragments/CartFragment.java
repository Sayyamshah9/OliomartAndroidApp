package com.example.oliomart.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.oliomart.R;
import com.example.oliomart.config.SharedPreferenceClass;
import com.example.oliomart.requests.GetProducts;

public class CartFragment extends Fragment {

    RecyclerView cart_Products_recyclerView_id;
    String tokenAuth;
    TextView nameOfUser;

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_cart, container, false);

        SharedPreferenceClass spClass = new SharedPreferenceClass(getContext());
        GetProducts getProducts = new GetProducts(getContext());

        // Inflate the layout for this fragment

        //Fetching the views
        cart_Products_recyclerView_id = view.findViewById(R.id.cart_Products_recyclerView_id);

        //GETTING TOKEN FROM SHARED PREFERENCES
        tokenAuth = spClass.getDataFromSharedPreferences("TOKEN");
//SENDING DATA TO GET PRODUCT FUNCTION
        getProducts.getProductsData(tokenAuth, cart_Products_recyclerView_id);

        return view;
    }
}