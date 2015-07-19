package com.epam.memleak.weather.display;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.epam.memleak.weather.DisplayElement;
import com.epam.memleak.weather.Observer;
import com.epam.memleak.weather.Subject;
import com.epam.memleak.weather.model.City;
import com.epam.memleak.weather.model.CityDateEntry;
import com.epam.memleak.weather.model.WeatherData;

public class BriefDisplay implements Observer, DisplayElement{

    private static final Logger LOGGER = LoggerFactory.getLogger(BriefDisplay.class);

    private Map<CityDateEntry, WeatherData> cache = new HashMap<CityDateEntry, WeatherData>(); 

    public BriefDisplay(Subject weatherSource) {
        weatherSource.registerObserver(this);
    }

    @Override
    public WeatherData display(City city, Date date) {
        CityDateEntry cityDateEntry = new CityDateEntry(city, date);
        WeatherData weatherData = cache.get(cityDateEntry);
        return weatherData;
    }

    @Override
    public void update(CityDateEntry cde, WeatherData weatherData) {
        if (!cache.containsKey(cde)) {
            cache.put(cde, weatherData);
        } 
    }
}
