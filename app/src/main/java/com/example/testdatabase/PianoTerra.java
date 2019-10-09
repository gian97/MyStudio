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


        db = new DatabaseHelper(this);
        e2 = (EditText) findViewById(R.id.pianopt);
        e3 = (EditText) findViewById(R.id.tavolopt);


        b1 = (Button) findViewById(R.id.ppt);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String s1 = mail.getText().toString();
                String s2 = e2.getText().toString();
                String s3 = e3.getText().toString();

                if (s1.equals("") || s2.equals("") || s3.equals("")) {
                    Toast.makeText(getApplicationContext(), "Dati non inseriti", Toast.LENGTH_SHORT).show();
                }
                else {
                    Boolean controllo = db.chkprem(s1);
                    if (controllo == true) {
                        Boolean prova = db.prenote(s1, s2, s3);
                        Toast.makeText(getApplicationContext(), "Prenotazione avvenuta", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Hai già eseguito una prenotazione", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }


}
