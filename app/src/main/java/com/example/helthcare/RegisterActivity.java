package com.example.helthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText edusername,edEmail,edPassword,edconfirm;
    Button btn;
    TextView textView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        edusername=findViewById(R.id.editTextAppFullName);
        edPassword=findViewById(R.id.editTextAppAdress);
        edEmail=findViewById(R.id.editFees);
        edconfirm=findViewById(R.id.editTextCoAppContactNumber);
        btn=findViewById(R.id.buttonBookAppoitnment);
        textView=findViewById(R.id.textView6);


        textView.setOnClickListener(view -> startActivity(new Intent(RegisterActivity.this, loginActivity.class)));
        btn.setOnClickListener(view -> {
            String username= edusername.getText().toString();
            String password= edPassword.getText().toString();
            String confirm= edconfirm.getText().toString();
            String email= edEmail.getText().toString();
            Database db = new Database(getApplicationContext(),"helthcare",null,1);
            if (username.length()==0 || password.length()==0 || email.length()==0 || confirm.length()==0) {
                Toast.makeText(getApplicationContext(), "please fill all detail", Toast.LENGTH_SHORT).show();
            }
            else {
                if (password.compareTo(confirm) == 0) {
                    db.register(username,email,password);
                    Toast.makeText(RegisterActivity.this, "recorde inserted", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(RegisterActivity.this, loginActivity.class));

                } else {
                    Toast.makeText(getApplicationContext(), "password and confirm password didn't match", Toast.LENGTH_SHORT).show();
                }
            }


        });
        class PasswordValidator {

            public boolean isPasswordValid(String password) {
                boolean hasMinLength = password.length() >= 8;
                boolean hasUppercase = false;
                boolean hasLowercase = false;
                boolean hasDigit = false;
                boolean hasSpecialChar = false;

                for (char c : password.toCharArray()) {
                    if (Character.isUpperCase(c)) {
                        hasUppercase = true;
                    } else if (Character.isLowerCase(c)) {
                        hasLowercase = true;
                    } else if (Character.isDigit(c)) {
                        hasDigit = true;
                    } else {
                        String specialCharacters = "!@#$%^&*()_-+=";
                        if (specialCharacters.indexOf(c) != -1) {
                            hasSpecialChar = true;
                        }
                    }
                }

                return hasMinLength && hasUppercase && hasLowercase && hasDigit && hasSpecialChar;
            }

            public void main(String[] args) {
                String password = "MyP@ssw0rd";
                boolean isValid = isPasswordValid(password);
                System.out.println("Is valid password? " + isValid);
            }
        }


    }
}