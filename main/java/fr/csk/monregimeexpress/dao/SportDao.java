package fr.csk.monregimeexpress.dao;

import android.content.Context;

import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

import fr.csk.monregimeexpress.activities.LaunchActivity;
import fr.csk.monregimeexpress.models.Menu;
import fr.csk.monregimeexpress.models.Menu_Table;
import fr.csk.monregimeexpress.models.Sport;
import fr.csk.monregimeexpress.models.Sport_Table;
import fr.csk.monregimeexpress.utils.CustomLog;
import fr.csk.monregimeexpress.utils.ImageStorage;

/**
 * Method to access data object in database
 */

public class SportDao implements IDao<Sport>{

    String logTitle = this.getClass().getName().toString();
    CustomLog customLog = new CustomLog();

    /**
     * Method to Add Sport in Database
     * @param sport
     */
    @Override
    public void AddItem(Sport sport) {
        customLog.ShowLog(logTitle, "AddItem()");
        sport.save();

    }

    /**
     * Method to Get all Sports from Database
     * @return List of Sports
     */
    @Override
    public List<Sport> GetAll() {
        customLog.ShowLog(logTitle, "GetAll()");
        return SQLite.select().from(Sport.class).queryList();
    }

    /**
     * Method to Get Sport by id from Database
     * @param id
     * @return Sport
     */
    @Override
    public Sport GetById(int id) {
        customLog.ShowLog(logTitle, "GetById()");
        return SQLite.select().from(Sport.class).where(Sport_Table.id.eq(id)).querySingle();
    }

    /**
     * Method to Get Sport by Week, Day, Series, Serial_number
     * @param week
     * @param day
     * @param serie
     * @param serial_number
     * @return Sport
     */
    public Sport GetSportByWeekDaySerieSerialNumber(int week, int day, int serie, int serial_number) {
        return SQLite.select().from(Sport.class)
                .where(Sport_Table.week.eq(week))
                .and(Sport_Table.day.eq(day))
                .and(Sport_Table.series.eq(serie))
                .and(Sport_Table.serial_number.eq(serial_number))
                .querySingle();
    }

    /**
     * Method to Get Sport by Week, Day, Series
     * @param week
     * @param day
     * @param serie
     * @return List of Sports
     */
    public List<Sport> GetSportBySerie(int week, int day, int serie) {
        return SQLite.select().from(Sport.class)
                .where(Sport_Table.week.eq(week))
                .and(Sport_Table.day.eq(day))
                .and(Sport_Table.series.eq(serie))
                .queryList();
    }
}
