package com.example.oliomart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.oliomart.modals.ProductModalClass;

import java.util.ArrayList;

public class OnClickProductActivity extends AppCompatActivity {

    TextView productChNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_click_product);

        productChNav = findViewById(R.id.productChNav);

//        Intent i = getIntent();
//        ArrayList<ProductModalClass> pmc = getIntent().getExtras("ProductDetails");
//        Bundle args1 = i.getBundleExtra("ProductDetails");
//        ArrayList<ProductModalClass> object = (ArrayList<ProductModalClass>) args1.getSerializable("productDetailsBundle");

//        productChNav.setText(object.);

    }
}