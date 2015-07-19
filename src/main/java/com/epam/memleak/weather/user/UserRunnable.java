package com.epam.memleak.weather.user;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.epam.memleak.util.DataGenerator;
import com.epam.memleak.weather.display.BriefDisplay;
import com.epam.memleak.weather.model.City;
import com.epam.memleak.weather.model.WeatherData;

public class UserRunnable implements Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserRunnable.class);

    private BriefDisplay briefDisplay;
    private volatile boolean isWatching = true;

    public UserRunnable(BriefDisplay display) {
        briefDisplay = display;
    }

    private void watchWeather() {
        City c = DataGenerator.generateCity();
        Date d = DataGenerator.generateDate();
        System.out.println("city: " + c + "date: " + d);
        while (isWatching) {
            try {
                WeatherData wd = briefDisplay.display(c, d);
                System.out.println(wd);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void killUser() {
        isWatching = false;
    }

    @Override
    public void run() {
        watchWeather();
    }
}
