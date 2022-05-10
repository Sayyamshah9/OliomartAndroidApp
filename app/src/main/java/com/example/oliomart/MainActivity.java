package com.example.oliomart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.oliomart.fragments.AccountFragment;
import com.example.oliomart.fragments.CartFragment;
import com.example.oliomart.fragments.HomeFragment;
import com.example.oliomart.fragments.OrdersFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView mainBottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //FETCHING VIEWS
        mainBottomNavigationView = findViewById(R.id.bottomBarContainer_id);

        //Setting Default Fragment
        replaceFragment(new HomeFragment());

        mainBottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.home:
                        replaceFragment(new HomeFragment());
                        break;
                    case R.id.cart:
                        replaceFragment(new CartFragment());
//                        Toast.makeText(MainActivity.this, "Cart", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.orders:
                        replaceFragment(new OrdersFragment());
//                        Toast.makeText(MainActivity.this, "Orders", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.account:
                        replaceFragment(new AccountFragment());
//                        Toast.makeText(MainActivity.this, "Account", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
    }

    public void replaceFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.mainActivityFrameLayout_id, fragment, "");
        fragmentTransaction.commit();
    }
}