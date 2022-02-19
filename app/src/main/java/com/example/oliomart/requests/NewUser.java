package com.example.oliomart.requests;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.oliomart.EmailVerification;
import com.example.oliomart.LoginActivity;
import com.example.oliomart.MainActivity;
import com.example.oliomart.RegristrationActivity;
import com.example.oliomart.config.ApiClient;
import com.example.oliomart.config.CommonMethods;
import com.example.oliomart.config.RequestsInterface;
import com.example.oliomart.config.SessionManagerClass;
import com.example.oliomart.config.SharedPreferenceClass;
import com.example.oliomart.modals.UserModalClass;
import com.example.oliomart.validations.LoginValidation;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewUser{

    String idFromResponse, emailFromResponse, msgFromResponse, tokenFromResponse, nameFromResponse;
    Context context;

    public NewUser(Context context) {
        this.context = context;
    }

    CommonMethods commonIntent = new CommonMethods();

    ApiClient apiClient = new ApiClient();
    RequestsInterface requestsInterface = apiClient.retrofit.create(RequestsInterface.class);

    //sending new user data
    public void registerNewUser(String username, String email, String phone, String password, String confirmpassword, String gender ){

        UserModalClass userModalClass = new UserModalClass(username, email, phone, password, confirmpassword, gender);
        Call<UserModalClass> userModalClassCall = requestsInterface.registerNewUser(userModalClass);

        userModalClassCall.enqueue(new Callback<UserModalClass>() {
            @Override
            public void onResponse(@NonNull Call<UserModalClass> call, @NonNull Response<UserModalClass> response) {

                msgFromResponse = response.body().getMsg();

                if(response.code() == 200){

                    Toast.makeText(context, "Login to Continue", Toast.LENGTH_SHORT).show();
                    commonIntent.setIntent(context, LoginActivity.class);

                }else {
                    try {
                        JSONObject jObjError = new JSONObject(response.errorBody().string());
                        jObjError.getString("msg");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            @Override
            public void onFailure(@NonNull Call<UserModalClass> call, @NonNull Throwable t) {
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

//    Sending login data
    public void loginUser(String email, String password, TextInputLayout emailTxtLayout, TextInputLayout passTxtLayout ){

        UserModalClass loginUserModelClass = new UserModalClass(email, password);
        Call<UserModalClass> loginCall = requestsInterface.loginUser(loginUserModelClass);

        SharedPreferenceClass sharedPreferenceClass = new SharedPreferenceClass(context);

        loginCall.enqueue(new Callback<UserModalClass>() {
            @Override
            public void onResponse(@NonNull Call<UserModalClass> call, @NonNull Response<UserModalClass> response) {

                if(response.code() == 200){

                    nameFromResponse = response.body().getUsername();
                    idFromResponse = response.body().get_id();
                    emailFromResponse = response.body().getEmail();
                    tokenFromResponse = response.body().getJtoken();

                    //SESSION CODE
                    SessionManagerClass sessionManager = new SessionManagerClass(context);
                    sessionManager.createSession(true, idFromResponse, nameFromResponse, emailFromResponse, tokenFromResponse);

                    commonIntent.setIntent(context, MainActivity.class);
                    Toast.makeText(context, "Logging In", Toast.LENGTH_SHORT).show();
                }else{

                    //Invalid Data Handling
                    Gson gson = new Gson();
                    try{

                        //CONVERTING ERROR BODY OF 400 BAD REQUEST TO JSON STRING
                        JSONObject jObjError = new JSONObject(response.errorBody().string());
                        new LoginValidation().setBackendErrorToViews(jObjError.getString("msg"), emailTxtLayout, passTxtLayout);

                    }catch (IOException | JSONException e){
                        e.printStackTrace();
                    }
                }
            }
            @Override
            public void onFailure(@NonNull Call<UserModalClass> call, @NonNull Throwable t) {
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    //OTP verification activity
    private void toNextActivity(Context context, String em){
        CommonMethods commonMethods = new CommonMethods();
        commonMethods.setIntentWithMessage(context, EmailVerification.class, "newEmail", em);
    }
}
