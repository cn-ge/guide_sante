package fr.csk.monregimeexpress.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import fr.csk.monregimeexpress.utils.RegimeExpressDb;

/**
 * Class which Represents Day Model
 * Implements Parcelable
 * Extends BaseModel
 */

@Table(database = RegimeExpressDb.class)
public class Day extends BaseModel implements Parcelable {

    // ATTRIBUTES
    @PrimaryKey(autoincrement = true)
    private int id;

    @Column
    private String day;


    // PROPERTIES
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }


    public Day() {
    }

    public Day(String day) {
        this();
        this.day = day;
    }

    public Day(int id, String day) {
        this(day);
        this.id = id;
    }

    public static final Creator<Day> CREATOR = new Creator<Day>() {
        @Override
        public Day createFromParcel(Parcel in) {
            return new Day(in);
        }

        @Override
        public Day[] newArray(int size) {
            return new Day[size];
        }
    };

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(day);
    }

    protected Day(Parcel in) {
        id = in.readInt();
        day = in.readString();
    }

    @Override
    public String toString() {
        return day;
    }

    @Override
    public int describeContents() {
        return 0;
    }

}