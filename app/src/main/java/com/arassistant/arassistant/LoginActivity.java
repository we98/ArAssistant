package com.arassistant.arassistant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button loginButton;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(this);
        registerButton = (Button) findViewById(R.id.registerButton);
        registerButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.loginButton:
                login();
                break;
            case R.id.registerButton:
                register();
                break;
        }
    }

    private void login(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        this.finish();
    }

    private void register(){

    }
}
