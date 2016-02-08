package ru.yandex.android.andrew.recess.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import ru.yandex.android.andrew.recess.data.SyllabusContract.SyllabusEntry;

/**
 * Created by Andrew on 05.02.2016.
 */
public class DBHelper extends SQLiteOpenHelper {
    private DBHelper instance;

    public DBHelper(Context context) {
        super(context, SyllabusContract.DB_NAME, null, SyllabusContract.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_SYLLABUS_TABLE = "CREATE TABLE " + SyllabusEntry.TABLE_NAME + " (" +
                SyllabusEntry.ID + " INTEGER PRIMARY KEY," +
                SyllabusEntry.DAY + " INTEGER NOT NULL, " +
                " );";
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //TODO

}
