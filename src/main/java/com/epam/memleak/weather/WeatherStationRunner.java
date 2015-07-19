package com.epam.memleak.weather;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.epam.memleak.util.DataGenerator;
import com.epam.memleak.weather.display.SimpleDataHolder;
import com.epam.memleak.weather.model.City;
import com.epam.memleak.weather.model.CityDateEntry;
import com.epam.memleak.weather.model.WeatherData;
import com.epam.memleak.weather.user.UserNotRunnable;
import com.epam.memleak.weather.user.UserRunnable;

// user not runnable
class UserGeneratorRunnable implements Runnable {
    
    private SimpleDataHolder d;
    
    public UserGeneratorRunnable(SimpleDataHolder d) {
        this.d = d;
    }

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

// user runnable
class RunnableUserGeneratorRunnable implements Runnable {

    private SimpleDataHolder d;

    public RunnableUserGeneratorRunnable(SimpleDataHolder d) {
        this.d = d;
    }

    public void run() {
        ThreadLocal<UserRunnable> tl = new ThreadLocal<UserRunnable>();
        while (true) {
            try {
                UserRunnable user = new UserRunnable(d);
                tl.set(user);
                new Thread(user).start();
                Thread.sleep(300);
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

// for thread pool
class WorkerThread implements Runnable {

    private UserNotRunnable user;

    public WorkerThread(UserNotRunnable user) {
        this.user = user;
    }

    public void run() {
        try {
            String threadName = Thread.currentThread().getName();
            int userId = user.getId();
            System.out.println("Starting: " + threadName + ", " + userId);
            user.watchWeather();
            Thread.sleep(300);
            System.out.println("Finishing: " + threadName + ", " + userId);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class WeatherStationRunner {

    public static void main(String[] args) throws InterruptedException {

        WeatherSource source = new WeatherSource();

        SimpleDataHolder briefDisplay = new SimpleDataHolder(source);

        new Thread(new WeatherGeneratorRunnable(source)).start();
        //new Thread(new RunnableUserGeneratorRunnable(briefDisplay)).start();
        ExecutorService executors = Executors.newFixedThreadPool(5);
        while(true) {
            try {
                Runnable worker = new WorkerThread(new UserNotRunnable(briefDisplay));
                Thread.sleep(300);
                executors.execute(worker);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //executors.shutdown();

    }
}
