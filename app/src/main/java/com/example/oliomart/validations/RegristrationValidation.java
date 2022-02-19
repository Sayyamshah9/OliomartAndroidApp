package com.example.oliomart.validations;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.widget.AutoCompleteTextView;

import androidx.annotation.NonNull;

import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Pattern;

public class RegristrationValidation {

    Boolean result = false;

    public Boolean isFirstNameValid(String firstname, TextInputLayout firstNameTextInputLayout){

        if(!TextUtils.isEmpty(firstname)){
            return true;
        }
        firstNameTextInputLayout.setError("Required");

        firstNameTextInputLayout.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                firstNameTextInputLayout.setErrorEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable editable) { }
        });

        return false;
    }

    public Boolean isLastNameValid(String lastname, TextInputLayout lastNameTextInputLayout){

        if(!TextUtils.isEmpty(lastname)){
            return true;
        }
        lastNameTextInputLayout.setError("Required");

        lastNameTextInputLayout.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                lastNameTextInputLayout.setErrorEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable editable) { }
        });

        return false;
    }

    public Boolean isGenderValid(String genderString, TextInputLayout genderAutoCompleteTextView){

        if(!genderString.equals("Gender")){
            return true;
        }
        genderAutoCompleteTextView.setError("Required");

        genderAutoCompleteTextView.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                genderAutoCompleteTextView.setErrorEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable editable) { }
        });

        return false;
    }

    public Boolean isPhoneNoValid(String phoneNoString, TextInputLayout phoneNoTextInputLayout){

        if(!TextUtils.isEmpty(phoneNoString)){
            return true;
        }
        phoneNoTextInputLayout.setError("Required");

        phoneNoTextInputLayout.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                phoneNoTextInputLayout.setErrorEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable editable) { }
        });

        return false;
    }

    public Boolean isEmailValid(String emailString, TextInputLayout emailTextInputLayout){

        if(!TextUtils.isEmpty(emailString) && Patterns.EMAIL_ADDRESS.matcher(emailString).matches()){
            return true;
        }
        emailTextInputLayout.setError("Required");

        emailTextInputLayout.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                emailTextInputLayout.setErrorEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable editable) { }
        });

        return false;
    }

    public Boolean isPasswordValid(String passwordString, TextInputLayout passwordTextInputLayout){

        if(!TextUtils.isEmpty(passwordString)){
            return true;
        }
        passwordTextInputLayout.setError("Required");

        passwordTextInputLayout.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                passwordTextInputLayout.setErrorEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable editable) { }
        });

        return false;
    }

    public Boolean isConfirmPasswordValid(String confirmPasswordString, String passwordString, TextInputLayout confirmPasswordTextInputLayout){

        if(!TextUtils.isEmpty(confirmPasswordString) && confirmPasswordString.equals(passwordString)){
            return true;
        }
        confirmPasswordTextInputLayout.setError("Required");

        confirmPasswordTextInputLayout.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                confirmPasswordTextInputLayout.setErrorEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable editable) { }
        });

        return false;
    }

}
