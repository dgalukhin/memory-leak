package com.epam.memleak.weather.user;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.epam.memleak.util.DataGenerator;
import com.epam.memleak.weather.display.BriefDisplay;
import com.epam.memleak.weather.model.City;
import com.epam.memleak.weather.model.WeatherData;

public class UserNotRunnable {

    //not working
    public static ThreadLocal df = new ThreadLocal() {
        protected DateFormat initialValue() {
            return new SimpleDateFormat("MM/dd/yy");
        }
    };

    private BriefDisplay briefDisplay;
    private int id;

    public UserNotRunnable(BriefDisplay briefDisplay) {
        id = DataGenerator.geterateRandomId();
        this.briefDisplay = briefDisplay;
    }


    public void watchWeather() {
        City c = DataGenerator.generateCity();
        Date d = DataGenerator.generateDate();
        WeatherData wd = briefDisplay.display(c, d);

        DateFormat dateFormat = (DateFormat) df.get();
        System.out.println("User ID: " + id + ", gets weather data.");

    }

    public int getId() {
        return id;
    }
}
