package com.example.m_oopfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class JackpotGBKActivity extends AppCompatActivity {
    // This is a Java port of "Jackpot GBK" (https://github.com/reinhart1010/jackpotgbk/) web game,
    // while utilizing Object-Oriented Programming concept and rewritten from scratch. Unlike the
    // original game, multiple users cannot play the slot at the same time, as the slot selection
    // process are handled on a separate Activity.
    //
    // For more information on how this game works, see https://reinhart1010.github.io/jackpotgbk/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jackpotgbk);
    }
}
