package ru.yandex.android.andrew.recess;

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
}
