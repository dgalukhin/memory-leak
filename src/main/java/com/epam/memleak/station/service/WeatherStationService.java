package com.epam.memleak.station.service;

import com.epam.memleak.model.Alert;
import com.epam.memleak.model.Entry;
import com.epam.memleak.model.WeatherForecast;

public interface WeatherStationService {

    WeatherForecast getWeather(Entry location);

    Alert getAlerts(Entry location);

}