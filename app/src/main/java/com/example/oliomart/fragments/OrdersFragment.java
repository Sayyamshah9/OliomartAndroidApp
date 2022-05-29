package com.example.oliomart.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.oliomart.R;
import com.example.oliomart.config.SharedPreferenceClass;
import com.example.oliomart.requests.GetProducts;

public class OrdersFragment extends Fragment {

    RecyclerView OrderProductsRecyclerView;
    String tokenAuth;
    View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_orders, container, false);

    //Fetching Views



    }
}