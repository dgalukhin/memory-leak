package com.epam.memleak.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.epam.memleak.model.Alert;
import com.epam.memleak.model.Entry;
import com.epam.memleak.model.WeatherForecast;
import com.epam.memleak.station.service.WeatherStationService;
import com.epam.memleak.station.service.WeatherStationServiceImpl;

public class WeatherControllerImpl implements WeatherController {

    private static final Logger LOG = LoggerFactory.getLogger(WeatherControllerImpl.class);
    private WeatherStationService service = new WeatherStationServiceImpl();

    public WeatherForecast getWeather(final Entry entry) {
        return service.getWeather(entry);
    }

    public Alert getAlerts(final Entry entry) {
        return service.getAlerts(entry);
    }
}
