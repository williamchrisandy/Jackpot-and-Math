package com.example.m_oopfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class    PhytagorasActivity extends AppCompatActivity {

    EditText num1, num2;
    TextView Result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phytagoras);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        Result = findViewById(R.id.Result);
        Result.setTextColor(Color.parseColor("#FF0000"));
    }

    public void backButton(View view){
        Intent intentBack = new Intent(this, MainActivity.class);

        startActivity(intentBack);
    }

    public void calculateA(View view){
        double number1 = Double.parseDouble(num1.getText().toString());
        double number2 = Double.parseDouble(num2.getText().toString());

        if(number1 > number2){
            double c = number1;
            double b = number2;
            double power = (c*c)-(b*b);
            double res = Math.sqrt(power);
            String result = Double.toString(res);
            Result.setText(result);
        }else if (number1 < number2){
            double b = number1;
            double c = number2;
            double power = (c*c)-(b*b);
            double res = Math.sqrt(power);
            String result = Double.toString(res);
            Result.setText(result);
        }else {
            String result = "Number cannot be the same";
            Result.setText(result);
        }

    }

    public void calculateB(View view){
        double number1 = Double.parseDouble(num1.getText().toString());
        double number2 = Double.parseDouble(num2.getText().toString());

        if(number1 > number2){
            double c = number1;
            double a = number2;
            double power = (c*c)-(a*a);
            double res = Math.sqrt(power);
            String result = Double.toString(res);
            Result.setText(result);
        }else if (number1 < number2){
            double a = number1;
            double c = number2;
            double power = (c*c)-(a*a);
            double res = Math.sqrt(power);
            String result = Double.toString(res);
            Result.setText(result);
        }else {
            String result = "Number cannot be the same";
            Result.setText(result);
        }

    }

    public void calculateC(View view){
        double number1 = Double.parseDouble(num1.getText().toString());
        double number2 = Double.parseDouble(num2.getText().toString());


            double a = number1;
            double b = number2;
            double power = (a*a)+(b*b);
            double res = Math.sqrt(power);
            String result = Double.toString(res);
            Result.setText(result);

    }

}
