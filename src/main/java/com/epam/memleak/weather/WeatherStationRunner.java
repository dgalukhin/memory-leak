package com.epam.memleak.weather;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.epam.memleak.util.DataGenerator;
import com.epam.memleak.weather.display.BriefDisplay;
import com.epam.memleak.weather.display.FullDisplay;
import com.epam.memleak.weather.model.City;
import com.epam.memleak.weather.model.CityDateEntry;
import com.epam.memleak.weather.model.WeatherData;
import com.epam.memleak.weather.user.UserNotRunnable;
import com.epam.memleak.weather.user.UserRunnable;

class UserGeneratorRunnable implements Runnable {
    
    private BriefDisplay d;
    
    public UserGeneratorRunnable(BriefDisplay d) {
        this.d = d;
    }

    @Override
    public void run() {
        Thread.currentThread().setName("UserGeneratorThread");
        while (true) {
            try {
                UserNotRunnable user = new UserNotRunnable(d);
                user.watchWeather();
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class WeatherGeneratorRunnable implements Runnable {

    WeatherSource source;

    public WeatherGeneratorRunnable(WeatherSource s) {
        this.source = s;
    }

    @Override
    public void run() {
        Thread.currentThread().setName("WeatherGeneratorThread");
        while(true) {
            City c = DataGenerator.generateCity();
            Date d = DataGenerator.generateDate();
            CityDateEntry cde = new CityDateEntry(c, d);
            WeatherData wd = new WeatherData();
            wd.setTemp(DataGenerator.generateTemp());
            wd.setHumidity(DataGenerator.generateHumidity());
            wd.setPressure(DataGenerator.generatePressure());
            source.setWeatherData(cde, wd);
            //Thread.sleep(2);
        }
    }
}

public class WeatherStationRunner {

    public static void main(String[] args) throws InterruptedException {

        WeatherSource source = new WeatherSource();

        BriefDisplay briefDisplay = new BriefDisplay(source);
        FullDisplay fullDispaly = new FullDisplay(source);

        new Thread(new WeatherGeneratorRunnable(source)).start();
        new Thread(new UserGeneratorRunnable(briefDisplay)).start();
    }
}
