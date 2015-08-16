package com.epam.memleak2.station;

import java.util.HashMap;
import java.util.Map;

import com.epam.memleak2.model.Entry;
import com.epam.memleak2.model.WeatherForecast;

public class WeatherStationCache {

    private Map<Entry, WeatherForecast> cache = new HashMap<Entry, WeatherForecast>();

    public boolean contains(Entry location) {
        return cache.containsKey(location);
    }

    public WeatherForecast get(Entry location) {
        if (cache.containsKey(location)) {
            return cache.get(location);
        }
        return null;
    }

    public void save(Entry location, WeatherForecast weather) {
        cache.put(location, weather);
    }

}
