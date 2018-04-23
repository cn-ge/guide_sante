package fr.csk.monregimeexpress.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import fr.csk.monregimeexpress.utils.RegimeExpressDb;

/**
 * Class which Represents Meal Model
 * Implements Parcelable
 * Extends BaseModel
 */

@Table(database = RegimeExpressDb.class)
public class Meal extends BaseModel implements Parcelable {

    // ATTRIBUTES
    @PrimaryKey(autoincrement = true)
    private int id;

    @Column
    private String meal;


    // PROPERTIES
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMeal() {
        return meal;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }


    public Meal() {
    }

    public Meal(String meal) {
        this();
        this.meal = meal;
    }

    public Meal(int id, String meal) {
        this(meal);
        this.id = id;
    }

    public static final Creator<Meal> CREATOR = new Creator<Meal>() {
        @Override
        public Meal createFromParcel(Parcel in) {
            return new Meal(in);
        }

        @Override
        public Meal[] newArray(int size) {
            return new Meal[size];
        }
    };

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(meal);
    }

    protected Meal(Parcel in) {
        id = in.readInt();
        meal = in.readString();
    }

    @Override
    public String toString() {
        return meal;
    }

    @Override
    public int describeContents() {
        return 0;
    }
}