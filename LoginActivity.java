package com.example.icare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import static android.widget.Toast.makeText;

public class LoginActivity extends AppCompatActivity {
    public  EditText username , password;
    public  Button buttonlogin, buttonreset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.input_username);
        password = (EditText) findViewById(R.id.input_password);
        buttonlogin = (Button) findViewById(R.id.btnlogin);
        buttonreset = (Button) findViewById(R.id.btnreset) ;

        buttonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernamee = username.getText().toString();
                String passwordd =  password.getText().toString();

                if (usernamee.equals("admin") && passwordd.equals("123")){
                    Toast.makeText(getApplicationContext(),"Login Success..",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, AdminActivity.class);
                    startActivity(intent);

                }else  if(usernamee.equals("client") && passwordd.equals("123")){
                    Toast.makeText(getApplicationContext(),"Login Success..",Toast.LENGTH_SHORT).show();
                    Intent intentt = new Intent(LoginActivity.this, ClientActivity.class);
                    startActivity(intentt);
                }
                else {
                    makeText(getApplicationContext(),"Username and password invalid",Toast.LENGTH_SHORT).show();
                }
            }
        });
        buttonreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username.setText(" ");
                password.setText(" ");
            }
        });
    }
}

