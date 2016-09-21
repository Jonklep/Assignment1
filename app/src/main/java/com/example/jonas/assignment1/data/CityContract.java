package com.example.jonas.assignment1.data;

import android.provider.BaseColumns;

public final class CityContract {
    private CityContract() {}

    public static final class CityEntry implements BaseColumns {

        public final static String TABLE_NAME = "city";

        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_CITY_NAME ="city";
    }
}
