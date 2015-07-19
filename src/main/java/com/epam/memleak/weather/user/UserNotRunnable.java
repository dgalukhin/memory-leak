package com.epam.memleak.weather.user;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import com.epam.memleak.util.DataGenerator;
import com.epam.memleak.weather.display.SimpleDataHolder;
import com.epam.memleak.weather.model.City;
import com.epam.memleak.weather.model.WeatherData;

public class UserNotRunnable {

    TimeZone timeZone = TimeZone.getTimeZone("Europe/Copenhagen");
    
    //not working
    private final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>() {
        protected DateFormat initialValue() {
            DateFormat d = new SimpleDateFormat("MM/dd/yy");
            d.setTimeZone(timeZone);
            return d;
        }
    };

    //public ThreadLocal<UserNotRunnable> tl = new ThreadLocal<UserNotRunnable>();

    //private final DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
    private SimpleDataHolder briefDisplay;
    private int id;
    private byte[] heavyData = new byte[1024 * 1024 * 10];

    public UserNotRunnable(SimpleDataHolder briefDisplay) {
        //df.set(dateFormat);
        id = DataGenerator.geterateRandomId();
        this.briefDisplay = briefDisplay;
    }


    public void watchWeather() {
        City c = DataGenerator.generateCity();
        Date d = DataGenerator.generateDate();
        WeatherData wd = briefDisplay.display(c, d);

        //tl.set(this);
        DateFormat dateFormat = df.get();
        System.out.println("User ID: " + id + ", gets weather data: " + dateFormat.format(new Date()));

    }

    public int getId() {
        return id;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalizing user ID: " + id);
        super.finalize();
    }
}
