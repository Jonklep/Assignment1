package com.example.jonas.assignment1;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.jonas.assignment1.data.CityContract;
import com.example.jonas.assignment1.data.CityDbHelper;


public class ActivityHistory extends AppCompatActivity {

    private CityDbHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        mDbHelper = new CityDbHelper(this);
    }

    @Override
    protected void onStart(){
        super.onStart();
        displayDatabaseInfo();
    }

    private void displayDatabaseInfo () {
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        String[] projection = {
                CityContract.CityEntry._ID,
                CityContract.CityEntry.COLUMN_CITY_NAME
        };

        Cursor cursor = db.query(
                CityContract.CityEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );

        TextView displayView = (TextView) findViewById(R.id.text_view_city);

        try {
            displayView.setText("The cit table contains " + cursor.getCount() + " city.\n\n");
            displayView.append(CityContract.CityEntry._ID + " - " +
                    CityContract.CityEntry.COLUMN_CITY_NAME + "\n");

            int idColumnIndex = cursor.getColumnIndex(CityContract.CityEntry._ID);
            int nameColumnIndex = cursor.getColumnIndex(CityContract.CityEntry.COLUMN_CITY_NAME);

            while (cursor.moveToNext()) {
                int currentID = cursor.getInt(idColumnIndex);
                String currentName = cursor.getString(nameColumnIndex);

                displayView.append(("\n" + currentID + " - " +
                    currentName));
            }
        } finally {
            cursor.close();
        }
    }

}
