package com.example.helthcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FinddoctorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finddoctor);

        CardView exit = findViewById(R.id.cardinfo);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FinddoctorActivity.this, HomeActivity.class));
            }
        });

        CardView FamilyPhysicisans = findViewById(R.id.cardFDFamilyPhysicisans);
        FamilyPhysicisans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FinddoctorActivity.this, DoctorDetailActivity.class);
                it.putExtra("title", "Family Physicisans");
                startActivity(it);
            }
        });

        CardView Dietistion = findViewById(R.id.cardDietistion);
        Dietistion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FinddoctorActivity.this, DoctorDetailActivity.class);
                it.putExtra("title", "Dietistion");
                startActivity(it);
            }
        });

        CardView Dentist = findViewById(R.id.cardFDDentist);
        Dentist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FinddoctorActivity.this, DoctorDetailActivity.class);
                it.putExtra("title", "Dentist");
                startActivity(it);
            }
        });

        CardView surgon = findViewById(R.id.cardFDsurgeon);
        surgon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FinddoctorActivity.this, DoctorDetailActivity.class);
                it.putExtra("title", "Surgeon");
                startActivity(it);
            }
        });

        CardView Cardiologist = findViewById(R.id.cardFDCardiologist);
        Cardiologist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FinddoctorActivity.this, DoctorDetailActivity.class);
                it.putExtra("title", "Cardiologist");
                startActivity(it);
            }
        });
    }
}
