package com.epam.memleak2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.epam.memleak2.model.Alert;
import com.epam.memleak2.model.Entry;
import com.epam.memleak2.model.WeatherForecast;
import com.epam.memleak2.station.service.WeatherStationService;
import com.epam.memleak2.station.service.WeatherStationServiceImpl;

public class WeatherControllerImpl implements WeatherController {

    private static final Logger LOG = LoggerFactory.getLogger(WeatherControllerImpl.class);
    private WeatherStationService service = new WeatherStationServiceImpl();

    public WeatherForecast getWeather(final Entry location) {
        return service.getWeather(location);
    }

    public Alert getAlerts(final Entry location) {
        return service.getAlerts(location);
    }
}
