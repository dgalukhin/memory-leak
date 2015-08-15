package com.epam.memleak2.station;

import java.util.HashMap;
import java.util.Map;

import com.epam.memleak2.model.Location;
import com.epam.memleak2.model.Weather;

public class WeatherStationCache {

    private Map<Location, Weather> cache = new HashMap<Location, Weather>();

    public Weather lookFor(Location location) {
        System.out.println("WeatherStationCache, size: " + cache.size());
        if (cache.containsKey(location)) {
            return cache.get(location);
        }
        return null;
    }

    public void save(Location location, Weather weather) {
        cache.put(location, weather);
    }

}
