package com.epam.memleak.weather;

import com.epam.memleak.weather.model.CityDateEntry;
import com.epam.memleak.weather.model.WeatherData;

public interface Observer {

    void update(CityDateEntry cityDateEntry, WeatherData weatherData);

}
