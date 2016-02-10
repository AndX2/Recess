package ru.yandex.android.andrew.recess.pojo;

/**
 * Created by Andrew on 08.02.2016.
 */
public class SyllabusEntry {
    private long beginTime;
    private long endTime;
    private String title;

    public SyllabusEntry(long beginTimeOfDay, long endTimeOfDay) {
        this.beginTime = beginTimeOfDay;
        this.endTime = endTimeOfDay;
        title = "default title";
    }

    public SyllabusEntry(String title, long beginTimeOfDay, long endTimeOfDay) {
        this(beginTimeOfDay, endTimeOfDay);
        this.title = title;
    }

    public long getBeginTime() {
        return beginTime;
    }

    public long getEndTime() {
        return endTime;
    }


}
