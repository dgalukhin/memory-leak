package com.epam.memleak.weather.user;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.epam.memleak.util.DataGenerator;
import com.epam.memleak.weather.display.SimpleDataHolder;
import com.epam.memleak.weather.model.City;
import com.epam.memleak.weather.model.WeatherData;

public class UserRunnable implements Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserRunnable.class);

    private SimpleDataHolder briefDisplay;
    private int id;

    public UserRunnable(SimpleDataHolder display) {
        id = DataGenerator.geterateRandomId();
        Thread.currentThread().setName("User-Thread-" + id);
        briefDisplay = display;
    }

    private void watchWeather() {

        City c = DataGenerator.generateCity();
        Date d = DataGenerator.generateDate();
        WeatherData wd = briefDisplay.display(c, d);
        LOGGER.info("User ID: {}, display weather: {}", id, wd);
    }

    public void run() {
        watchWeather();
    }

    @Override
    protected void finalize() throws Throwable {
        LOGGER.info("finialize id: {}", id);
        super.finalize();
    }
}
