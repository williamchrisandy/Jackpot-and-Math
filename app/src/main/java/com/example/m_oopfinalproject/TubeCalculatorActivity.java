package com.example.m_oopfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class TubeCalculatorActivity extends AppCompatActivity {

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
        txtResult.setTextColor(Color.parseColor("#000000"));
    }

    public void onBackPressed(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public  void  calculate (View view){
        float height = 0;
        float radius = 0;

        try {
            height = Float.parseFloat(txtHeight.getText().toString());
            radius = Float.parseFloat(txtRadius.getText().toString());

        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"Please input number",Toast.LENGTH_SHORT).show();
            return;
        }

        double hasil = (double) (Math.PI * radius * radius* height);
        DecimalFormat df = new DecimalFormat("0.00");

        String jawaban = "" + df.format(hasil)+ " cm^3";
        txtResult.setText(jawaban);

    }

}
