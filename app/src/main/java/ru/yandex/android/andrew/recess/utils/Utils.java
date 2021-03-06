package ru.yandex.android.andrew.recess.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Calendar;

import ru.yandex.android.andrew.recess.data.DBHelper;
import ru.yandex.android.andrew.recess.data.SyllabusContract;
import ru.yandex.android.andrew.recess.pojo.SyllabusEntry;

/**
 * Created by Andrew on 02.02.2016.
 */
public class Utils {
    public static final String LOG_TAG = "My log tag";

    public static int TAB_ONE = 0;
    public static int TAB_TWO = 1;
    public static int TAB_THREE = 2;

    public static final int SECOND = 1_000;
    public static final int MINUTE = 60 * SECOND;
    public static final int HOUR = 60 * MINUTE;
    public static final int DAY = 24 * HOUR;

    public static int getTimeForDB(int hour, int minute) {
        return minute * MINUTE + hour * HOUR;
    }

    public static int getHourFromDBPresentation(long timeDBPresentation) {
        return (int) (timeDBPresentation % DAY) / HOUR;
    }

    public static int getMinuteFromDBPresentation(long timeDBPresentation) {
        return (int) ((timeDBPresentation % DAY) % HOUR / MINUTE);
    }

    public static Calendar calculateDateForDayFragment(int numberDayOfWeek) {
        Calendar calendar = Calendar.getInstance();
        int deltaDay = numberDayOfWeek - calendar.get(Calendar.DAY_OF_WEEK) + calendar.getFirstDayOfWeek();
        //if day of week late - send this day to next week
        if (deltaDay < 0) deltaDay += 7;
        long tmp = calendar.getTimeInMillis();
        calendar.setTimeInMillis(tmp + deltaDay * DAY);
        return calendar;


    }

    //TODO
    //Create method getTimeUTC(date, hour, minute);

    //TODO delete this method
    public static ArrayList<SyllabusEntry> createMockListEntry() {
        ArrayList<SyllabusEntry> list = new ArrayList<>();
        list.add(new SyllabusEntry(Utils.getTimeForDB(8, 0), Utils.getTimeForDB(8, 45)));
        list.add(new SyllabusEntry(Utils.getTimeForDB(8, 55), Utils.getTimeForDB(9, 40)));
        list.add(new SyllabusEntry(Utils.getTimeForDB(9, 45), Utils.getTimeForDB(10, 30)));
        list.add(new SyllabusEntry(Utils.getTimeForDB(8, 0), Utils.getTimeForDB(8, 45)));
        list.add(new SyllabusEntry(Utils.getTimeForDB(8, 55), Utils.getTimeForDB(9, 40)));
        list.add(new SyllabusEntry(Utils.getTimeForDB(9, 45), Utils.getTimeForDB(10, 30)));
        return list;
    }

    public static ArrayList<SyllabusEntry> createSyllabusListEntry(Cursor cursor, int dayOfWeek) {
        ArrayList<SyllabusEntry> list = new ArrayList<>();
        int dayColumnIndex = cursor.getColumnIndex(SyllabusContract.Syllabus.DAY);
        int beginTimeColumnIndex = cursor.getColumnIndex(SyllabusContract.Syllabus.BEGIN_TIME);
        int endTimeColumnIndex = cursor.getColumnIndex(SyllabusContract.Syllabus.END_TIME);
        cursor.moveToFirst();
        while (cursor.moveToNext()) {
            if (cursor.getInt(dayColumnIndex) == dayOfWeek)
                list.add(new SyllabusEntry(cursor.getLong(beginTimeColumnIndex),
                        cursor.getLong(endTimeColumnIndex)));
        }
        return list;
    }

    //TODO delete this method
    public static void createMockDBSyllabusData(Context context) {
        for (int day = 1; day <= 7; day++) {
            for (int lesson = 0; lesson < 5; lesson++) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(SyllabusContract.Syllabus.DAY, day);
                contentValues.put(SyllabusContract.Syllabus.BEGIN_TIME, getTimeForDB(8 + lesson, 0 + day));
                contentValues.put(SyllabusContract.Syllabus.END_TIME, getTimeForDB(8 + lesson, 10 + day));
                SQLiteDatabase sqLiteDatabase = DBHelper.getInstance(context).getWritableDatabase();
                sqLiteDatabase.insert(SyllabusContract.Syllabus.TABLE_NAME, null, contentValues);
            }
        }
    }
}
