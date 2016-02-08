package ru.yandex.android.andrew.recess;

import java.util.ArrayList;
import java.util.Calendar;

import ru.yandex.android.andrew.recess.pojo.SyllabusEntry;

/**
 * Created by Andrew on 02.02.2016.
 */
public class Utils {
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

    public static int getHourFromDBPresentation(int timeDBPresentation) {
        return (int) (timeDBPresentation % DAY) / HOUR;
    }

    public static int getMinuteFromDBPresentation(int timeDBPresentation) {
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
}
