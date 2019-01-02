package com.example.irfanullah.dairyproject.Authentication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.irfanullah.dairyproject.MainActivity;
import com.example.irfanullah.dairyproject.R;

public class RegisterationActivity extends AppCompatActivity implements View.OnClickListener{

    EditText usernam, pass;
    Button registerBtn;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration);

        initObjects();

    }


    private void initObjects(){
        usernam = findViewById(R.id.username);
        pass = findViewById(R.id.password);
        registerBtn = findViewById(R.id.btnRegister);
        registerBtn.setOnClickListener(this);

        //preferences and editor objects are initiallized here.
        preferences = getApplicationContext().getSharedPreferences("Diary_db",Context.MODE_PRIVATE);
        editor = preferences.edit();

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btnRegister:
                register();
                break;
        }
    }


    private void register(){
        String name = usernam.getText().toString();
        String pas = pass.getText().toString();

        if(name.isEmpty() || pas.isEmpty()){
            Toast.makeText(this,"Fields can not be empty",Toast.LENGTH_LONG).show();
        }else{
            if(preferences.getString("username","").equals(name.toLowerCase())){
                Toast.makeText(this,"Userame is already taken",Toast.LENGTH_LONG).show();
            }else {
                editor.putString("username", name.toLowerCase());
                editor.putString("password", pas);
                editor.commit();
                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
