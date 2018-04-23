package fr.csk.monregimeexpress.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import fr.csk.monregimeexpress.R;
import fr.csk.monregimeexpress.dao.DayDao;
import fr.csk.monregimeexpress.dao.MealDao;
import fr.csk.monregimeexpress.dao.MenuDao;
import fr.csk.monregimeexpress.models.Day;
import fr.csk.monregimeexpress.models.Meal;
import fr.csk.monregimeexpress.models.Menu;
import fr.csk.monregimeexpress.utils.CustomLog;
import fr.csk.monregimeexpress.utils.ResourceGenerator;

/**
 * Class inherited from AppActivity to : generate Menu Activity
 */
public class EatActivity extends AppActivity {

    String logTitle = this.getClass().getName();
    CustomLog customLog = new CustomLog();

    ListView listViewMenus;
    Spinner dropdownDay, dropDownMeal;

    MenuDao menuDao = new MenuDao();
    DayDao dayDao= new DayDao();
    MealDao mealDao= new MealDao();

    List<Menu> listMenus;
    List<Day> listDays;
    List<Meal> listMeals;
    List<String> listDaySpinner, listMealSpinner;
    int idDay = 1;
    int idMeal = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eat);
        customLog.ShowLog(logTitle, "onCreate()");

        listDays = dayDao.GetAll();
        listMeals = mealDao.GetAll();


        listDaySpinner = new ArrayList<>();
        for (int i = 0; i < listDays.size(); i++) {
            listDaySpinner.add(listDays.get(i).toString());
        }

        listMealSpinner = new ArrayList<>();
        for (int i = 0; i < listMeals.size(); i++) {
            listMealSpinner.add(listMeals.get(i).toString());
        }


        dropdownDay = (Spinner) findViewById(R.id.menu_spinner);
        addItemsOnSpinner(dropdownDay, listDaySpinner);
        dropDownMeal = (Spinner) findViewById(R.id.meal_spinner);
        addItemsOnSpinner(dropDownMeal, listMealSpinner);


        listViewMenus = (ListView) findViewById(R.id.list_Menus);
        listMenus = menuDao.GetAllByDayAndMeal(idDay, idMeal);
        listViewMenus.setAdapter(new MenuAdapter(this, R.layout.activity_eat_item, listMenus));
    }


    /**
     * Method to add items on Spinner
     * @param dropdown (spinner)
     * @param list (string)
     */
    private void addItemsOnSpinner(final Spinner dropdown, List<String> list) {
        customLog.ShowLog(logTitle, "addItemsOnSpinner()");

        for (int i = 0; i<list.size();i++) {
            ResourceGenerator rg = new ResourceGenerator(EatActivity.this);
            list.set(i, rg.getStringResourceByName(list.get(i), "string"));
        }

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdown.setAdapter(dataAdapter);
        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                customLog.ShowLog("i", String.valueOf(i));
                customLog.ShowLog("l", String.valueOf(l));
                if (dropdown.getId() == dropdownDay.getId()){
                    idDay = i+1;
                    dropDownMeal.setSelection(0);
                } else if (dropdown.getId() == dropDownMeal.getId()) {
                    idMeal = i+1;
                }
                listMenus = menuDao.GetAllByDayAndMeal(idDay, idMeal);
                listViewMenus.setAdapter(new MenuAdapter(EatActivity.this, R.layout.activity_eat_item, listMenus));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                listMenus = menuDao.GetAllByDayAndMeal(idDay, idMeal);
                listViewMenus.setAdapter(new MenuAdapter(EatActivity.this, R.layout.activity_eat_item, listMenus));

            }
        });

    }
}