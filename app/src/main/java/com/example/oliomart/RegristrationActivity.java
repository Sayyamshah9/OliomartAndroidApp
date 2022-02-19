package com.example.oliomart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.oliomart.config.ApiClient;
import com.example.oliomart.config.CommonMethods;
import com.example.oliomart.config.RequestsInterface;
import com.example.oliomart.modals.UserModalClass;
import com.example.oliomart.requests.NewUser;
import com.example.oliomart.validations.RegristrationValidation;
import com.google.android.material.textfield.TextInputLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegristrationActivity extends AppCompatActivity {

    TextView login_txt_btn;
    AutoCompleteTextView gender_dropdown_editTextInputLayout;
    TextInputLayout firstname, lastname, phoneno, emailid, password, confirmpassword, genderDropdown_textInputLayout;
    Button registerbtn;
    String firstnameString, lastnameString, username, phonenoString, genderString, emailString, passwordString, confirmpasswordString;
    CommonMethods commonMethods = new CommonMethods();
    RegristrationValidation regristrationValidation = new RegristrationValidation();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //CODE TO SET AUTOFILL OFF
        getWindow().getDecorView().setImportantForAutofill(View.IMPORTANT_FOR_AUTOFILL_NO_EXCLUDE_DESCENDANTS);
        setContentView(R.layout.activity_regristration);

        //FETCHING VIEWS
        login_txt_btn = findViewById(R.id.login_txt_btn);
        gender_dropdown_editTextInputLayout = findViewById(R.id.gender_dropdown_editTextInputLayout);
        firstname = findViewById(R.id.firstname_textInputLayout);
        lastname = findViewById(R.id.lastname_editTextInputLayout);
        phoneno = findViewById(R.id.phoneNo_textInputLayout);
        emailid = findViewById(R.id.email_textInputLayout);
        password = findViewById(R.id.password_textInputLayout);
        confirmpassword = findViewById(R.id.confirmpassword_textInputLayout);
        registerbtn = findViewById(R.id.signupBtn);
        genderDropdown_textInputLayout = findViewById(R.id.genderDropdown_textLayout);

        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Fetching data from input fields
                firstnameString = firstname.getEditText().getText().toString().trim();
                lastnameString = lastname.getEditText().getText().toString();
                username = firstnameString + " " + lastnameString;
                phonenoString = phoneno.getEditText().getText().toString();
                emailString = emailid.getEditText().getText().toString();
                passwordString = password.getEditText().getText().toString();
                confirmpasswordString = confirmpassword.getEditText().getText().toString();
                genderString = gender_dropdown_editTextInputLayout.getText().toString();

                //Validations
                if(regristrationValidation.isFirstNameValid(firstnameString, firstname) && regristrationValidation.isLastNameValid(lastnameString, lastname) && regristrationValidation.isEmailValid(emailString, emailid) && regristrationValidation.isPhoneNoValid(phonenoString, phoneno) && regristrationValidation.isGenderValid(genderString, genderDropdown_textInputLayout) && regristrationValidation.isPasswordValid(passwordString, password) && regristrationValidation.isConfirmPasswordValid(confirmpasswordString, passwordString, confirmpassword)){
                    //Sending data to backend
                    NewUser newUser = new NewUser(RegristrationActivity.this);
                    newUser.registerNewUser(username, emailString, phonenoString, passwordString, confirmpasswordString, genderString );
                }
            }
        });

        login_txt_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                commonMethods.setIntent(RegristrationActivity.this, LoginActivity.class);
                finish();
            }
        });

        String[] genderArray = getResources().getStringArray(R.array.gender);
        ArrayAdapter genderAdapter = new ArrayAdapter(RegristrationActivity.this, R.layout.dropdownelement, genderArray);
        gender_dropdown_editTextInputLayout.setAdapter(genderAdapter);

    }

//    public void registerNewUser(Context context, String username, String email, String phone, String password, String confirmpassword, String gender){
//
//        ApiClient apiClient = new ApiClient();
//        RequestsInterface requestsInterface = apiClient.retrofit.create(RequestsInterface.class);
//
//        UserModalClass userModalClass = new UserModalClass(username, email, phone, password, confirmpassword, gender);
//        Call<UserModalClass> userModalClassCall = requestsInterface.registerNewUser(userModalClass);
//
//        userModalClassCall.enqueue(new Callback<UserModalClass>() {
//            @Override
//            public void onResponse(Call<UserModalClass> call, Response<UserModalClass> response) {
//
////                UserModalClass umc  = response.body();
//                Toast.makeText(context, response.code(), Toast.LENGTH_SHORT).show();
//            }
//            @Override
//            public void onFailure(Call<UserModalClass> call, Throwable t) {
//                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
}