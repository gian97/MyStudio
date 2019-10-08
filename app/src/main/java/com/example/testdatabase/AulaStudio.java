package com.example.testdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AulaStudio extends AppCompatActivity {

    DatabaseHelper db;
    EditText e1, e2, e3;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aula_studio);
        getSupportActionBar().setTitle("Aula Studio");

        final TextView mail = (TextView) findViewById(R.id.useras);
        Bundle bundleas = this.getIntent().getExtras();
        mail.setText(bundleas.getString("email"));
        e2 = (EditText) findViewById(R.id.pianoas);
        e3 = (EditText) findViewById(R.id.tavoloas);

        b1 = (Button) findViewById(R.id.pas);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int num = Integer.parseInt(e3.getText().toString());
                if(num >= 1 && num <= 5)
                Toast.makeText(getApplicationContext(), "Prenotazione Aula Studio", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), "Numero tavolo sbagliato", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
