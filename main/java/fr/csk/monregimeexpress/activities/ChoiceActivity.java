package fr.csk.monregimeexpress.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import fr.csk.monregimeexpress.R;
import fr.csk.monregimeexpress.utils.CustomLog;

/**
 * Class inherited from AppActivity to : generate Choice Activity
 */
public class ChoiceActivity extends AppActivity {

    String logTitle = this.getClass().getName();
    CustomLog customLog = new CustomLog();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);
        customLog.ShowLog(logTitle, "onCreate()");
    }


    /**
     * Method to redirect on button click
     * @param view ChoiceView
     */
    public void RedirectAction(View view) {
        customLog.ShowLog(logTitle, "Action()");
        String action = view.getTag().toString();
        switch (action) {
            case "health" :
                RedirectToHealth();
                break;
            case "menu":
                RedirectToMenu();
                break;
            case "measure":
                RedirectToMeasures();
                break;
            case "sport":
                RedirectToSport();
                break;
        }
    }

    /**
     * Method to redirect to Sport Activity
     */
    private void RedirectToSport() {
        customLog.ShowLog(logTitle, "RedirectToSport()");
        Intent i = new Intent(ChoiceActivity.this, SportWeekActivity.class);
        startActivity(i);
    }

    /**
     * Method to redirect to Menu Activity
     */
    public void RedirectToMenu() {
        customLog.ShowLog(logTitle, "RedirectToMenu()");
        Intent i = new Intent(ChoiceActivity.this, EatActivity.class);
        startActivity(i);
    }

    /**
     * Method to redirect to Measure Activity
     */
    public void RedirectToMeasures() {
        customLog.ShowLog(logTitle, "RedirectToMeasures()");
        Intent i = new Intent(ChoiceActivity.this, LaunchActivity.class);
        startActivity(i);
    }


    /**
     * Method to redirect to Health Activity
     */
    public void RedirectToHealth() {
        customLog.ShowLog(logTitle, "RedirectToHealth()");
        Intent i = new Intent(ChoiceActivity.this, LaunchActivity.class);
        startActivity(i);
    }
}
