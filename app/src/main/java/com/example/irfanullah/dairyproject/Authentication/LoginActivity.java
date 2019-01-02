package com.example.irfanullah.dairyproject.Authentication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.irfanullah.dairyproject.MainActivity;
import com.example.irfanullah.dairyproject.R;
import com.example.irfanullah.dairyproject.Storage.PrefStorage;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    EditText usernam, pass;
    Button btnLogin;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initObjects();
    }

    private void initObjects(){
        usernam = findViewById(R.id.username);
        pass = findViewById(R.id.password);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btnLogin:
                login();
                break;
        }
    }

    public void login(){
        String enteredUsername = usernam.getText().toString();
        enteredUsername = enteredUsername.toLowerCase();
        String enteredPass = pass.getText().toString();
        String savedUsername = PrefStorage.getSharedPreferences(this).getString("username","");
        String savedPassword = PrefStorage.getSharedPreferences(this).getString("password","");
        if(enteredUsername.equals(savedUsername) && enteredPass.equals(savedPassword)){
            Intent intent = new Intent(this,MainActivity.class);
            intent.putExtra("username",savedUsername);
            startActivity(intent);
        }else {
            PrefStorage.toastHere(this,"Invalid password and username");
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
