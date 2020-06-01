package com.example.m_oopfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.inputmethodservice.Keyboard;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import javax.xml.transform.Result;

public class RandomActivity extends AppCompatActivity {

    EditText name, start, stop;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);

        name = findViewById(R.id.inputName);
        start = findViewById(R.id.inputStart);
        stop = findViewById(R.id.inputStop);
        result = findViewById(R.id.result);
    }

    public void onBackPressed(){
        finish();
    }

    public void generate(View view){
        String sName;
        int temp;
        int sStart = 0;
        int sStop = 0;
        String sResult;

        sName = name.getText().toString();
        if(sName.equals("")){
            Toast.makeText(getApplicationContext(),"Name must be entered!",Toast.LENGTH_SHORT).show();
            return;
        }
        try {
            sStart = Integer.parseInt(start.getText().toString());
            sStop = Integer.parseInt(stop.getText().toString());
        }catch(Exception e){
            Toast.makeText(getApplicationContext(),"Input number range!",Toast.LENGTH_SHORT).show();
            return;
        }
        if(sStart>sStop){
            Toast.makeText(getApplicationContext(),"Start range must be smaller than stop range!",Toast.LENGTH_LONG).show();
            return;
        }

        temp = (int)(Math.random() * (sStop-sStart+1) + sStart);

        sResult = "Hello " + sName + temp;

        String username = sResult;
        PreferenceManager.getDefaultSharedPreferences(this).edit().putString("KEY_NAME", String.valueOf(username)).apply();
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("username", username);
        startActivity(intent);
        finish();
    }

}
