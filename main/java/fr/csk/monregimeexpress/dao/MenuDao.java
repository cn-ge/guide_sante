package fr.csk.monregimeexpress.dao;

import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

import fr.csk.monregimeexpress.models.Menu;
import fr.csk.monregimeexpress.models.Menu_Table;
import fr.csk.monregimeexpress.utils.CustomLog;

/**
 * Method to access Menu object in database
 */
public class MenuDao implements IDao<Menu>{

    String logTitle = this.getClass().getName().toString();
    CustomLog customLog = new CustomLog();

    /**
     * Method to Add Menu in Database
     * @param menu
     */
    @Override
    public void AddItem(Menu menu) {
        customLog.ShowLog(logTitle, "AddItem()");
        menu.save();
    }

    /**
     * Method to Get all Menus from Database
     * @return List of Menus
     */
    @Override
    public List<Menu> GetAll() {
        customLog.ShowLog(logTitle, "GetAll()");
        return SQLite.select().from(Menu.class).queryList();
    }

    /**
     * Method to Get Menu by id from Database
     * @param id
     * @return Menu
     */
    @Override
    public Menu GetById(int id) {
        customLog.ShowLog(logTitle, "GetById()");
        return SQLite.select().from(Menu.class).where(Menu_Table.day.eq(id)).querySingle();
    }

    /**
     * Method to Get Menu by day and meal from Database
     * @param day_id
     * @param meal_id
     * @return List of menus
     */
    public List<Menu> GetAllByDayAndMeal(int day_id, int meal_id) {
        customLog.ShowLog(logTitle, "GetAllByDayAndMeal(day, meal)");
        return SQLite.select().from(Menu.class).where(Menu_Table.day.eq(day_id)).and(Menu_Table.meal.eq(meal_id)).queryList();
    }

}
