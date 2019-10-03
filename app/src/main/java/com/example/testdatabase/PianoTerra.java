package com.example.testdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PianoTerra extends AppCompatActivity {

    DatabaseHelper db;

    EditText e2, e3;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piano_terra);
        getSupportActionBar().setTitle("Piano Terra");

        final TextView mail = (TextView) findViewById(R.id.userpt);
        Bundle bundlept = this.getIntent().getExtras();
        mail.setText(bundlept.getString("email"));

        e2 = (EditText) findViewById(R.id.pianopt);
        e3 = (EditText) findViewById(R.id.tavolopt);

        b1 = (Button) findViewById(R.id.ppt);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Prenotazione Piano Terra", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
