package fr.csk.monregimeexpress.utils;

import android.util.Log;

/**
 * Class for Customization of Log
 */
public class CustomLog {

    private String logTitle;
    private String logContent;

    public CustomLog() {
    }

    public void ShowLog(String logTitle, String logContent) {
        Log.e(logTitle, logContent);
        Log.w(logTitle, logContent);
        Log.i(logTitle, logContent);
    }
}
