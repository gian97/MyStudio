package com.example.testdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class Prenotazione extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    String s1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prenotazione);
        final TextView mail = (TextView) findViewById(R.id.param);
        Bundle bundle = this.getIntent().getExtras();
        mail.setText(bundle.getString("email"));
        getSupportActionBar().setTitle("Home");

        final TextView nome = (TextView) findViewById(R.id.textView3);
        s1 = mail.getText().toString();
        //nome.setText(s1);
    }

    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popup_menu);
        popup.show();
    }

    public void showPrenotazione(View v){
        Intent ac = new Intent(this, Cronologia.class);
        startActivity(ac);
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.pp:
                Bundle bundlepp = new Bundle();
                bundlepp.putString("email", s1);
                Toast.makeText(this, "Scelto primo piano", Toast.LENGTH_SHORT).show();
                Intent i1 = new Intent(Prenotazione.this, PrimoPiano.class);
                i1.putExtras(bundlepp);
                startActivity(i1);
                return true;
            case R.id.pt:
                Bundle bundlept = new Bundle();
                bundlept.putString("email", s1);
                Toast.makeText(this, "Scelto piano terra", Toast.LENGTH_SHORT).show();
                Intent i2 = new Intent(Prenotazione.this, PianoTerra.class);
                i2.putExtras(bundlept);
                startActivity(i2);
                return true;
            case R.id.as:
                Bundle bundleas = new Bundle();
                bundleas.putString("email", s1);
                Toast.makeText(this, "Scelto aula studio", Toast.LENGTH_SHORT).show();
                Intent i3 = new Intent(Prenotazione.this, AulaStudio.class);
                i3.putExtras(bundleas);
                startActivity(i3);
                return true;
            default: return false;
        }
    }
}
