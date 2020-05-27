package com.example.m_oopfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        String name = intent.getStringExtra("username");
        title = findViewById(R.id.mainTitle);
        title.setText(name);
    }
    @Override
    public void onBackPressed(){
        Toast.makeText(getApplicationContext(),"Can't go back to previous page!",Toast.LENGTH_SHORT).show();
    }
    public void toPhytagoras(View view) {
        Intent intent = new Intent(this, PhytagorasActivity.class);
        startActivity(intent);
    }
    public void toQuadratic(View view) {
        Intent intent = new Intent(this, QuadraticActivity.class);
        startActivity(intent);
    }
    public void toTube(View view) {
        Intent intent = new Intent(this, Tube_calculatorActivitv2.class);
        startActivity(intent);
    }
    public void toJackpotGBK(View view) {
        Intent intent = new Intent(this, JackpotGBKActivity.class);
        startActivity(intent);
    }

}
