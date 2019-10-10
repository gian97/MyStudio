package com.example.testdatabase;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
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
    Button bview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aula_studio);
        getSupportActionBar().setTitle("Aula Studio");

        final TextView mail = (TextView) findViewById(R.id.useras);
        Bundle bundleas = this.getIntent().getExtras();
        mail.setText(bundleas.getString("email"));

        db = new DatabaseHelper(this);
        e2 = (EditText) findViewById(R.id.pianoas);
        e3 = (EditText) findViewById(R.id.tavoloas);

        b1 = (Button) findViewById(R.id.pas);
        bview = (Button)findViewById(R.id.visualizza_as);

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

        String s2 = mail.getText().toString();
        viewAll(s2);

    }

    public void viewAll(final String email){
        bview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = db.getAllData();
                if(res.getCount() == 0){
                    Toast.makeText(getApplicationContext(), "Nessuna prenotazione esistente", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    String c = res.getString(0);
                    if(c.equals(email)){
                        buffer.append("\nPiano:  " + res.getString(1));
                        buffer.append("\n\n\nTavolo numero:  " + res.getString(2)+"\n\n");
                    }
                }
                showMessage("La tua prenotazione attiva",buffer.toString());
            }
        });
    }

    public void showMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();

    }
}
