package fr.csk.monregimeexpress.models;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.StringRes;
import android.util.Log;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import fr.csk.monregimeexpress.R;
import fr.csk.monregimeexpress.utils.RegimeExpressDb;
import fr.csk.monregimeexpress.utils.ResourceGenerator;


/**
 * Class which Represents Sport Model
 * Implements Parcelable
 * Extends BaseModel
 */

@Table(database = RegimeExpressDb.class)
public class Sport extends BaseModel implements Parcelable {

    // ATTRIBUTES
    @PrimaryKey(autoincrement = true)
    private int id;

    @Column
    private int week;

    @Column
    private int day;

    @Column
    private int series;

    @Column
    private int serial_number;

    @Column
    private String imageFileName;

    // PROPERTIES
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public int getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(int serial_number) {
        this.serial_number = serial_number;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    // CONSTRUCTOR
    public Sport() {
    }

    public Sport(int week, int day, int series, int serial_number, String imageFileName) {
        this();
        this.week = week;
        this.day = day;
        this.series = series;
        this.serial_number= serial_number;
        this.imageFileName = imageFileName;
    }

    public Sport(int id, int week, int day, int series, int serial_number, String imageFileName) {
        this(week, day, series, serial_number, imageFileName);
        this.id = id;
    }

    //IMPLEMENT PARCELABLE
    public static final Creator<Sport> CREATOR = new Creator<Sport>() {
        @Override
        public Sport createFromParcel(Parcel in) {
            return new Sport(in);
        }

        @Override
        public Sport[] newArray(int size) {
            return new Sport[size];
        }
     };

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeInt(week);
        parcel.writeInt(day);
        parcel.writeInt(series);
        parcel.writeInt(serial_number);
        parcel.writeString(imageFileName);
    }

    protected Sport(Parcel in) {
        id = in.readInt();
        week = in.readInt();
        day = in.readInt();
        series= in.readInt();
        serial_number = in.readInt();
        imageFileName = in.readString();
    }

    @Override
    public String toString() {
        return null;
    }

    public String toString(Context context) {
        ResourceGenerator rg = new ResourceGenerator(context);
        String w = rg.getStringResourceByName("Week", "string") + " ";
        String d1 = rg.getStringResourceByName("FirstDay", "string");
        String d3 = rg.getStringResourceByName("ThirdDay", "string");
        String d5 = rg.getStringResourceByName("FifthDay", "string");
        String s = rg.getStringResourceByName("Serie", "string") + " ";
        String n = rg.getStringResourceByName("Serial_number", "string") + " ";
        return String.format(
                w + String.valueOf(week) + " " +
                ((day == 1) ? d1 : ((day == 2) ? d3 : d5)) + " " +
                s + String.valueOf(series) + " " +
                n + String.valueOf(serial_number)
        );

    }

    @Override
    public int describeContents() {
        return 0;
    }
}
