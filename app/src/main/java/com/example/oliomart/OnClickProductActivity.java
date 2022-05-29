package com.example.oliomart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.oliomart.modals.ProductModalClass;

import java.util.ArrayList;

public class OnClickProductActivity extends AppCompatActivity {

    TextView onclickProductName, onclickProductDescription, onClickProductCategory, onClickPriceTag;
    ImageView onClickProductBackBtn;
    String ProductNameDetail, ProductDescriptionDetail, ProductPriceDetail, ProductCatDetail, ProductSubCatDetail, onClickPriceTagString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_click_product);

        onClickProductBackBtn = findViewById(R.id.onClickProductBackBtn);
        onclickProductName = findViewById(R.id.onclickProductName);
//        onclickProductDescription = findViewById(R.id.onclickProductDescription);
        onClickProductCategory = findViewById(R.id.onClickProductCategory);
        onClickPriceTag = findViewById(R.id.onClickPriceTag);

        onClickProductBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        ProductNameDetail = getIntent().getStringExtra("ProductNameDetail");
//        ProductDescriptionDetail = getIntent().getStringExtra("ProductDescriptionDetail");
        ProductPriceDetail = getIntent().getStringExtra("ProductPriceDetail");
        ProductCatDetail = getIntent().getStringExtra("ProductCatDetail");
        ProductSubCatDetail = getIntent().getStringExtra("ProductSubCatDetail");

        onClickPriceTagString = "₹ " + ProductPriceDetail + " /-";

//        Toast.makeText(this, ProductDescriptionDetail, Toast.LENGTH_SHORT).show();

        onclickProductName.setText(ProductNameDetail);
//        onclickProductDescription.setText(ProductDescriptionDetail);
        onClickProductCategory.setText(ProductCatDetail);
        onClickPriceTag.setText(onClickPriceTagString);

    }
}