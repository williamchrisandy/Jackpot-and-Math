package com.example.m_oopfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Intent intent = getIntent();
//        String name = getIntent().getStringExtra("KEY_NAME"); //cannot use intent because name won't be saved

        SharedPreferences save = PreferenceManager.getDefaultSharedPreferences(this);
        String name = save.getString("KEY_NAME", "NoName");

        title = findViewById(R.id.mainTitle);
        title.setText(name);
    }
    @Override
    public void onBackPressed(){
        Toast.makeText(getApplicationContext(),"App Terminated",Toast.LENGTH_SHORT).show();
        finish();
    }
    public void toPhytagoras(View view) {
        Intent intent = new Intent(this, PhytagorasActivity.class);
        startActivity(intent);
        finish();
    }
    public void toQuadratic(View view) {
        Intent intent = new Intent(this, QuadraticActivity.class);
        startActivity(intent);
        finish();
    }
    public void toTube(View view) {
        Intent intent = new Intent(this, Tube_calculatorActivitv2.class);
        startActivity(intent);
        finish();
    }
    public void toJackpotGBK(View view) {
        Intent intent = new Intent(this, JackpotGBKActivity.class);
        startActivity(intent);
        finish();
    }

}
