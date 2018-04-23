package fr.csk.monregimeexpress.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import fr.csk.monregimeexpress.R;

import fr.csk.monregimeexpress.utils.CustomLog;

public class SportWeekActivity extends AppActivity {

    private String logTitle = this.getClass().getName();
    private CustomLog customLog = new CustomLog();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport_week);
        customLog.ShowLog(logTitle, "onCreate()");
    }

    /**
     * Method to redirect to Series Activity
     */
    public void ShowDays(View view) {
        customLog.ShowLog(logTitle, "ShowDays()");
        int week = Integer.parseInt((String)view.getTag());
        Intent i = new Intent(SportWeekActivity.this, SportDayActivity.class);
        i.putExtra("week", week);
        startActivity(i);
    }

}
