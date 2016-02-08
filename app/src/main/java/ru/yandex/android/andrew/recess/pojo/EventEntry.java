package ru.yandex.android.andrew.recess.pojo;

import java.util.Calendar;

/**
 * Created by Andrew on 08.02.2016.
 */
public class EventEntry {

    public static final int ACTOIN_ON = 1;
    public static final int ACTION_OFF = -1;

    private int action;
    private int intentKey;
    private Calendar utcTime;


}
