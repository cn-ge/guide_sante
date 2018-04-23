package fr.csk.monregimeexpress.dao;

import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

import fr.csk.monregimeexpress.models.Day;
import fr.csk.monregimeexpress.models.Day_Table;
import fr.csk.monregimeexpress.models.Menu;
import fr.csk.monregimeexpress.models.Menu_Table;
import fr.csk.monregimeexpress.utils.CustomLog;

/**
 * Method to access Day object in database
 */
public class DayDao implements IDao<Day> {

    String logTitle = this.getClass().getName().toString();
    CustomLog customLog = new CustomLog();

    /**
     * Method to Add Day in Database
     * @param day
     */
    @Override
    public void AddItem(Day day) {
        customLog.ShowLog(logTitle, "AddItem()");
        day.save();
    }

    /**
     * Method to Get all Days from Database
     * @return List of Days
     */
    @Override
    public List<Day> GetAll() {
        customLog.ShowLog(logTitle, "GetAll()");
        return SQLite.select().from(Day.class).queryList();
    }

    /**
     * Method to Get Day by id from Database
     * @param id
     * @return Day
     */
    @Override
    public Day GetById(int id) {
        customLog.ShowLog(logTitle, "GetById()");
        return SQLite.select().from(Day.class).where(Day_Table.id.eq(id)).querySingle();
    }
}
