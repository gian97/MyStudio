package com.example.testdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class PianoTerra extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piano_terra);
        getSupportActionBar().setTitle("Piano Terra");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
