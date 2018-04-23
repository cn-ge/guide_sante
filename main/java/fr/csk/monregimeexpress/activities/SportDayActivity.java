package fr.csk.monregimeexpress.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.View;

import fr.csk.monregimeexpress.R;
import fr.csk.monregimeexpress.utils.CustomLog;

/**
 * Class inherited from AppActivity to : generate Sport Activity
 */
public class SportDayActivity extends AppActivity {

    private String logTitle = this.getClass().getName();
    private CustomLog customLog = new CustomLog();

    private int week ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport_day);
        customLog.ShowLog(logTitle, "onCreate()");

        week = getIntent().getIntExtra("week", 1);
    }

    /**
     * Method to redirect to Series Activity
     */
    public void ShowSeries(View view) {
        customLog.ShowLog(logTitle, "ShowSeries()");
        int day = Integer.parseInt((String)view.getTag());
        Intent i = new Intent(SportDayActivity.this, SportSeriesActivity.class);
        i.putExtra("week", week);
        i.putExtra("day", day);
        startActivity(i);
    }

}
