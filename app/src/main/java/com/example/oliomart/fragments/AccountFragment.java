package com.example.oliomart.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.oliomart.LoginActivity;
import com.example.oliomart.MainActivity;
import com.example.oliomart.R;
import com.example.oliomart.config.SharedPreferenceClass;

public class AccountFragment extends Fragment {

    View view;
    Button logoutBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_account, container, false);
        logoutBtn = view.findViewById(R.id.Logout_Btn);

        SharedPreferenceClass spClassAccounts = new SharedPreferenceClass(getContext());

        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spClassAccounts.editor.clear();
                spClassAccounts.editor.commit();
                Intent i = new Intent(getContext(), LoginActivity.class);
                i.putExtra("finish", true);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });


        return view;
    }
}