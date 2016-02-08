package ru.yandex.android.andrew.recess.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.yandex.android.andrew.recess.R;

/**
 * Created by Andrew on 09.02.2016.
 */
public class SyllabusFragment extends Fragment {

    private View view;


    private static final int LAYOUT = R.layout.syllabus_entry_item;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT, container, false);

        return view;

    }

}
