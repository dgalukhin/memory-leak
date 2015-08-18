package com.epam.memleak.station.service;

import com.epam.memleak.model.Alert;
import com.epam.memleak.model.Entry;
import com.epam.memleak.model.WeatherForecast;

public interface WeatherStationService {

    WeatherForecast getWeather(final Entry location);

    Alert getAlerts(final Entry location);

}