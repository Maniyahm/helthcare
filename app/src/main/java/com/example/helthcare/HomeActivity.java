package com.example.helthcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefer", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "");
        Toast.makeText(getApplicationContext(), "welcome" + username, Toast.LENGTH_SHORT).show();

        CardView exit = findViewById(R.id.cardexit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();
                startActivity(new Intent(HomeActivity.this, loginActivity.class));
                finish(); // Optional: This will close the current activity after logging out.
            }
        });

        CardView findDoctor = findViewById(R.id.cardfinddoctor);
        findDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, FinddoctorActivity.class));
            }
        });
        CardView labtest = findViewById(R.id.cardLabTest);
        labtest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,labTestActivity.class));
            }
        });
       /* CardView Orderdetails = findViewById(R.id.cardorderdetails);
        labtest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,OrderdetaailActivity.class));
            }
        });
        CardView Buymedicine = findViewById(R.id.cardorderdetails);
        labtest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,BuymedicineActivity.class));
            }
        });*/

    }
}
