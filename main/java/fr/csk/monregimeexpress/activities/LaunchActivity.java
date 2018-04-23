package fr.csk.monregimeexpress.activities;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;

import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.io.File;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import fr.csk.monregimeexpress.R;
import fr.csk.monregimeexpress.dao.DayDao;
import fr.csk.monregimeexpress.dao.MealDao;
import fr.csk.monregimeexpress.dao.MenuDao;
import fr.csk.monregimeexpress.dao.SportDao;
import fr.csk.monregimeexpress.models.Day;
import fr.csk.monregimeexpress.models.Meal;
import fr.csk.monregimeexpress.models.Menu;
import fr.csk.monregimeexpress.models.Sport;
import fr.csk.monregimeexpress.utils.ImageStorage;
import fr.csk.monregimeexpress.utils.CustomLog;
import fr.csk.monregimeexpress.utils.RegimeExpressDb;

/**
 * Class inherited from AppActivity to : generate Launch Activity
 */
public class LaunchActivity extends AppActivity {

    Timer timer = new Timer();
    String logTitle = this.getClass().getName();
    CustomLog customLog = new CustomLog();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        customLog.ShowLog(logTitle, "onCreate()");


        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent i = new Intent(LaunchActivity.this, ChoiceActivity.class);
                CreateDatabase();
                startActivity(i);
            }
        }, 1000);

        PreferenceManager.getDefaultSharedPreferences(LaunchActivity.this);
        customLog.ShowLog("pref", String.valueOf(PreferenceManager.getDefaultSharedPreferences(LaunchActivity.this)));
    }


    /**
     * Method to create Database on first launch
     */
    private void CreateDatabase() {
        customLog.ShowLog(logTitle, "CreateDatabase()");
        /*
        File file = getBaseContext().getDatabasePath("csk.db");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            SQLiteDatabase.deleteDatabase(file);
        }
        */

        MenuDao menuDao = new MenuDao();
        DayDao dayDao = new DayDao();
        MealDao mealDao = new MealDao();
        SportDao sportDao = new SportDao();
        List<Menu> menus = menuDao.GetAll();
        List<Day> days = dayDao.GetAll();
        List<Meal> meals = mealDao.GetAll();
        List<Sport> sports = sportDao.GetAll();
        if (menus.size() == 0) {
            AddMenusInDatabase(menuDao);
        }
        if (days.size() == 0) {
            AddDaysInDatabase(dayDao);
        }
        if (meals.size() == 0) {
            AddMealsInDatabase(mealDao);
        }
        if (sports.size() == 0) {
            AddSportInDatabase(sportDao);
        }
    }

    /**
     * Method to generate days in Database
     * @param dayDao instance of DayDao
     */
    private void AddDaysInDatabase(DayDao dayDao) {
        customLog.ShowLog(logTitle, "AddDaysInDatabase()");

        dayDao.AddItem(new Day("FirstDay"));
        dayDao.AddItem(new Day("SecondDay"));
        dayDao.AddItem(new Day("ThirdDay"));
        dayDao.AddItem(new Day("FourthDay"));
    }

    /**
     * Method to generate meals in Database
     * @param mealDao instance of MealDao
     */
    private void AddMealsInDatabase(MealDao mealDao) {
        customLog.ShowLog(logTitle, "AddMealsInDatabase()");

        mealDao.AddItem(new Meal("FirstMeal"));
        mealDao.AddItem(new Meal("SecondMeal"));
        mealDao.AddItem(new Meal("ThirdMeal"));
    }

    /**
     * Method to add menus in Database
     * @param menuDao instance of MenuDao
     */
    private void AddMenusInDatabase(MenuDao menuDao) {
        customLog.ShowLog(logTitle, "AddMenusInDatabase()");

        // MENU JOUR 1
        menuDao.AddItem(new Menu(1, 1, "1", "Café, infusion sans sucre"));
        menuDao.AddItem(new Menu(1, 1, "1/2", "Pamplemousse"));
        menuDao.AddItem(new Menu(1, 2, "1", "Steack grillé"));
        menuDao.AddItem(new Menu(1, 2, "à volonté", "Salade verte"));
        menuDao.AddItem(new Menu(1, 2, "2", "Tomate"));
        menuDao.AddItem(new Menu(1, 2, "1", "Pomme"));
        menuDao.AddItem(new Menu(1, 3, "2", "Oeuf dur"));
        menuDao.AddItem(new Menu(1, 3, "à volonté", "Haricots verts"));
        menuDao.AddItem(new Menu(1, 3, "1/2", "Pamplemousse"));

        // MENU JOUR 2
        menuDao.AddItem(new Menu(2, 1, "1", "Café, infusion sans sucre"));
        menuDao.AddItem(new Menu(2, 1, "1/2", "Pamplemousse"));
        menuDao.AddItem(new Menu(2, 2, "1", "Steack grillé"));
        menuDao.AddItem(new Menu(2, 2, "à volonté", "Salade verte"));
        menuDao.AddItem(new Menu(2, 2, "1", "Jus de tomate"));
        menuDao.AddItem(new Menu(2, 3, "à volonté", "Courgettes / Choux-Fleur"));
        menuDao.AddItem(new Menu(2, 3, "à volonté", "Haricots verts"));
        menuDao.AddItem(new Menu(2, 3, "1", "Compote (sans sucre)"));

        // MENU JOUR 3
        menuDao.AddItem(new Menu(3, 1, "1", "Café, infusion sans sucre"));
        menuDao.AddItem(new Menu(3, 1, "1/2", "Pamplemousse"));
        menuDao.AddItem(new Menu(3, 2, "1", "Steack grillé"));
        menuDao.AddItem(new Menu(3, 2, "à volonté", "Salade verte"));
        menuDao.AddItem(new Menu(3, 2, "à volonté", "Céléri branche"));
        menuDao.AddItem(new Menu(3, 2, "1", "Pomme"));
        menuDao.AddItem(new Menu(3, 3, "1", "Poulet grillé"));
        menuDao.AddItem(new Menu(3, 3, "à volonté", "Tomates à l'étuvée"));
        menuDao.AddItem(new Menu(3, 3, "1", "Compote (sans sucre)"));

        // MENU JOUR 4
        menuDao.AddItem(new Menu(4, 1, "1", "Café, infusion sans sucre"));
        menuDao.AddItem(new Menu(4, 1, "1/2", "Pamplemousse"));
        menuDao.AddItem(new Menu(4, 2, "2", "Oeuf dur"));
        menuDao.AddItem(new Menu(4, 2, "à volonté", "Haricots verts"));
        menuDao.AddItem(new Menu(4, 2, "1", "Jus de tomates"));
        menuDao.AddItem(new Menu(4, 3, "1", "Steak grillé"));
        menuDao.AddItem(new Menu(4, 3, "à volonté", "Salade verte"));
        menuDao.AddItem(new Menu(4, 3, "1", "Pomme"));
    }


    /**
     * Method to add images sports in Database
     * @param sportDao instance of SportDao
     */
    private void AddSportInDatabase(SportDao sportDao) {
        customLog.ShowLog(logTitle, "AddSportInDatabase()");
        /* image stocker en base de données
        ImageStorage is = new ImageStorage(LaunchActivity.this);
        for (int week =1; week <2; week ++){
            for (int day=1; day<4; day++) {
                for (int serie =1; serie<4; serie++) {
                    for (int serial_nb=1; serial_nb<4;serial_nb++){
                        String imageFileName = "jpg_"
                                + String.valueOf(week) + "_"
                                + String.valueOf(day) + "_"
                                + String.valueOf(serie) + "_"
                                + String.valueOf(serial_nb);
                        sportDao.AddItem(new Sport(week,day,serie,serial_nb,is.StoreImage(imageFileName)));
                        customLog.ShowLog("filesportimg", is.StoreImage(imageFileName));
                    }
                }
            }
        }
        */
        for (int week =1; week <2; week ++) {
            for (int day = 1; day < 4; day++) {
                for (int serie = 1; serie < 4; serie++) {
                    for (int serial_nb = 1; serial_nb < 4; serial_nb++) {
                        String imageFileName = "jpg_"
                                + String.valueOf(week) + "_"
                                + String.valueOf(day) + "_"
                                + String.valueOf(serie) + "_"
                                + String.valueOf(serial_nb);
                        sportDao.AddItem(new Sport(week, day, serie, serial_nb, imageFileName));
                    }
                }
            }
        }
    }
}
