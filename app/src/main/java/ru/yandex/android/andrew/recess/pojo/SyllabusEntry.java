package ru.yandex.android.andrew.recess.pojo;

/**
 * Created by Andrew on 08.02.2016.
 */
public class SyllabusEntry {
    private long beginTime;
    private long endTime;

    public SyllabusEntry(long beginTimeOfDay, long endTimeOfDay) {
        this.beginTime = beginTimeOfDay;
        this.endTime = endTimeOfDay;
    }

    public long getBeginTime() {
        return beginTime;
    }

    public long getEndTime() {
        return endTime;
    }


}
