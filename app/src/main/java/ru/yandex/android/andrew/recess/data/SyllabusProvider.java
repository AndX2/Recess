package ru.yandex.android.andrew.recess.data;

import java.util.List;

import ru.yandex.android.andrew.recess.pojo.SyllabusEntry;

/**
 * Created by Andrew on 16.02.2016.
 */
public interface SyllabusProvider {

    public List<SyllabusEntry> getSyllabusOfDay(int dayOfWeek);
    public void addSyllabusEntry(SyllabusEntry syllabusEntry) throws Exception;
    public int addSyllabusAll(List<SyllabusEntry> syllabusEntryList);
    public int deleteSyllabusEntry(long idKey);
    public int deleteSyllabusAll();
}
