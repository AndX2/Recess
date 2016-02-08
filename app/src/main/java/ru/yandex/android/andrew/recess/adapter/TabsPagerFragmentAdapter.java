package ru.yandex.android.andrew.recess.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.HashMap;

import ru.yandex.android.andrew.recess.R;
import ru.yandex.android.andrew.recess.fragment.DayFragment;

/**
 * Created by Andrew on 02.02.2016.
 */
public class TabsPagerFragmentAdapter extends FragmentPagerAdapter {
    private Context context;
    private String[] tabs;
    private String[] months;
    private String[] daysOfWeek;
    private HashMap<Integer, DayFragment> listDayFragments = new HashMap<>();
    ;

    public TabsPagerFragmentAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
        tabs = (context.getResources().getStringArray(R.array.tabs));
        months = (context.getResources().getStringArray(R.array.months));
        daysOfWeek = (context.getResources().getStringArray(R.array.daysOfWeek));
    }

    @Override
    public Fragment getItem(int position) {
        DayFragment tmpFragment;
        switch (position) {
            case 0:
                return createDayFragment(context, position);
            case 1:
                return createDayFragment(context, position);
            case 2:
                return createDayFragment(context, position);
            case 3:
                return createDayFragment(context, position);
            case 4:
                return createDayFragment(context, position);
            case 5:
                return createDayFragment(context, position);
            case 6:
                return createDayFragment(context, position);
        }
        return null;
    }

    @Override
    public int getCount() {
        return tabs.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }

    private DayFragment createDayFragment(Context context, int position) {
        DayFragment dayFragment = DayFragment.getInstance(context, position);
        listDayFragments.put(position, dayFragment);
        return dayFragment;
    }

    public String getTitleDayOfWeek(int position) {
        return daysOfWeek[position];
    }

    public String getTitleMonth(int position) {
        return months[position];
    }


}
