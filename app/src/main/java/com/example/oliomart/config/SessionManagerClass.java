package com.example.oliomart.config;

import android.content.Context;
import android.content.Intent;

import com.example.oliomart.LoginActivity;
import com.example.oliomart.MainActivity;

public class SessionManagerClass {
    Context context;
    String email, token;
    SharedPreferenceClass sharedPreferenceClass;

    public SessionManagerClass(Context context) {
        this.context = context;
        this.sharedPreferenceClass = new SharedPreferenceClass(context);
    }

    public void createSession(Boolean loginStatus, String idFromResponse, String nameFromResponse, String emailFromResponse, String tokenFromResponse){
        sharedPreferenceClass.editor.putBoolean("LOGIN_STATUS", loginStatus);
        sharedPreferenceClass.editor.putString("USER_ID", idFromResponse);
        sharedPreferenceClass.editor.putString("USER_NAME", nameFromResponse);
        sharedPreferenceClass.editor.putString("USER_EMAIL", emailFromResponse);
        sharedPreferenceClass.editor.putString("TOKEN", tokenFromResponse);
        sharedPreferenceClass.editor.apply();
    }

    public Boolean isLogin(){ return sharedPreferenceClass.getBooleanDataFromPrefs("LOGIN_STATUS");}

    public void isLoggedIn(){
        if(isLogin()){
            Intent i = new Intent(context, MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }
    }

    public void Logout(){
        sharedPreferenceClass.editor.clear();
        sharedPreferenceClass.editor.commit();

        Intent i = new Intent(context, LoginActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }
}
