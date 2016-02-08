package ru.yandex.android.andrew.recess.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import ru.yandex.android.andrew.recess.R;
import ru.yandex.android.andrew.recess.fragment.DayFragment;

/**
 * Created by Andrew on 02.02.2016.
 */
public class TabsPagerFragmentAdapter extends FragmentPagerAdapter {
    private Context context;
    private String[] tabs;

    public TabsPagerFragmentAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
        tabs = (context.getResources().getStringArray(R.array.tabs));
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return DayFragment.getInstance(context, position);
            case 1:
                return DayFragment.getInstance(context, position);
            case 2:
                return DayFragment.getInstance(context, position);
            case 3:
                return DayFragment.getInstance(context, position);
            case 4:
                return DayFragment.getInstance(context, position);
            case 5:
                return DayFragment.getInstance(context, position);
            case 6:
                return DayFragment.getInstance(context, position);
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
}
