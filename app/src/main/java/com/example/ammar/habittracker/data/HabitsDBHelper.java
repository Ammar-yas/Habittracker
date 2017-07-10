package com.example.ammar.habittracker.data;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.ammar.habittracker.data.HabitContract.HabbitEntry;

public class HabitsDBHelper extends SQLiteOpenHelper {

    private final static String DATABASE_NAME = "habits.db";
    private final static int DATABASE_VERSION = 1;

    public HabitsDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // Create a String that contains the SQL statement to create the habits table
        String SQL_CREATE_HABITS_TABLE = "CREATE TABLE " + HabbitEntry.TABLE_NAME +" ("
                + HabbitEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + HabbitEntry.HABIT_NAME + " TEXT NOT NULL, "
                + HabbitEntry.HABIT_START_TIME + " TEXT NOT NULL, "
                + HabbitEntry.HABIT_END_TIME + " TEXT NOT NULL, "
                + HabbitEntry.WEEKDAY + " INTEGER NOT NULL );";

        // Excute the SQL commands
        db.execSQL(SQL_CREATE_HABITS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
