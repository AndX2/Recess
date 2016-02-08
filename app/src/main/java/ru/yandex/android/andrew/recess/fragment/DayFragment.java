package ru.yandex.android.andrew.recess.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Calendar;

import ru.yandex.android.andrew.recess.R;
import ru.yandex.android.andrew.recess.Utils;
import ru.yandex.android.andrew.recess.adapter.SyllabusRecyclerAdapter;

/**
 * Created by Andrew on 02.02.2016.
 */
public class DayFragment extends Fragment {
    private static final int LAYOUT = R.layout.fragment_example;
    private static final int WIDTH_SCREEN_DP = 410;
    private static Context context;
    private String dayOfWeek;
    private String month;
    private View view;
    private Calendar currentTime;
    private TextView txtDayOfWeek;
    private TextView txtDayOfMonth;
    private TextView txtMonth;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter recyclerAdapter;
    private RecyclerView.LayoutManager recyclerLayoutManager;

    public static DayFragment getInstance(Context context, int numberDayOfWeek) {
        Bundle args = new Bundle();
        args.putInt("NUMBER_DAY_OF_WEEK", numberDayOfWeek);
        DayFragment fragment = new DayFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT, container, false);

        txtDayOfWeek = (TextView) view.findViewById(R.id.txtDayOfWeek);
        txtMonth = (TextView) view.findViewById(R.id.txtMonth);
        txtDayOfMonth = (TextView) view.findViewById(R.id.txtDayOfMonth);
        currentTime = Utils.calculateDateForDayFragment(this.getArguments().getInt("NUMBER_DAY_OF_WEEK"));
        context = getActivity();
        setDateLabel();
        recyclerView = (RecyclerView) view.findViewById(R.id.list_syllabus);
        //recyclerView.setHasFixedSize(true);
        recyclerLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(recyclerLayoutManager);
        recyclerAdapter = new SyllabusRecyclerAdapter(Utils.createMockListEntry());
        recyclerView.setAdapter(recyclerAdapter);


        return view;

    }

    @Override
    public void onResume() {
        super.onResume();
        //Calendar currentTime = Calendar.getInstance();
        //txtView.setText(Integer.toString(currentTime.get(Calendar.DAY_OF_WEEK)));
    }

    public Calendar getDate() {
        return currentTime;
    }

    private void setDateLabel() {
        //
        dayOfWeek = context.getResources().getStringArray(R.array.daysOfWeek)[currentTime.get(Calendar.DAY_OF_WEEK) - 1];
        month = context.getResources().getStringArray(R.array.months)[currentTime.get(Calendar.MONTH)];
        int fontLabelSize = WIDTH_SCREEN_DP / (dayOfWeek.length() + month.length());
        txtMonth.setTextSize(fontLabelSize);
        txtDayOfWeek.setTextSize(fontLabelSize);
        txtDayOfWeek.setText(dayOfWeek);
        txtDayOfMonth.setText(String.format("%1$02d", currentTime.get(Calendar.DAY_OF_MONTH)));
        txtMonth.setText(month);

    }


}
