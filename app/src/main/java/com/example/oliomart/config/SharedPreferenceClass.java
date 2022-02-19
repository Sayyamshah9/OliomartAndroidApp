package com.example.oliomart.config;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceClass {

    Context context;
    public SharedPreferences sharedPreferences;
    public SharedPreferences.Editor editor;
    public String SHARED_PREF_NAME = "olioSP";

    public SharedPreferenceClass(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public String getDataFromSharedPreferences(String key){
        return sharedPreferences.getString(key, "null");
    }

    public Boolean getBooleanDataFromPrefs(String Key){
        return sharedPreferences.getBoolean(Key, false);
    }
}
