package com.epam.memleak2.station.service;

import com.epam.memleak2.model.Alert;
import com.epam.memleak2.model.Entry;
import com.epam.memleak2.model.WeatherForecast;

public interface WeatherStationService {

    WeatherForecast getWeather(Entry location);

    Alert getAlerts(Entry location);

}