package com.example.oliomart.config;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.oliomart.MainActivity;
import com.example.oliomart.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class CommonMethods {

    public void setDropdown(Context context, String[] commonArray, AutoCompleteTextView common_dropdown_editTextInputLayout){

        ArrayAdapter arrayAdapter = new ArrayAdapter(context, R.layout.dropdownelement, commonArray);
        common_dropdown_editTextInputLayout.setAdapter(arrayAdapter);
    }

    public void setIntentWithMessage(Context context, Class destination, String messageName, String messageToSend){
        Intent i = new Intent(context, destination);
        i.putExtra(messageName, messageToSend);
        context.startActivity(i);
    }

    public void setIntent(Context context, Class destination){
        Intent i = new Intent(context, destination);
        context.startActivity(i);
    }
}
