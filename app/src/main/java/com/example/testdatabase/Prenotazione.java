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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prenotazione);
        final TextView mail = (TextView) findViewById(R.id.param);
        Bundle bundle = this.getIntent().getExtras();
        mail.setText(bundle.getString("email"));

    }

    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popup_menu);
        popup.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.pp:
                Toast.makeText(this, "Scelto primo piano", Toast.LENGTH_SHORT).show();
                Intent i1 = new Intent(Prenotazione.this, PrimoPiano.class);
                startActivity(i1);
                return true;
            case R.id.pt:
                Toast.makeText(this, "Scelto piano terra", Toast.LENGTH_SHORT).show();
                Intent i2 = new Intent(Prenotazione.this, PianoTerra.class);
                startActivity(i2);
                return true;
            case R.id.as:
                Toast.makeText(this, "Scelto aula studio", Toast.LENGTH_SHORT).show();
                Intent i3 = new Intent(Prenotazione.this, AulaStudio.class);
                startActivity(i3);
                return true;
                default: return false;
        }
    }
}

