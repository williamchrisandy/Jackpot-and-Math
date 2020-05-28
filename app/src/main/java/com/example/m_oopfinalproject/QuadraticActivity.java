package com.example.m_oopfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class QuadraticActivity extends AppCompatActivity
{
    EditText aInput, bInput, cInput;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quadratic);

        aInput = findViewById(R.id.q2fc_a);
        bInput = findViewById(R.id.q2fc_b);
        cInput = findViewById(R.id.q2fc_c);
        result = findViewById(R.id.q2fc_calculate_result_output);
    }

    public void onBackPressed(){
        finish();
    }

    public void q2fcBack(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private String q2fcQuadraticCalculate(double a, double b, double c)
    {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String resultString = "Fungsi Kuadrat (Quadratic Function)\n";
        resultString += a>0? "- Kurva terbuka ke atas\n" : "- Kurva terbuka ke bawah\n";
        resultString += "- Kurva memotong sumbu y di titik (0," + (int) c + ")\n";

        double D = b*b - 4*a*c;
        if(D==0) resultString += "- Kurva menyinggung sumbu x di titik puncak kurva: (" + (((-b)/(2.00*a)) - (int) ((-b)/(2.00*a)) == 0? (int) ((-b)/(2.00*a)) : decimalFormat.format((-b)/(2.00*a))) + " ,0)\n";
        else
        {
            if(D<0) resultString += "- Kurva tidak memotong atau menyinggung sumbu x\n";
            else resultString += "- Kurva memotong sumbu x di titik (" + (((-b) / (2.00 * a) + Math.sqrt(D) / (2.00 * a)) - (int) ((-b) / (2.00 * a) + Math.sqrt(D) / (2.00 * a)) == 0? (int) ((-b) / (2.00 * a) + Math.sqrt(D) / (2.00 * a)) : decimalFormat.format((-b) / (2.00 * a) + Math.sqrt(D) / (2.00 * a))) + ",0) dan (" + (((-b) / (2.00 * a) - Math.sqrt(D) / (2.00 * a)) - (int) ((-b) / (2.00 * a) - Math.sqrt(D) / (2.00 * a)) == 0? (int) ((-b) / (2.00 * a) - Math.sqrt(D) / (2.00 * a)) : decimalFormat.format((-b) / (2.00 * a) - Math.sqrt(D) / (2.00 * a))) + ",0)\n";
            resultString += "- Titik puncak kurva berada di titik (" + (((-b)/(2.00*a)) - (int) ((-b)/(2.00*a)) == 0? (int) ((-b)/(2.00*a)) : decimalFormat.format((-b)/(2.00*a))) + "," + (((-D)/(4.00*a)) - (int) ((-D)/(4.00*a)) == 0? (int) ((-D)/(4.00*a)) : decimalFormat.format((-D)/(4.00*a))) + ")\n";
        }

        return resultString;
    }

    private String q2fcLinearCalculate(double b, double c)
    {
        String resultString = "Fungsi Linear (Linear Function)\n";
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        resultString += "- Gradien = " + (int) b + "\n";
        resultString += "- Kurva memotong sumbu x di titik (" + ((-c/b) - (int) (-c/b) == 0? (int) (-c/b) : decimalFormat.format(-c/b)) + ",0)\n";
        resultString += "- Kurva memotong sumbu y di titik (0," + (int) c + ")\n";
        return resultString;
    }

    private String q2fcConstantCalculate(double c)
    {
        String resultString = "Fungsi Konstan (Constant Function)\n";
        resultString += "- Gradien = 0\n";
        resultString += "- Kurva memotong sumbu y di titik (0," + (int) c + ")\n";
        return resultString;
    }

    public void q2fcCalculate(View view)
    {
        double a = 0, b = 0, c = 0;
        String aString, bString, cString, resultString;

        aString = aInput.getText().toString();
        bString = bInput.getText().toString();
        cString = cInput.getText().toString();

        try {a = Double.valueOf(aString);} catch(Exception e) {a = 0;}
        try {b = Double.valueOf(bString);} catch(Exception e) {b = 0;}
        try {c = Double.valueOf(cString);} catch(Exception e) {c = 0;}

        resultString = (a!=0? q2fcQuadraticCalculate(a,b,c): (b!=0? q2fcLinearCalculate(b,c): q2fcConstantCalculate(c)));
        result.setText(resultString);
    }
}
