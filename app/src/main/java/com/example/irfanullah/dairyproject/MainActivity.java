package com.example.irfanullah.dairyproject;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView welcome;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intiObjects();

    }

    public void intiObjects(){
        welcome = findViewById(R.id.welcomeTxt);
        //1
        Bundle bundle = getIntent().getExtras();
        String username = bundle.getString("username");
        //2
        //String uname = getIntent().getExtras().getString("username");
        welcome.setText(username);

    }
}
