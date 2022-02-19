package com.example.oliomart.config;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.example.oliomart.R;

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
