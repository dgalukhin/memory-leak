package com.epam.memleak2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.epam.memleak2.model.Location;
import com.epam.memleak2.model.Weather;
import com.epam.memleak2.service.WeatherService;

//for thread pool
class WorkerThread implements Runnable {

    private WeatherService service;
    private static final int WORKER_SLEEP_TIME = 1;

    public WorkerThread(WeatherService service) {
        this.service = service;
    }

    private static final Logger LOG = LoggerFactory.getLogger(WorkerThread.class);

    public void run() {
        try {
            User user = new User();
            user.setWeatherService(service);
            user.generateEnquiryData();
            user.getWeather();
            user.report();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class Runner {

    public static void main(String[] args) {
        
        // with executors
        /*
        ExecutorService executors = Executors.newFixedThreadPool(5);
        WeatherService service = new WeatherService();
        while(true) {
            try {
                Runnable worker = new WorkerThread(service);
                executors.execute(worker);
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        */
        
        // without executors

        WeatherService service = new WeatherService();
        while(true) {
            Runnable worker = new WorkerThread(service);
            worker.run();
        }

    }

}
