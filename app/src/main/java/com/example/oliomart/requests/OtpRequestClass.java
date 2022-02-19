package com.example.oliomart.requests;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.oliomart.config.ApiClient;
import com.example.oliomart.config.RequestsInterface;
import com.example.oliomart.modals.UserModalClass;
import com.google.android.material.textfield.TextInputLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OtpRequestClass {

    String msgFromResponse;
//    ApiClient apiClient = new ApiClient();
//    RequestsInterface requestsInterface = apiClient.retrofit.create(RequestsInterface.class);

    public void sendOtp(Context context, String email){

//        Call<UserModalClass> otpCall = requestsInterface.sendOtpMail(email);
//
//        otpCall.enqueue(new Callback<UserModalClass>() {
//            @Override
//            public void onResponse(Call<UserModalClass> call, Response<UserModalClass> response) {
//                msgFromResponse = response.body().getMsg();
//                if(msgFromResponse.equals("OTP updated & sent")){
//                    Toast.makeText(context, "OTP is sent", Toast.LENGTH_SHORT).show();
//                }else {
//                    Toast.makeText(context, msgFromResponse, Toast.LENGTH_SHORT).show();
//                }
//            }
//            @Override
//            public void onFailure(Call<UserModalClass> call, Throwable t) {
//                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//
//    public void verifyOtp(Context context, Integer otp, TextInputLayout address, TextInputLayout state, TextInputLayout city, TextInputLayout pincode, Button confirm ){
//
//        Call<UserModalClass> otpVerifyCall = requestsInterface.verifyOtp(otp);
//
//        otpVerifyCall.enqueue(new Callback<UserModalClass>() {
//            @Override
//            public void onResponse(Call<UserModalClass> call, Response<UserModalClass> response) {
//                msgFromResponse = response.body().getMsg();
//                if(msgFromResponse.equals("OTP verified")){
//                    address.setVisibility(View.VISIBLE);
//                    state.setVisibility(View.VISIBLE);
//                    city.setVisibility(View.VISIBLE);
//                    pincode.setVisibility(View.VISIBLE);
//                    confirm.setVisibility(View.VISIBLE);
//                }else {
//                    Toast.makeText(context, msgFromResponse, Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<UserModalClass> call, Throwable t) {
//                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//
    }
}
