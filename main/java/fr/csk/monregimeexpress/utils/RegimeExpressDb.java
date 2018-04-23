package fr.csk.monregimeexpress.utils;

import android.app.Application;

import com.raizlabs.android.dbflow.annotation.Database;
import com.raizlabs.android.dbflow.config.FlowManager;

import java.io.File;

/**
 * Class to generate database
 */

@Database(name = RegimeExpressDb.NAME, version = RegimeExpressDb.VERSION)
public class RegimeExpressDb extends Application {

    public static final String NAME = "csk"; // we will add the .db extension
    public static final int VERSION = 1;

    String logTitle = this.getClass().getName().toString();
    CustomLog customLog = new CustomLog();

    @Override
    public void onCreate() {
        customLog.ShowLog(logTitle, "onCreate()");
        super.onCreate();
        FlowManager.init(this);
    }
}
