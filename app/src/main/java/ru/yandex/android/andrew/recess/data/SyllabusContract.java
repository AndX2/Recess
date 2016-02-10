package ru.yandex.android.andrew.recess.data;

/**
 * Created by Andrew on 05.02.2016.
 */
public class SyllabusContract {

    public static final String DB_NAME = "syllabus.db";
    public static final int DB_VERSION = 1;

    public static final class SyllabusEntry {
        public static final String TABLE_NAME = "syllabus";
        public static final String ID = "id";
        public static final String DAY = "day";
        public static final String BEGIN_TIME = "begin";
        public static final String END_TIME = "end";

        public static final String SQL_CREATE_SYLLABUS_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
                ID + " INTEGER PRIMARY KEY," +
                DAY + " INTEGER NOT NULL, " +
                BEGIN_TIME + " NUMERIC NOT NULL, " +
                END_TIME + " NUMERIC NOT NULL" +
                " );";

    }

    public static final class EventEntry {
        public static final String TABLE_NAME = "events";
        public static final String ID = "id";
        public static final String SYLLABUS_ENTRY_ID = "syllabus_id";
        public static final String UTC_TIME = "time";
        public static final String ACTION = "action";
        public static final String INTENT_KEY = "intent_key";

        public static final String SQL_CREATE_EVENTS_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
                ID + " INTEGER PRIMARY KEY," +
                SYLLABUS_ENTRY_ID + " INTEGER NOT NULL, " +
                UTC_TIME + " TEXT NOT NULL, " +
                ACTION + " INTEGER NOT NULL, " +
                INTENT_KEY + " INTEGER NOT NULL" +
                " );";

    }
}
