package com.epam.memleak.weather;

import java.util.Date;

import com.epam.memleak.weather.model.City;
import com.epam.memleak.weather.model.WeatherData;

public interface DataHolder {

    public WeatherData display(City city, Date date);

}
