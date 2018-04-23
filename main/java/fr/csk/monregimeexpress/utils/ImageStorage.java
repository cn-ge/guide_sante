package fr.csk.monregimeexpress.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;


/**
 * Class for Generation of String Resource
 */
public class ImageStorage {

    String logTitle = this.getClass().getName();
    CustomLog customLog = new CustomLog();

    private File storageDir;
    private Context context;
    private ResourceGenerator rg;

    public ImageStorage(Context context){
        this.context = context;
        this.rg = new ResourceGenerator(this.context);
        this.storageDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES); // /storage/emulated/0/Android/data/fr.csk.monregimeexpress/files/Pictures
    }

    /**
     * Method to store Image in Database
     * @param imageFileName
     */
    public String StoreImage(String imageFileName){
        customLog.ShowLog(logTitle, "StoreImage()");

        int resId = rg.getIntResourceByName(imageFileName,"drawable");
        Bitmap imageBitmap = BitmapFactory.decodeResource(context.getResources(), resId);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        imageBitmap.compress(Bitmap.CompressFormat.PNG, 80, bos);
        File image = null;

        try {
            image = File.createTempFile(
                    imageFileName,  /* prefix */
                    ".bmp",         /* suffix */
                    storageDir      /* directory */
            );
            customLog.ShowLog("tempfile", image.toString());
            byte[] bitmapdata = bos.toByteArray();

            //write the bytes in file
            FileOutputStream fos = new FileOutputStream(image);
            fos.write(bitmapdata);
            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ((image != null) ? image.getName() : "");
    }

    /**
     * Method to get the image sport by name from ExternalStorage
     * @param image_sport_name
     * @return uri
     */
    public Uri GetImageSportByName(String image_sport_name) {
        customLog.ShowLog(logTitle, "GetImageSportByName()");

        File f = new File(String.valueOf(storageDir) +"/"+image_sport_name);
        customLog.ShowLog("file", f.toString());
        customLog.ShowLog("fileuri", String.valueOf(Uri.parse(f.getAbsolutePath().toString())));

        return Uri.parse(f.getAbsolutePath().toString());
    }
}
