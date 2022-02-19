package com.example.oliomart.config;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://oliomart.herokuapp.com/")
//            .baseUrl("http://192.168.1.104:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
