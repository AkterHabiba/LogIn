package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Credentials;
import android.net.wifi.hotspot2.pps.Credential;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUpActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    private EditText user_name;
    private EditText passwordS;
    private EditText confirm;
    private Button signup;
    private final String CREDENTIAL_SHARE_PREF="our shared pref";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        user_name= findViewById(R.id.user_name);
        passwordS= findViewById(R.id.passwordS);
        confirm= findViewById(R.id.confirm);
        signup=findViewById(R.id.signup);

       signup.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               SharedPreferences preferences= getSharedPreferences("our shared pref",MODE_PRIVATE);
               String newUser= user_name.getText().toString();
               String newPassword= passwordS.getText().toString();
               String confirPass= confirm.getText().toString();
               SharedPreferences.Editor editor= preferences.edit();
               editor.putString(newUser+newPassword+"data",newUser+"/n"+confirPass);
               editor.commit();
               Intent loginScreen=new Intent(SignUpActivity.this,LoginActivity.class);
               startActivity(loginScreen);
           }
       });

//         signup.setOnClickListener(new View.OnClickListener() {
//             @Override
//             public void onClick(View v) {
//                 String strPassword = passwordS.getText().toString();
//                 String strConfirmpass = confirm.getText().toString();
//                 String strUsername = user_name.getText().toString();
//
//                 if (strPassword != null && strConfirmpass != null && strPassword.equalsIgnoreCase(strConfirmpass)) {
//
//                     SharedPreferences credentials = getSharedPreferences(CREDENTIAL_SHARE_PREF, Context.MODE_PRIVATE);
//                     SharedPreferences.Editor editor = credentials.edit();
//                     editor.putString("Password", strPassword);
//                     editor.putString("Username", strUsername);
//                     editor.commit();
//                     SignUpActivity.this.finish();
//
//                 }
//             }
//         });

    }
}
