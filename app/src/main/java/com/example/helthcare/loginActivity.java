package com.example.helthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity {

    EditText edUsername, edPassword;
    Button btn;
    TextView textView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edUsername=findViewById(R.id.editTextAppFullName);
        edPassword=findViewById(R.id.editTextAppAdress);
        btn=findViewById(R.id.buttonBookAppoitnment);
        textView=findViewById(R.id.textView3);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username= edUsername.getText().toString();
                String password= edPassword.getText().toString();
                Database db = new Database(getApplicationContext(),"helthcare",null,1);

                if (username.length()==0 || password.length()==0){
                    Toast.makeText(getApplicationContext(),"please fill all detail",Toast.LENGTH_SHORT).show();
                }else {
                    if (db.login(username,password)==1) {
                        Toast.makeText(getApplicationContext(), "login succesfull", Toast.LENGTH_SHORT).show();
                        SharedPreferences sharedPreferences =getSharedPreferences("shared_prefer", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor= sharedPreferences.edit();
                        editor.putString("username",username);
                        editor.apply();

                        Intent intent = new Intent(loginActivity.this, HomeActivity.class);
                        startActivity(intent);



                        // startActivities(new Intent(loginActivity.this, HomeActivity.class));
                       /* btn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                startActivities(new Intent(loginActivity.this, HomeActivity.class));
                            }
                        });*/

                    }else {
                        Toast.makeText(getApplicationContext(), "invalid username or password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(loginActivity.this, RegisterActivity.class));
            }
        });
    }

    private void startActivities(Intent intent) {
    }
}