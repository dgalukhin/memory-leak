package com.epam.memleak.controller;

import com.epam.memleak.model.Alert;
import com.epam.memleak.model.Entry;
import com.epam.memleak.model.WeatherForecast;

public interface WeatherController {

    WeatherForecast getWeather(final Entry entry);

    Alert getAlerts(final Entry entry);

}