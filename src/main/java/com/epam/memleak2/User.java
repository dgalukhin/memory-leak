package com.epam.memleak2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.epam.memleak.util.DataGenerator;
import com.epam.memleak2.model.Location;
import com.epam.memleak2.model.Weather;
import com.epam.memleak2.service.WeatherService;
import com.epam.memleak2.util.Generator;

public class User {

    private WeatherService service; 
    private static int id = 0;
    private Location location;
    private Weather weather;
    private static final Logger LOG = LoggerFactory.getLogger(User.class);

    public User() {
        id++;
    }

    public void generateEnquiryData() {
        Location location = new Location();
        location.setAddress(Generator.generateAddress());
        location.setDate(Generator.generateDate());
        this.location = location;
    }

    public void getWeather() {
        Weather weather = service.getWeather(this.location);
        this.weather = weather;
    }

    public void setWeatherService(WeatherService service) {
        this.service = service;
    }

    public void report() {
        if (weather != null) {
            LOG.info("User {} reports weather in {} at {} is {}", id, location.getAddress(), location.getDate(), weather);
        } else {
            LOG.info("User {} unable to get weather in {}", id, location.getAddress());
        }
    }

    public int getId() {
        return id;
    }

}
