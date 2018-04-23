package fr.csk.monregimeexpress.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import fr.csk.monregimeexpress.utils.RegimeExpressDb;

/**
 * Class which Represents Menu Model
 * Implements Parcelable
 * Extends BaseModel
 */

@Table(database = RegimeExpressDb.class)
public class Menu extends BaseModel implements Parcelable {

    // ATTRIBUTES
    @PrimaryKey(autoincrement = true)
    private int id;

    @Column
    private int day;

    @Column
    private int meal;

    @Column
    private String quantity;

    @Column
    private String description;

    // PROPERTIES
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMeal() {
        return meal;
    }

    public void setMeal(int meal) {
        this.meal = meal;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // CONSTRUCTOR
    public Menu() {
    }

    public Menu(int day, int meal, String quantity, String description) {
        this();
        this.day = day;
        this.meal = meal;
        this.quantity = quantity;
        this.description = description;
    }

    public Menu(int id, int day, int meal, String quantity, String description) {
        this(day, meal, quantity, description);
        this.id = id;
    }

    //IMPLEMENT PARCELABLE
    public static final Creator<Menu> CREATOR = new Creator<Menu>() {
        @Override
        public Menu createFromParcel(Parcel in) {
            return new Menu(in);
        }

        @Override
        public Menu[] newArray(int size) {
            return new Menu[size];
        }
    };

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeInt(day);
        parcel.writeInt(meal);
        parcel.writeString(quantity);
        parcel.writeString(description);
    }

    protected Menu(Parcel in) {
        id = in.readInt();
        day = in.readInt();
        meal= in.readInt();
        quantity = in.readString();
        description = in.readString();
    }

    @Override
    public String toString() {
        return quantity+ " " + description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

}
