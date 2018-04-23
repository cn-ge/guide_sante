package fr.csk.monregimeexpress.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import fr.csk.monregimeexpress.R;
import fr.csk.monregimeexpress.utils.CustomLog;

public class SportSeriesActivity extends AppActivity {

    private String logTitle = this.getClass().getName();
    private CustomLog customLog = new CustomLog();

    private int day;
    private int week;

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TextView textView_day;
    private TextView textView_week;

    private void findViews() {
        customLog.ShowLog(logTitle, "findViews()");

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        textView_day = (TextView) findViewById(R.id.tv_day);
        textView_week = (TextView) findViewById(R.id.tv_week);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport_series);
        customLog.ShowLog(logTitle, "onCreate()");

        findViews();
        week  = getIntent().getIntExtra("week", 1);

        //create and set ViewPager adapter
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        //create tabs title
        tabLayout.addTab(tabLayout.newTab().setText("Serie 1"));
        tabLayout.addTab(tabLayout.newTab().setText("Serie 2"));
        tabLayout.addTab(tabLayout.newTab().setText("Serie 3"));

        //attach tab layout with ViewPager
        //set gravity for tab bar
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);


        //change selected tab when viewpager changed page
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        //change viewpager page when tab selected
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        // DISPLAY OF THE CHOOSEN DAY
        day = getIntent().getIntExtra("day", 1);
        switch (day) {
            case 1:
                textView_day.setText(R.string.FirstDay);
                break;
            case 2:
                textView_day.setText(R.string.ThirdDay);
                break;
            case 3:
                textView_day.setText(R.string.FifthDay);
                break;
        }

        // DISPLAY OF THE WEEK'S NUMBER
        textView_week = (TextView) findViewById(R.id.tv_week);
        textView_week.setText(String.valueOf(week));

    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            // set Fragmentclass Arguments
            Bundle bundle = new Bundle();
            bundle.putString("day", String.valueOf(day));
            bundle.putString("week", String.valueOf(week));
            bundle.putString("serie", String.valueOf(position+1));
            SportSeriesFragment fragment = new SportSeriesFragment();
            fragment.setArguments(bundle);
            return fragment;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
