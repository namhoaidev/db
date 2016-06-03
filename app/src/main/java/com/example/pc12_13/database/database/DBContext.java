package com.example.pc12_13.database.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.pc12_13.database.model.Country;

public class DBContext extends SQLiteOpenHelper {
    public static final String DB_NAME = "Country.db";
    public static final int DB_VERSION = 1;

    //method create database if db not exists
    public DBContext(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        //// TODO: CREATE DIFFRENT TABLE IF TABLE EXISTS
    }

    //method create table and call one only
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Country.CREATE_TABLE);
    }

    //method recreate structure db
    //called when DB_VERSION change
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //// TODO: When version 2 onwards, handle here
    }
}
