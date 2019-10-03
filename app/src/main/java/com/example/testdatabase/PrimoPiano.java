package com.example.testdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PrimoPiano extends AppCompatActivity {

    DatabaseHelper db;
    EditText e1, e2, e3;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primo_piano);
        getSupportActionBar().setTitle("Primo Piano");

        final TextView mail = (TextView) findViewById(R.id.userpp);
        Bundle bundlepp = this.getIntent().getExtras();
        mail.setText(bundlepp.getString("email"));
        e2 = (EditText) findViewById(R.id.pianopp);
        e3 = (EditText) findViewById(R.id.tavolopp);

        b1 = (Button) findViewById(R.id.ppp);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Prenotazione Primo Piano", Toast.LENGTH_SHORT).show();

            }
        });

    }
}
