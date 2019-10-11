package com.example.testdatabase;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Cronologia extends AppCompatActivity {

    DatabaseHelper db;
    Button bpp;
    Button bpt;
    Button bas;
    String s1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cronologia);
        getSupportActionBar().setTitle("Posti Disponibili");



        db = new DatabaseHelper(this);

        bpp = (Button) findViewById(R.id.pp);
        bpt = (Button) findViewById(R.id.pt);
        bas = (Button) findViewById(R.id.as);
        StringBuffer buffer;

        bpp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String[] numbers = new String[14];
                StringBuffer buffer = new StringBuffer();

                int res = db.getAllSeattotPP();
                int tot = 104;
                int disp = tot - res;

                buffer.append("\nNumero posti disponibili:  "+disp + "\n\n");

                Integer x = 1;
                for(int i = 0; i<=13; i++){
                    numbers[i] = x.toString();
                    x++;
                }
                for(int y = 0; y<13; y++){
                    int respp = db.getAllSeatPp(numbers[y].toString());
                    int totpp = 8;
                    int disppp = totpp - respp;

                   int z = y +1;
                    buffer.append("\nNumero posti disponibili tavolo " +z + ":   "  +disppp);
                }

                showMessage("Situazione Primo piano",buffer.toString());
            }


        });


        bpt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] numbers = new String[10];
                StringBuffer buffer = new StringBuffer();

                int res = db.getAllSeattotPT();
                int tot = 72;
                int disp = tot - res;

                buffer.append("\nNumero posti disponibili:  "+disp + "\n\n");

                Integer x = 1;
                for(int i = 0; i<=9; i++){
                    numbers[i] = x.toString();
                    x++;
                }
                for(int y = 0; y<9; y++){
                    int respp = db.getAllSeatPt(numbers[y].toString());
                    int totpp = 8;
                    int disppp = totpp - respp;

                    int z = y+1;
                    buffer.append("\nNumero posti disponibili tavolo " +z+ ":   "  +disppp);
                }

                showMessage("Situazione Piano Terra",buffer.toString());
            }
        });


        bas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String[] numbers = new String[6];
                StringBuffer buffer = new StringBuffer();

                int res = db.getAllSeattotAS();
                int tot = 40;
                int disp = tot - res;

                buffer.append("\nNumero posti disponibili:  "+disp + "\n\n");

                Integer x = 1;
                for(int i = 0; i<=5; i++){
                    numbers[i] = x.toString();
                    x++;
                }
                for(int y = 0; y<5; y++){
                    int respp = db.getAllSeatAs(numbers[y].toString());
                    int totpp = 8;
                    int disppp = totpp - respp;

                    int z = y+1;
                    buffer.append("\nNumero posti disponibili tavolo " +z + ":   "  +disppp);
                }

                showMessage("Situazione Aula Studio",buffer.toString());
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
