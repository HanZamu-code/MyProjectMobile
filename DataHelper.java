package com.example.icare;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Rumahsakit.db";
    private static final int DATABASE_VERSION = 1;
    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        String query = "create table datarumahsakit(no integer primary key, nama text null, fasilitas text null, jenis text null, alamat text null);";
        Log.d("Data", "onCreate: " + query);
        db.execSQL(query);
        query = "INSERT INTO datarumahsakit (no, nama, fasilitas, jenis, alamat) VALUES ('001','Rumah sakit Bunda','Radiologi, Ambulance, ','RSUD','jalan umbulharjo');";
        db.execSQL(query);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
    }
}

