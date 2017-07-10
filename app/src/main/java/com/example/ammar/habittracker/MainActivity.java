package com.example.ammar.habittracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.ammar.habittracker.data.HabitContract.HabbitEntry;
import com.example.ammar.habittracker.data.HabitsDBHelper;

public class MainActivity extends AppCompatActivity {

    HabitsDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Initialize the database
        dbHelper = new HabitsDBHelper(this);
        insertHabit();
    }

    //Method to insert data in the habits database
    private void insertHabit() {


        //Get writable database
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        //Create ContentValue Object to inset data into the database
        ContentValues values = new ContentValues();
        values.put(HabbitEntry.HABIT_NAME, "Play the piano");
        values.put(HabbitEntry.HABIT_START_TIME, "13:00");
        values.put(HabbitEntry.HABIT_END_TIME, "14:00");
        values.put(HabbitEntry.WEEKDAY, HabbitEntry.FRIDAY);

        long newRowId = database.insert(HabbitEntry.TABLE_NAME, null, values);

        // Show a toast message depending on whether or not the insertion was successful
        if (newRowId == -1) {
            // If the row ID is -1, then there was an error with insertion.
            Toast.makeText(this, "Error with saving habit", Toast.LENGTH_SHORT).show();
        } else {
            // Otherwise, the insertion was successful and we can display a toast with the row ID.
            Toast.makeText(this, "Habit saved with row id: " + newRowId, Toast.LENGTH_SHORT).show();
        }
    }

    private Cursor readFromDatabase() {
        // Create and/or open a database to read from it
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] projection = {
                HabbitEntry._ID,
                HabbitEntry.HABIT_NAME,
                HabbitEntry.HABIT_START_TIME,
                HabbitEntry.HABIT_END_TIME,
                HabbitEntry.WEEKDAY};

        // Perform a query on the habits table
        return db.query(
                HabbitEntry.TABLE_NAME, projection, null, null, null, null, null);

    }
}
