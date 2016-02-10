package ru.yandex.android.andrew.recess.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import ru.yandex.android.andrew.recess.data.SyllabusContract.EventEntry;
import ru.yandex.android.andrew.recess.data.SyllabusContract.SyllabusEntry;

/**
 * Created by Andrew on 05.02.2016.
 */
public class DBHelper extends SQLiteOpenHelper {
    private static DBHelper instance;
    private static Cursor syllabusCursor;

    private DBHelper(Context context) {
        super(context, SyllabusContract.DB_NAME, null, SyllabusContract.DB_VERSION);
    }

    public static synchronized DBHelper getInstance(Context context) {
        if (instance == null) instance = new DBHelper(context);
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SyllabusEntry.SQL_CREATE_SYLLABUS_TABLE);
        sqLiteDatabase.execSQL(EventEntry.SQL_CREATE_EVENTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //TODO
        //Code upgrade db scheme (drop tables syllabus and event)

    }

    public static Cursor getSyllabusCursor(Context context) {
        if (syllabusCursor == null) {
            DBHelper dbHelper = DBHelper.getInstance(context);
            SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
            String[] resultColumns = {SyllabusContract.SyllabusEntry.ID, SyllabusContract.SyllabusEntry.DAY,
                    SyllabusContract.SyllabusEntry.BEGIN_TIME, SyllabusContract.SyllabusEntry.END_TIME};
            String where = null;
            String whereArgs[] = null;
            String groupBy = null;
            String having = null;
            String order = null;
            syllabusCursor = sqLiteDatabase.query(SyllabusContract.SyllabusEntry.TABLE_NAME,
                    resultColumns, where,
                    whereArgs, groupBy, having, order);
        }
        return syllabusCursor;
    }

    public static void dropSyllabusCursor() {
        syllabusCursor = null;
    }





}
