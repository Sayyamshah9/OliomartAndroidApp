package com.example.oliomart.validations;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;

import com.google.android.material.textfield.TextInputLayout;

public class LoginValidation {

    boolean result = false;

    public Boolean isLoginValid(String stringEmail, String stringPassword, TextInputLayout email, TextInputLayout password){

        //EMAIL CHECK
        if (!TextUtils.isEmpty(stringEmail) && Patterns.EMAIL_ADDRESS.matcher(stringEmail).matches()) {
            result = true;
        }else {
            email.setError("Incorrect Email");
        }
        //PASSWORD CHECK
        if(TextUtils.isEmpty(stringPassword)){
            password.setError("Incorrect Password");
        }

        email.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                email.setErrorEnabled(false);
            }
            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        password.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                password.setErrorEnabled(false);
            }
            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        return result;
    }

    public void setBackendErrorToViews(String error, TextInputLayout eEmail, TextInputLayout ePassword){
        if(error.equals("Invalid Email")){
            eEmail.setError(error);
        }else if(error.equals("Invalid Password")) {
            ePassword.setError(error);
        }
    }

}
