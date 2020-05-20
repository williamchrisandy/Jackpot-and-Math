package com.example.m_oopfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toRandom(View view) {
        Intent intent = new Intent(this, RandomActivity.class);
        startActivity(intent);
    }
    public void toPhytagoras(View view) {
        Intent intent = new Intent(this, PhytagorasActivity.class);
        startActivity(intent);
    }
    public void toQuadratic(View view) {
        Intent intent = new Intent(this, QuadraticActivity.class);
        startActivity(intent);
    }

}
