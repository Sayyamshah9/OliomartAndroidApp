package com.example.oliomart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.oliomart.config.CommonMethods;
import com.example.oliomart.config.SharedPreferenceClass;
import com.example.oliomart.requests.OtpRequestClass;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class EmailVerification extends AppCompatActivity {

    TextInputLayout otpTextInputLayout, addressInputLayout, stateInputLayout, cityInputLayout, pincodeInputLayout;
    TextInputEditText otpEditTextInputLayout;
    TextView emailFromPrevious_txtview;
    AutoCompleteTextView states_dropdown_editTextInputLayout, cities_dropdown_editTextInputLayout;
    String otpString, addressString, stateString, cityString, pincodeString, newEmail;
    String[] stateArray, cityArray;
    Button confirmBtn;
    CommonMethods commonMethods = new CommonMethods();
    OtpRequestClass otpRequestClass = new OtpRequestClass();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //SET AUTOFILL OFF
        getWindow().getDecorView().setImportantForAutofill(View.IMPORTANT_FOR_AUTOFILL_NO_EXCLUDE_DESCENDANTS);
        setContentView(R.layout.activity_regristration);
        setContentView(R.layout.activity_email_verification);

        //FETCHING VIEWS
        states_dropdown_editTextInputLayout = findViewById(R.id.state_dropdown_editTextInputLayout);
        cities_dropdown_editTextInputLayout = findViewById(R.id.city_dropdown_editTextInputLayout);
        confirmBtn = findViewById(R.id.confirmBtn);
        addressInputLayout = findViewById(R.id.address_textInputLayout);
        stateInputLayout = findViewById(R.id.stateDropdown_textLayout);
        cityInputLayout = findViewById(R.id.cityDropdown_textLayout);
        pincodeInputLayout = findViewById(R.id.pincode_textInputLayout);
        emailFromPrevious_txtview = findViewById(R.id.emailFromPreviousActivity_txtview);
        otpTextInputLayout = findViewById(R.id.otp_textInputLayout);
        otpEditTextInputLayout = findViewById(R.id.otpeditTextInputLayout);

        //EMAIL FROM PREVIOUS ACTIVITY
        newEmail = getIntent().getStringExtra("newEmail");
        if(newEmail != null){
            emailFromPrevious_txtview.setText(newEmail);
            otpRequestClass.sendOtp(this, newEmail);
        }

        //SENDING OTP

        otpEditTextInputLayout.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void afterTextChanged(Editable editable) {
//                otpString = otpEditTextInputLayout.getText().toString();
//                otpRequestClass.verifyOtp(EmailVerification.this, Integer.parseInt(otpString), addressInputLayout, stateInputLayout, cityInputLayout, pincodeInputLayout, confirmBtn);
            }
        });

        otpString = otpTextInputLayout.getEditText().getText().toString();

        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addressString = addressInputLayout.getEditText().getText().toString();
                stateString = stateInputLayout.getEditText().getText().toString();
                cityString = cityInputLayout.getEditText().getText().toString();
                pincodeString = pincodeInputLayout.getEditText().getText().toString();

                Toast.makeText(EmailVerification.this, "address: " + addressString, Toast.LENGTH_SHORT).show();

            }
        });

        stateArray = getResources().getStringArray(R.array.states);
        commonMethods.setDropdown(EmailVerification.this, stateArray, states_dropdown_editTextInputLayout);

        states_dropdown_editTextInputLayout.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                stateString = states_dropdown_editTextInputLayout.getText().toString();
                switch (stateString) {
                    case "Maharashtra":
                        cityArray = getResources().getStringArray(R.array.maharashtra_cities);
                        commonMethods.setDropdown(EmailVerification.this, cityArray, cities_dropdown_editTextInputLayout);
                        break;
                    case "Delhi":
                        cityArray = getResources().getStringArray(R.array.delhi_cities);
                        commonMethods.setDropdown(EmailVerification.this, cityArray, cities_dropdown_editTextInputLayout);
                        break;
                    case "Goa":
                        cityArray = getResources().getStringArray(R.array.goa_cities);
                        commonMethods.setDropdown(EmailVerification.this, cityArray, cities_dropdown_editTextInputLayout);
                        break;
                    case "Gujarat":
                        cityArray = getResources().getStringArray(R.array.gujarat_city);
                        commonMethods.setDropdown(EmailVerification.this, cityArray, cities_dropdown_editTextInputLayout);
                        break;
                    case "Haryana":
                        cityArray = getResources().getStringArray(R.array.haryana_cities);
                        commonMethods.setDropdown(EmailVerification.this, cityArray, cities_dropdown_editTextInputLayout);
                        break;
                    case "Himachal Pradesh":
                        cityArray = getResources().getStringArray(R.array.himachal_cities);
                        commonMethods.setDropdown(EmailVerification.this, cityArray, cities_dropdown_editTextInputLayout);
                        break;
                    case "Karnataka":
                        cityArray = getResources().getStringArray(R.array.karnataka_cities);
                        commonMethods.setDropdown(EmailVerification.this, cityArray, cities_dropdown_editTextInputLayout);
                        break;
                    case "Punjab":
                        cityArray = getResources().getStringArray(R.array.punjab_cities);
                        commonMethods.setDropdown(EmailVerification.this, cityArray, cities_dropdown_editTextInputLayout);
                        break;
                    case "Rajasthan":
                        cityArray = getResources().getStringArray(R.array.rajasthan_cities);
                        commonMethods.setDropdown(EmailVerification.this, cityArray, cities_dropdown_editTextInputLayout);
                        break;
                }
            }
        });
    }
}