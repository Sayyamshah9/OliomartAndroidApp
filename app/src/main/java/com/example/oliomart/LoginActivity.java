package com.example.oliomart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.oliomart.config.CommonMethods;
import com.example.oliomart.config.SessionManagerClass;
import com.example.oliomart.requests.NewUser;
import com.example.oliomart.validations.LoginValidation;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    TextView signup_txt_btn;
    TextInputLayout loginEmail, loginPassword;
    String stringLoginEmail, stringLoginPassword;
    Button loginBtn;
    CommonMethods commonMethods = new CommonMethods();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //CODE TO SET AUTOFILL OFF
        getWindow().getDecorView().setImportantForAutofill(View.IMPORTANT_FOR_AUTOFILL_NO_EXCLUDE_DESCENDANTS);
        setContentView(R.layout.activity_login);

        SessionManagerClass sessionManager = new SessionManagerClass(getApplicationContext());

        //Session Check - Working well
        sessionManager.isLoggedIn();
        if(sessionManager.isLogin()){
            finish();
        }

        //FETCHING VIEWS
        signup_txt_btn = findViewById(R.id.signup_txt_btn);
        loginEmail = findViewById(R.id.textInputTextEmail);
        loginPassword = findViewById(R.id.textInputTextPassword);
        loginBtn = findViewById(R.id.login_btn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Getting Values from Input Fields
                stringLoginEmail = loginEmail.getEditText().getText().toString();
                stringLoginPassword = loginPassword.getEditText().getText().toString();

                //Validations
                LoginValidation loginValidation = new LoginValidation();
                if(loginValidation.isLoginValid(stringLoginEmail, stringLoginPassword, loginEmail, loginPassword)){
                    //Sending data to Back-end
                    NewUser loginUserFromNewUser = new NewUser(LoginActivity.this);
                    loginUserFromNewUser.loginUser( stringLoginEmail, stringLoginPassword, loginEmail, loginPassword);
                }
            }
        });

        signup_txt_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                commonMethods.setIntent(LoginActivity.this,RegristrationActivity.class);
                finish();
            }
        });
    }
}