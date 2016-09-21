package com.example.jonas.assignment1.data;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CityDbHelper extends SQLiteOpenHelper {

    public static final String LOG_TAG = CityDbHelper.class.getSimpleName();

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "cities.db";


    public CityDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_CITY_TABLE = "CREATE TABLE " + CityContract.CityEntry.TABLE_NAME + "("
                + CityContract.CityEntry._ID + "INTEGER PRIMARY KEY AUTOINCREMENT, "
                + CityContract.CityEntry.COLUMN_CITY_NAME + "TEXT NOT NULL);";

        db.execSQL(SQL_CREATE_CITY_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
