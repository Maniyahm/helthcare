package com.example.helthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class labTestDetailActivity extends AppCompatActivity {
    TextView tvPackageName, edDetails; // Changed EditText to TextView
    EditText tvTotalcost; // Changed TextView to EditText
    Button btnAddtocart, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_detail);

        tvPackageName = findViewById(R.id.TextviewLTDT2);
        tvTotalcost = findViewById(R.id.editTextMultiline); // Changed to EditText
        edDetails = findViewById(R.id.textView5); // Changed to TextView
        btnBack = findViewById(R.id.ButtonGoBack);
        btnAddtocart = findViewById(R.id.buttondetail);

        Intent intent = getIntent();
        tvPackageName.setText(intent.getStringExtra("text1"));
        tvTotalcost.setText(intent.getStringExtra("text2"));
        edDetails.setText("Total Cost: " + intent.getStringExtra("text3") + "/-");

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate back to labTestActivity
                Intent intent = new Intent(labTestDetailActivity.this, labTestActivity.class);
                startActivity(intent);
            }
        });
      btnAddtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("shared_pref", Context.MODE_PRIVATE);
                String username = sharedPreferences.getString("username","").toString();
                String product = tvPackageName.getText().toString();
                float price = Float.parseFloat(intent.getStringExtra("text3").toString());
                
                Database db = new Database(getApplicationContext(),"helthcare",null,1);
                
                if(db.checkCart(username,product)==1){
                    Toast.makeText(getApplicationContext(), "product alredy Added", Toast.LENGTH_SHORT).show();
                }else {
                    db.addCart(username,product,price,"leb");
                    Toast.makeText(getApplicationContext(), "Record Inserted to cart", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(labTestDetailActivity.this,labTestActivity.class));

                }
                
            }

            private void startActivities(Intent intent) {
            }
        });

        btnAddtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("shared_pref", Context.MODE_PRIVATE);
                String username = sharedPreferences.getString("username", "");

                Intent intent = getIntent();
                String product = tvPackageName.getText().toString();
                float price = Float.parseFloat(intent.getStringExtra("text3"));

                Database db = new Database(getApplicationContext(), "helthcare", null, 1);

                if (db.checkCart(username, product) == 1) {
                    Toast.makeText(getApplicationContext(), "Product already Added", Toast.LENGTH_SHORT).show();
                } else {
                    db.addCart(username, product, price, "leb");
                    Toast.makeText(getApplicationContext(), "Record Inserted to cart", Toast.LENGTH_SHORT).show();

                    // Instead of startActivities, use startActivity to go to labTestActivity
                    Intent labTestIntent = new Intent(labTestDetailActivity.this, labTestActivity.class);
                    startActivity(labTestIntent);
                }
            }
        });

    }
}
