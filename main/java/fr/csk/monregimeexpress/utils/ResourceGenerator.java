package fr.csk.monregimeexpress.utils;

import android.content.Context;


/**
 * Class for Generation of String Resource
 */
public class ResourceGenerator {

    String logTitle = this.getClass().getName();
    CustomLog customLog = new CustomLog();

    private Context context;

    public ResourceGenerator(Context context) {
        this.context = context;
    }

    /**
     * Method to get the String representation of the String Resource
     * @param stringResourceToFind (exemple : FirstDay)
     * @param typeOfResource (exemple: String)
     * @return String value of the resource (exemple: 'Lundi' or 'Monday' for R.string.FirstDay)
     */
    public String getStringResourceByName(String stringResourceToFind, String typeOfResource) {
        customLog.ShowLog(logTitle, "getStringResourceByName()");
        int resId = context.getResources().getIdentifier(stringResourceToFind, typeOfResource, context.getPackageName());
        return context.getString(resId);
    }

    /**
     * Method to get the int number of the String Resource
     * @param stringResourceToFind (exemple : FirstDay)
     * @param typeOfResource (exemple: String)
     * @return int value of the resource (exemple: '1' for R.string.FirstDay)
     */
    public int getIntResourceByName(String stringResourceToFind, String typeOfResource) {
        customLog.ShowLog(logTitle, "getStringResourceByName()");
        int resId = context.getResources().getIdentifier(stringResourceToFind, typeOfResource, context.getPackageName());
        return resId;
    }


    /**
     * Method to get the value of a String Resource
     * @param resId
     * @return String value
     */
    public String getStringValueByResourceName (int resId){
        return context.getResources().getString(resId);
    }
}
