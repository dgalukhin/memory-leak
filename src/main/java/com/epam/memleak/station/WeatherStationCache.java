package com.epam.memleak.station;

import java.util.HashMap;
import java.util.Map;

import com.epam.memleak.model.Entry;
import com.epam.memleak.model.WeatherForecast;

public class WeatherStationCache {

    private Map<Entry, WeatherForecast> cache = new HashMap<Entry, WeatherForecast>();

    public boolean contains(final Entry entry) {
        return cache.containsKey(entry);
    }

    public WeatherForecast get(final Entry entry) {
        if (cache.containsKey(entry)) {
            return cache.get(entry);
        }
        return null;
    }

    public void save(final Entry entry, final WeatherForecast weather) {
        cache.put(entry, weather);
    }

}
