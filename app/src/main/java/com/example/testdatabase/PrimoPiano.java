package com.example.testdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class PrimoPiano extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primo_piano);
        getSupportActionBar().setTitle("Primo Piano");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
