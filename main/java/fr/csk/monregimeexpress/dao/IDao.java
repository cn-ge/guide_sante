package fr.csk.monregimeexpress.dao;

import java.util.Comparator;
import java.util.List;

/**
 * Interface to declare Dao Method
 */

public interface IDao<Type> {

    /**
     * Method to Add item in Database
     * @param item (object)
     */
    void AddItem(Type item);

    /**
     * Method to Get all items from Database
     * @return List of Types
     */
    List<Type> GetAll();

    /**
     * Method to Get Object by id from Database
     * @param id
     * @return Type
     */
    Type GetById(int id);
}
