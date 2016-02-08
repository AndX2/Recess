package ru.yandex.android.andrew.recess.pojo;

/**
 * Created by Andrew on 08.02.2016.
 */
public class SyllabusEntry {
    private int beginTime;
    private int endTime;

    public SyllabusEntry(int beginTimeOfDay, int endTimeOfDay) {
        this.beginTime = beginTimeOfDay;
        this.endTime = endTimeOfDay;
    }

    public int getBeginTime() {
        return beginTime;
    }

    public int getEndTime() {
        return endTime;
    }


}
