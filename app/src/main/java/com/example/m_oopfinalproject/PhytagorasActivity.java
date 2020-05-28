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

public class PhytagorasActivity extends AppCompatActivity {

    EditText num1, num2;
    TextView Result, triangleAtt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phytagoras);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        Result = findViewById(R.id.Result);
        Result.setTextColor(Color.parseColor("#FF0000"));
        triangleAtt = findViewById(R.id.triangleAtt);
        triangleAtt.setTextColor(Color.parseColor("#000000"));
    }

    public void backButton(View view){
        Intent intentBack = new Intent(this, MainActivity.class);

        startActivity(intentBack);
    }

    public void calculateA(View view){
        double number1 = 0;
        double number2 = 0;
        try {
             number1 = Double.parseDouble(num1.getText().toString());
             number2 = Double.parseDouble(num2.getText().toString());
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"Must input a number",Toast.LENGTH_SHORT).show();
            return;
        }

        if(number1 == 0 || number2 == 0 ){
            Toast.makeText(getApplicationContext(),"Length must be greater than zero",Toast.LENGTH_SHORT).show();
            return;
        }

        if(number1 > number2){
            double c = number1;
            double b = number2;
            double power = (c*c)-(b*b);
            double res = Math.sqrt(power);
            DecimalFormat df = new DecimalFormat("0.00");
            String result = "A = " + df.format(res);
            Result.setText(result);
            double area = (res*b)/2;
            double perimeter = res+b+c;
            String attribute = "    Triangle Attribute :\n    Area           = " + df.format(area) + "\n    Perimeter  = " + df.format(perimeter);
            triangleAtt.setText(attribute);

        }else if (number1 < number2){
            double b = number1;
            double c = number2;
            double power = (c*c)-(b*b);
            double res = Math.sqrt(power);
            DecimalFormat df = new DecimalFormat("0.00");
            String result = "A = " + df.format(res);
            Result.setText(result);
            double area = (res*b)/2;
            double perimeter = res+b+c;
            String attribute = "    Triangle Attribute :\n    Area           = " + df.format(area) + "\n    Perimeter  = " + df.format(perimeter);
            triangleAtt.setText(attribute);

        }else {
            Toast.makeText(getApplicationContext(),"Number cannot be the same",Toast.LENGTH_SHORT).show();
        }

    }

    public void calculateB(View view){
        double number1 = 0;
        double number2 = 0;
        try {
            number1 = Double.parseDouble(num1.getText().toString());
            number2 = Double.parseDouble(num2.getText().toString());
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"Must input a number",Toast.LENGTH_SHORT).show();
            return;
        }

        if(number1 == 0 || number2 == 0 ){
            Toast.makeText(getApplicationContext(),"Length must be greater than zero",Toast.LENGTH_SHORT).show();
            return;
        }

        if(number1 > number2){
            double c = number1;
            double a = number2;
            double power = (c*c)-(a*a);
            double res = Math.sqrt(power);
            DecimalFormat df = new DecimalFormat("0.00");
            String result = "B = " + df.format(res);
            Result.setText(result);
            double area = (res*a)/2;
            double perimeter = res+a+c;
            String attribute = "    Triangle Attribute :\n    Area           = " + df.format(area) + "\n    Perimeter  = " + df.format(perimeter);
            triangleAtt.setText(attribute);
        }else if (number1 < number2){
            double a = number1;
            double c = number2;
            double power = (c*c)-(a*a);
            double res = Math.sqrt(power);
            DecimalFormat df = new DecimalFormat("0.00");
            String result = "B = " + df.format(res);
            Result.setText(result);
            double area = (a*res)/2;
            double perimeter = a+res+c;
            String attribute = "    Triangle Attribute :\n    Area           = " + df.format(area) + "\n    Perimeter  = " + df.format(perimeter);
            triangleAtt.setText(attribute);
        }else {
            Toast.makeText(getApplicationContext(),"Number cannot be the same",Toast.LENGTH_SHORT).show();
        }

    }

    public void calculateC(View view){
        double number1 = 0;
        double number2 = 0;
        try {
            number1 = Double.parseDouble(num1.getText().toString());
            number2 = Double.parseDouble(num2.getText().toString());
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"Must input a number",Toast.LENGTH_SHORT).show();
            return;
        }

        if(number1 == 0 || number2 == 0 ){
            Toast.makeText(getApplicationContext(),"Length must be greater than zero",Toast.LENGTH_SHORT).show();
            return;
        }

            double a = number1;
            double b = number2;
            double power = (a*a)+(b*b);
            double res = Math.sqrt(power);
            DecimalFormat df = new DecimalFormat("0.00");
            String result = "C = " + df.format(res);
            Result.setText(result);
            double area = (a*b)/2;
            double perimeter = a+b+res;
            String attribute = "    Triangle Attribute :\n    Area           = " + df.format(area) + "\n    Perimeter  = " + df.format(perimeter);
            triangleAtt.setText(attribute);

    }

}
