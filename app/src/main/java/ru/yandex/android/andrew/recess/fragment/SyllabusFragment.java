package ru.yandex.android.andrew.recess.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.yandex.android.andrew.recess.R;
import ru.yandex.android.andrew.recess.pojo.SyllabusEntry;

/**
 * Created by Andrew on 09.02.2016.
 */
public class SyllabusFragment extends Fragment implements Comparable {

    private View view;
    private SyllabusEntry entry;

    public void setEntry(SyllabusEntry entry) {
        this.entry = entry;
    }

    public long getBeginTime(){
        return entry.getBeginTime();
    }

    private static final int LAYOUT = R.layout.syllabus_entry_item;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT, container, false);

        return view;

    }

    public View getView(){
        return view;
    }


    @Override
    public int compareTo(Object another) {
        SyllabusFragment anotherFragment = (SyllabusFragment)another;
        if (entry.getBeginTime() > anotherFragment.getBeginTime()) return 1;
        if (entry.getBeginTime() < anotherFragment.getBeginTime()) return -1;
        return 0;
    }
}
