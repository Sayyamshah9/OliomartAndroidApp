package com.example.oliomart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.oliomart.adapters.RecyclerViewCategoryAdapter;
import com.example.oliomart.config.SharedPreferenceClass;
import com.example.oliomart.requests.GetProducts;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    RecyclerView category_recyclerView, allProducts_recyclerView;
    String[] stringCategories = {"Fashion", "Package Food", "Handicrafts", "Jewellery", "Beauty Products"};
    int[] imagesCategories = {R.drawable.fashion_category, R.drawable.packagefood_category, R.drawable.handicrafts_category, R.drawable.jewellery_category, R.drawable.beautyproducts_category};
    String tokenAuth;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferenceClass spClass = new SharedPreferenceClass(this);
        GetProducts getProducts = new GetProducts(this);

        //FETCHING VIEWS
        category_recyclerView = findViewById(R.id.category_recyclerView_id);
        bottomNavigationView = findViewById(R.id.bottomBarContainer_id);
        allProducts_recyclerView = findViewById(R.id.allProducts_recyclerView_id);

        //CATEGORY RECYCLERVIEW CODE
        category_recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false));
        RecyclerViewCategoryAdapter recyclerViewCategoryAdapter = new RecyclerViewCategoryAdapter(MainActivity.this, stringCategories, imagesCategories);
        category_recyclerView.setAdapter(recyclerViewCategoryAdapter);

        //ALL PRODUCTS RECYCLERVIEW CODE
        //GETTING TOKEN FROM SHARED PREFERENCES
        tokenAuth = spClass.getDataFromSharedPreferences("TOKEN");
//        Toast.makeText(this, "Token: " + tokenAuth, Toast.LENGTH_SHORT).show();
        getProducts.getProductsData(tokenAuth, allProducts_recyclerView);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.home:
                        Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.cart:
                        Toast.makeText(MainActivity.this, "Cart", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.orders:
                        Toast.makeText(MainActivity.this, "Orders", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.account:
                        Toast.makeText(MainActivity.this, "Account", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });

    }
}