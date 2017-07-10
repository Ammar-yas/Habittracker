package com.example.ammar.habittracker.data;

import android.provider.BaseColumns;

/**
 * Contracts for the Habit app.
 */

public class HabitContract {

    //Empty constructor to prevent someone from instantiating the contract class
    private HabitContract() {
    }

    /**
     * Inner class that define constant values for the habits database table.
     * Each entry in the table represent a single habit.
     */
    public static final class HabbitEntry implements BaseColumns {
        //Table name
        public final static String TABLE_NAME = "habits";
        //Table columns
        public final static String _ID = BaseColumns._ID;
        public final static String HABIT_NAME = "habit_name";
        public final static String HABIT_START_TIME = "habit_start_time";
        public final static String HABIT_END_TIME = "habit_end_time";
        public final static String WEEKDAY = "weekday";


        //Possible values for weekdays
        public final static String SATURDAY = "1";
        public final static String SUNDAY = "2";
        public final static String MONDAY = "3";
        public final static String TUESDAY = "4";
        public final static String WEDNESDAY = "5";
        public final static String THURSDAY = "6";
        public final static String FRIDAY = "7";


        /*public final static String SATURDAY = "saturday";
        public final static String SUNDAY = "sunday";
        public final static String MONDAY = "monday";
        public final static String TUESDAY = "tuesday";
        public final static String WEDNESDAY = "wednesday";
        public final static String THURSDAY = "thursday";
        public final static String FRIDAY = "friday";*/
    }

}
