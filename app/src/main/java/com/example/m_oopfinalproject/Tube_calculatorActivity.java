package com.example.m_oopfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Tube_calculatorActivity extends AppCompatActivity {

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

    public  void  calculate (View view){

        float height = Float.parseFloat(txtHeight.getText().toString());
        float radius = Float.parseFloat(txtRadius.getText().toString());
        float jarijari = radius/2;

        float hasil = (float) (3.14 * jarijari * jarijari * height);

        String jawaban = "" + hasil + " cm^3";
        txtResult.setText(jawaban);

    }

}
