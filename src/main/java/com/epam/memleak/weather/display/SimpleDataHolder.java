package com.epam.memleak.weather.display;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.epam.memleak.weather.DataHolder;
import com.epam.memleak.weather.Observer;
import com.epam.memleak.weather.Subject;
import com.epam.memleak.weather.model.City;
import com.epam.memleak.weather.model.CityDateEntry;
import com.epam.memleak.weather.model.WeatherData;

public class SimpleDataHolder implements Observer, DataHolder{

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleDataHolder.class);

    private Map<CityDateEntry, WeatherData> cache = new HashMap<CityDateEntry, WeatherData>(); 

    public SimpleDataHolder(Subject weatherSource) {
        weatherSource.registerObserver(this);
    }

    public WeatherData display(City city, Date date) {
        CityDateEntry cityDateEntry = new CityDateEntry(city, date);
        WeatherData weatherData = cache.get(cityDateEntry);
        return weatherData;
    }

    public void update(CityDateEntry cityDateEntry, WeatherData weatherData) {
        if (!cache.containsKey(cityDateEntry)) {
            cache.put(cityDateEntry, weatherData);
        } 
    }
}
