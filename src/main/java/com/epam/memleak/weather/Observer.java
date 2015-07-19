package com.epam.memleak.weather;

import com.epam.memleak.weather.model.CityDateEntry;
import com.epam.memleak.weather.model.WeatherData;

public interface Observer {

    public void update(CityDateEntry cde, WeatherData weatherData);

}
