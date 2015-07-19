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

public class FullDisplay implements Observer, DisplayElement{

    private static final Logger LOGGER = LoggerFactory.getLogger(FullDisplay.class);

    private Subject weatherSource;
    private Map<CityDateEntry, WeatherData> cache = new HashMap<CityDateEntry, WeatherData>(); 

    public FullDisplay(Subject weatherSource) {
        this.weatherSource = weatherSource;
        weatherSource.registerObserver(this);
    }

    @Override
    public WeatherData display(City city, Date date) {
        //LOGGER.info("Full weather display for city: {}, date: {}, {}", city, date, weatherData.getBriefDisplay());
        CityDateEntry cde = new CityDateEntry(city, date);
        WeatherData weatherData = cache.get(cde);
        return weatherData;
    }

    @Override
    public void update(CityDateEntry cde, WeatherData weatherData) {
        cache.put(cde, weatherData);
        //this.weatherData = weatherData;
        //display();
    }

}
