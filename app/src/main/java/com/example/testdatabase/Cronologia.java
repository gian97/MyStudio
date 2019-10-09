package com.example.testdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Cronologia extends AppCompatActivity {

    DatabaseHelper db;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cronologia);
        getSupportActionBar().setTitle("Cronologia Prenotazioni");

        final TextView mail = (TextView) findViewById(R.id.userpren);
        Bundle bundlex = this.getIntent().getExtras();
        mail.setText(bundlex.getString("email"));


        db = new DatabaseHelper(this);
        b1 =(Button) findViewById(R.id.cancella);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = mail.getText().toString();

                if (s1.equals("admin1@studenti.unimore.it")) {
                    Integer y = db.deleteall();
                    Toast.makeText(getApplicationContext(), "Sei admin, stai cancellando tutto", Toast.LENGTH_SHORT).show();
                }
                else{
                Boolean controllo = db.chkprem(s1);
                if(controllo == true){
                    Toast.makeText(getApplicationContext(), "Non hai ancora prenotato nulla", Toast.LENGTH_SHORT).show();
                }
                else {
                        Integer x = db.deletedata(s1);
                        if (x == 1)
                            Toast.makeText(getApplicationContext(), "Cancellata la prenotazione", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
