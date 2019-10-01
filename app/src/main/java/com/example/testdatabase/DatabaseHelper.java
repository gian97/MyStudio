package com.example.testdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(@Nullable Context context) {
        super(context, "Login.db" , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table user(email text primary key, password text)");
        //db.execSQL("Create table prenotazioni_pp(email text)");
        //db.execSQL("Create table prenotazioni_pt(email text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists user");
    }

    //inserting in database
    public boolean insertdata(String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email );
        contentValues.put("password", password);
        long ins = db.insert("user", null, contentValues);
        if(ins == -1) return false;
        else return true;
    }

    //prenotazione piano terra
   /* public boolean pren_pt(String email){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email );
        long ins = db.insert("prenotazioni_pt", null, contentValues);
        if(ins == -1) return false;
        else return true;
    }

    //prenotazione primo piano
    public boolean pren_pp(String email){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email );
        long ins = db.insert("prenotazioni_pp", null, contentValues);
        if(ins == -1) return false;
        else return true;
    } */
    //checking if email exists
    public Boolean chkemail(String email){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where email=?", new String[]{email});
        if(cursor.getCount()>0) return false;
        else return true;
    }

    //se ho già prenotato un posto piano terra
    /*public Boolean chkemailpt(String email){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from prenotazioni_pt where email=?", new String[]{email});
        if(cursor.getCount()>0) return false;
        else return true;
    }

    //se ho già prenotato un posto primo piano
    public Boolean chkemailpp(String email){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from prenotazioni_pp where email=?", new String[]{email});
        if(cursor.getCount()>0) return false;
        else return true;
    }*/
    //checking the email and password
    public Boolean emailpassword(String email, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from user where email=? and password =?", new String[]{email, password});
        if(cursor.getCount()>0) return true;
        else return false;
    }
}
