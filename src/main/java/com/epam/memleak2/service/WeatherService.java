package com.epam.memleak2.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.epam.memleak2.model.Location;
import com.epam.memleak2.model.Weather;
import com.epam.memleak2.station.WeatherStationController;

public class WeatherService {

    private static final Logger LOG = LoggerFactory.getLogger(WeatherService.class);
    private WeatherStationController controller = new WeatherStationController();

    public Weather getWeather(Location location) {
        return controller.getWeather(location);
    }
}
