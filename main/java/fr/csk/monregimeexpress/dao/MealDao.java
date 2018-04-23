package fr.csk.monregimeexpress.dao;

import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

import fr.csk.monregimeexpress.models.Meal;
import fr.csk.monregimeexpress.models.Meal_Table;
import fr.csk.monregimeexpress.models.Menu;
import fr.csk.monregimeexpress.models.Menu_Table;
import fr.csk.monregimeexpress.utils.CustomLog;

/**
 * Method to access Meal object in database
 */
public class MealDao implements IDao<Meal>{

    String logTitle = this.getClass().getName().toString();
    CustomLog customLog = new CustomLog();

    /**
     * Method to Add Meal in Database
     * @param meal
     */
    @Override
    public void AddItem(Meal meal) {
        customLog.ShowLog(logTitle, "AddItem()");
        meal.save();
    }

    /**
     * Method to Get all Meals from Database
     * @return List of Meals
     */
    @Override
    public List<Meal> GetAll() {
        customLog.ShowLog(logTitle, "GetAll()");
        return SQLite.select().from(Meal.class).queryList();
    }

    /**
     * Method to Get Meal by id from Database
     * @param id
     * @return Meal
     */
    @Override
    public Meal GetById(int id) {
        customLog.ShowLog(logTitle, "GetById()");
        return SQLite.select().from(Meal.class).where(Meal_Table.id.eq(id)).querySingle();
    }
}
