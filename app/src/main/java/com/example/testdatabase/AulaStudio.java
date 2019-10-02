package com.example.testdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class AulaStudio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aula_studio);
        getSupportActionBar().setTitle("Aula Studio");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
