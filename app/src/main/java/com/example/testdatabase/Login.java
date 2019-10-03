package com.example.testdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    //EditText e1, e2;
    Button b1;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db = new DatabaseHelper(this);
      final EditText  e1 = (EditText) findViewById(R.id.editText);
        final EditText e2 = (EditText) findViewById(R.id.editText2);
        b1 = (Button) findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                String email = e1.getText().toString();
                String password = e2.getText().toString();
                bundle.putString("email", email);
                Boolean Chkemailpass = db.emailpassword(email, password);
                if(Chkemailpass == true){
                    Toast.makeText(getApplicationContext(), "Login avvenuto", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Login.this, Prenotazione.class);
                    i.putExtras(bundle);
                    startActivity(i);}
                else
                    Toast.makeText(getApplicationContext(), "Email o password errati", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void chiamoclick1(View v){
        Intent ac = new Intent(this, MainActivity.class);
        startActivity(ac);
    }


}
