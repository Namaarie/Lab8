package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList() {
        list = new CustomList(null, new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size plus
     one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    @Test
    void testHasCities(){
        list = MockCityList();
        City city = new City("Charlottetown", "Prince Edward Island");
        list.addCity(city);
        assertTrue(list.hasCity(city));
        City newCity = new City("DOES", "NOT EXIST");
        assertFalse(list.hasCity(newCity));
    }

    @Test
    void testDeleteCity(){
        list = MockCityList();
        City city = new City("Charlottetown", "Prince Edward Island");
        list.addCity(city);
        list.deleteCity(city);
        City newCity = new City("DOES", "NOT EXIST");
        assertThrows(RuntimeException.class, () -> {
            list.deleteCity(newCity);
        });
    }

    @Test
    void testCountCities(){
        list = MockCityList();
        assertEquals(0, list.getCount());
        City city = new City("Charlottetown", "Prince Edward Island");
        list.addCity(city);
        assertEquals(1, list.getCount());
    }
}
