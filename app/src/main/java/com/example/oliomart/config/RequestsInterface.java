package com.example.oliomart.config;

import com.example.oliomart.modals.ProductModalClass;
import com.example.oliomart.modals.UserModalClass;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface RequestsInterface {

    //NEW USER REGRISTRATION
    @POST("/newbuyer/register")
    Call<UserModalClass> registerNewUser(@Body UserModalClass userModalClass);

    //LOGIN OLD USER
    @POST("/newbuyer/login")
    Call<UserModalClass> loginUser(@Body UserModalClass userModalClass);

    //SEND OTP EMAIL TO USER
//    @PUT("/sendotp/{email}")
//    Call<UserModalClass> sendOtpMail(@Path("email") String email);

    //VERIFY OTP ENTERED BY USER
//    @PUT("/sendotp/verifyotp/{otp}")
//    Call<UserModalClass> verifyOtp(@Path("otp") Integer otp);

    //GET PRODUCTS
    @GET("/getproducts")
    Call<List<ProductModalClass>> getProducts(@Header("auth_token") String jToken);

}
