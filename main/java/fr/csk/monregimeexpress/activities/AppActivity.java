package fr.csk.monregimeexpress.activities;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.raizlabs.android.dbflow.config.FlowManager;

import fr.csk.monregimeexpress.R;


/**
 * Class inherited from AppCompatActivity to : Show the Action Bar
 */

public class AppActivity extends AppCompatActivity {

    ActionBar actionBar;

    /**
     * Method to Create Option Menu
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * Method to Set action on Option Menu Selected
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // if first screen : close view
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }

        int id = item.getItemId();

        if (id == R.id.menu_sport) {
            Intent i = new Intent(AppActivity.this, SportDayActivity.class);
            startActivity(i);
        }
        if (id == R.id.menu_eat) {
            Intent i = new Intent(AppActivity.this, EatActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FlowManager.init(this);

        // show goback arrow
        if(getSupportActionBar() != null) {
            if (!(this instanceof LaunchActivity)) {
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                actionBar = getActionBar();
            }
        }
    }
}