package ru.yandex.android.andrew.recess.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Calendar;

import ru.yandex.android.andrew.recess.R;

/**
 * Created by Andrew on 02.02.2016.
 */
public class DayFragment extends Fragment {
    private static final int LAYOUT = R.layout.fragment_example;
    private View view;
    private TextView txtView;
    Calendar currentTime;

    public static DayFragment getInstance() {
        Bundle args = new Bundle();
        DayFragment fragment = new DayFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT, container, false);
        txtView = (TextView) view.findViewById(R.id.txt_view);
        currentTime = Calendar.getInstance();
        txtView.setText("day of week = " + currentTime.get(Calendar.DAY_OF_WEEK) +
                ", first day of week = " + currentTime.getFirstDayOfWeek());
        return view;

    }

    @Override
    public void onResume() {
        super.onResume();
        //Calendar currentTime = Calendar.getInstance();
        //txtView.setText(Integer.toString(currentTime.get(Calendar.DAY_OF_WEEK)));
    }


}
