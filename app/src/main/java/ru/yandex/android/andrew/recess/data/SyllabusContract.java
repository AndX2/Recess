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

    }

    public static final class EventEntry {
        public static final String TABLE_NAME = "events";
        public static final String ID = "id";
        public static final String SYLLABUS_ENTRY_ID = "syllabus_id";
        public static final String UTC_TIME = "time";
        public static final String ACTION = "action";
        public static final String INTENT_KEY = "intent_key";

    }
}
