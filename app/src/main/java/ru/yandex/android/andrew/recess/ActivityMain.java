package ru.yandex.android.andrew.recess;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.Calendar;

import ru.yandex.android.andrew.recess.adapter.TabsPagerFragmentAdapter;

/**
 * Created by Andrew on 01.02.2016.
 */
public class ActivityMain extends AppCompatActivity {
    private static final int LAYOUT_MAIN = R.layout.activity_main;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;

    private ViewPager viewPager;
    TabsPagerFragmentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.ThemeDefault);
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT_MAIN);

        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);

        initToolbar();
        initNavigationView();
        initTabs();

    }

    @Override
    protected void onResume() {
        super.onResume();
        //- Calendar.getInstance().getFirstDayOfWeek() correction of method Calendar returned DayOfWeek [1:7]
        setCurrentTab(Calendar.getInstance().get(Calendar.DAY_OF_WEEK) - Calendar.getInstance().getFirstDayOfWeek());
    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });
        toolbar.inflateMenu(R.menu.menu);

    }

    private void initNavigationView() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.view_navigation_open, R.string.view_navigation_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                drawerLayout.closeDrawers();
                switch (item.getItemId()) {
                    case R.id.actionNotificationItem:
                        showNotificationTab();
                }
                return true;
            }
        });

    }

    private void initTabs() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        adapter = new TabsPagerFragmentAdapter(getSupportFragmentManager(), this);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }

    //TODO drop this method (stub listener NavigationDrawer)
    public void showNotificationTab() {
        viewPager.setCurrentItem(Utils.TAB_TWO);
    }

    public void setCurrentTab(int tab) {
        if (tab >= 0 && tab < adapter.getCount())
            viewPager.setCurrentItem(tab);
    }
}
