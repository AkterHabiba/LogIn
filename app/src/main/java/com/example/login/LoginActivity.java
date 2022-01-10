package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private Button btn_login;
    private Button btn_signup;
    private final String CREDENTAL_SHARE_PREF="our_shared_pref";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username= findViewById(R.id.username);
        password = findViewById(R.id.password);
        btn_login= (Button) findViewById(R.id.btn_login);
        btn_signup = (Button) findViewById(R.id.btn_signup);

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
                btn_login.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SharedPreferences credentials = getSharedPreferences(CREDENTAL_SHARE_PREF, Context.MODE_PRIVATE);
                        String strUsername = credentials.getString("username", null);
                        String strPassword = credentials.getString("password", null);


                        String username_from_ed = username.getText().toString();
                        String password_from_ed = password.getText().toString();
                        if (strUsername != null && username_from_ed != null && strUsername.equalsIgnoreCase(username_from_ed)) {
                            if (strPassword != null && password_from_ed != null && strPassword.equalsIgnoreCase(password_from_ed)) {
                                Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(LoginActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            Toast.makeText(LoginActivity.this, "Longin failed", Toast.LENGTH_SHORT).show();

                        }
                    }

                });

                }
    }




