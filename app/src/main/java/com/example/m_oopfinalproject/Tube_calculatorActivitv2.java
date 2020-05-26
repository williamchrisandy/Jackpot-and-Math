package com.example.m_oopfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Tube_calculatorActivitv2 extends AppCompatActivity {

    EditText txtHeight;
    EditText txtRadius;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tubecalculator);
        txtHeight = findViewById(R.id.txtHeight);
        txtRadius = findViewById(R.id.txtRadius);
        txtResult = findViewById(R.id.txtResult);

    }

    public  void  backButton (View view){
        Intent intentBack = new Intent(this, MainActivity.class);
        startActivity(intentBack);
    }

    public  void  calculate (View view){
        String text;
        float height = 0;
        float radius = 0;

        try {
            height = Float.parseFloat(txtHeight.getText().toString());
            radius = Float.parseFloat(txtRadius.getText().toString());

        }catch (Exception e){
            text = "Please input number";
            txtResult.setText(text);
            return;
        }




        double hasil = (double) (Math.PI * radius * radius* height);
        DecimalFormat df = new DecimalFormat("0.00");



        String jawaban = "" + df.format(hasil)+ " cm^3";
        txtResult.setText(jawaban);

    }

}
