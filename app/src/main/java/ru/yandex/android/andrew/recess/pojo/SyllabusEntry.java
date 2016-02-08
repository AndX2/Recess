package ru.yandex.android.andrew.recess.pojo;

/**
 * Created by Andrew on 08.02.2016.
 */
public class SyllabusEntry {
    private int beginTimeOfDay;
    private int endTimeOfDay;

    public SyllabusEntry(int beginTimeOfDay, int endTimeOfDay) {
        this.beginTimeOfDay = beginTimeOfDay;
        this.endTimeOfDay = endTimeOfDay;
    }

    public int getBeginTimeOfDay() {
        return beginTimeOfDay;
    }

    public int getEndTimeOfDay() {
        return endTimeOfDay;
    }


}
