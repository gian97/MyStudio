package com.example.testdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ArrayAdapter;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(@Nullable Context context) {
        super(context, "Database.db" , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table user(email text primary key, password text)");
        db.execSQL("Create table prenotazioni(email text primary key, aula text, numtavolo text)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists user");
        db.execSQL("drop table if exists prenotazioni");
    }

    //prenotazioni
    public boolean prenote(String email, String aula, String numero){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("aula", aula);
        contentValues.put("numtavolo", numero);
        long ins = db.insert("prenotazioni", null, contentValues);
        if(ins == -1) return false;
        else return true;
    }
    //inserting in database
    public boolean insert(String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email );
        contentValues.put("password", password);
        long ins = db.insert("user", null, contentValues);
        if(ins == -1) return false;
        else return true;
    }

    //checking if it si an email (@)
    public boolean chiocc(String email){
        String sotto = "******@studenti.unimore.it";
        boolean trovato = false;
        int m = sotto.length();
        int n = email.length();
        if(n != 26)
            return false;
        int j = 6;
        for(int i = 0; i<n; i++){
            if(email.charAt(i) == sotto.charAt(j)){
                j++;
            }
            else j=6;
        }
        if(j==m)
            trovato=true;
        return trovato;
    }

    public Boolean chkprem(String email){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from prenotazioni where email=?", new String[]{email});
        if(cursor.getCount()>0) return false;
        else return true;
    }


    //checking if email exists
    public Boolean chkemail(String email){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where email=?", new String[]{email});
        if(cursor.getCount()>0) return false;
        else return true;
    }

    public Integer deletedata(String email){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("prenotazioni","email = ?", new String[]{email});
    }

    public Integer deleteall(){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("prenotazioni",null, null);
    }

    //checking if the user is already done
    public Boolean emailpassword(String email, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from user where email=? and password =?", new String[]{email, password});
        if(cursor.getCount()>0) return true;
        else return false;
    }


    public Cursor getAllData(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from prenotazioni", null);
        return cursor;
    }

}
