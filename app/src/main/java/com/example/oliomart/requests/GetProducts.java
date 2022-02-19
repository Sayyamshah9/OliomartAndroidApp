package com.example.oliomart.requests;

import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.oliomart.adapters.RecyclerViewCategoryAdapter;
import com.example.oliomart.adapters.RecyclerViewProductAdapter;
import com.example.oliomart.config.ApiClient;
import com.example.oliomart.config.RequestsInterface;
import com.example.oliomart.config.SharedPreferenceClass;
import com.example.oliomart.modals.ProductModalClass;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetProducts {

    String[] ProductImages;
    String stringProductName;
    String stringProductDescription;
    String stringProductCategory;
    String stringProductSubCategory;
    String stringProductPrice;

    Context context;

    public GetProducts(Context context) { this.context = context; }

    ApiClient apiClient = new ApiClient();
    RequestsInterface requestsInterface = apiClient.retrofit.create(RequestsInterface.class);

    //GETTING PRODUCT DATA METHOD
    public void getProductsData(String authToken, RecyclerView recyclerView){

        ProductModalClass productModalClass = new ProductModalClass();
        Call<List<ProductModalClass>> productDataCall = requestsInterface.getProducts(authToken);

        productDataCall.enqueue(new Callback<List<ProductModalClass>>() {
            @Override
            public void onResponse(Call<List<ProductModalClass>> call, Response<List<ProductModalClass>> response) {

                if(response.code() == 200){
                    List<ProductModalClass> productData = response.body();
                    //SEND LIST TO RECYCLER VIEW
                    recyclerView.setLayoutManager(new LinearLayoutManager(context));
                    RecyclerViewProductAdapter recyclerViewProductAdapter = new RecyclerViewProductAdapter(context, productData);
                    recyclerView.setAdapter(recyclerViewProductAdapter);

                }
            }

            @Override
            public void onFailure(Call<List<ProductModalClass>> call, Throwable t) {

            }
        });
    }
}
