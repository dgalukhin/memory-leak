package com.epam.memleak2.controller;

import com.epam.memleak2.model.Alert;
import com.epam.memleak2.model.Entry;
import com.epam.memleak2.model.WeatherForecast;

public interface WeatherController {

    WeatherForecast getWeather(Entry location);

    Alert getAlerts(Entry location);

}