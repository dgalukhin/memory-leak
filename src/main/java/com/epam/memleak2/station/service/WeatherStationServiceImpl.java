package com.epam.memleak2.station.service;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.epam.memleak2.model.Address;
import com.epam.memleak2.model.Alert;
import com.epam.memleak2.model.Entry;
import com.epam.memleak2.model.WeatherForecast;
import com.epam.memleak2.station.WeatherStation;
import com.epam.memleak2.station.WeatherStationCache;
import com.epam.memleak2.util.Generator;

import static com.epam.memleak2.Constants.*;

public class WeatherStationServiceImpl implements WeatherStationService {

    private static final Logger LOG = LoggerFactory.getLogger(WeatherStationServiceImpl.class);
    private Set<WeatherStation> stations = new HashSet<WeatherStation>();
    private WeatherStationCache cache = new WeatherStationCache();

    public WeatherStationServiceImpl() {
        setupStations();
    }

    private void setupStations() {
        while (stations.size() < NUMBER_OF_WEATHER_STATIONS) {
            Address addr = Generator.generateAddress();
            WeatherStation station = new WeatherStation();
            station.setAddr(addr);
            stations.add(station);
        }
        LOG.info("Total number of stations set up: {}", stations.size());
    }

    private WeatherForecast getWeatherAndSaveToCache(Entry location) {
        Address addr = location.getAddress();
        Date date = location.getDate();
        WeatherForecast weather = null;
        for (WeatherStation station : stations) {
            if (addr.equals(station.getAddr())) {
                weather = station.getWeather(date);
                cache.save(location, weather);
                return weather;
            }
        }
        return weather;
    }
    

    @Override
    public WeatherForecast getWeather(Entry location) {
        WeatherForecast weather = null;
        if (cache.contains(location)) {
            weather = cache.get(location);
        } else {
            weather = getWeatherAndSaveToCache(location);
        }
        return weather;
    }

    @Override
    public Alert getAlerts(Entry location) {
        WeatherForecast weather = null;
        Alert alert = null;
        if (cache.contains(location)) {
            weather = cache.get(location);
        } else {
            weather = getWeatherAndSaveToCache(location);
        }
        if (weather != null) {
            alert = new Alert();
            if (weather.getTemp() > TEMP_TOP_GRADE) {
                alert.setHazard(true);
                alert.setAlert("Too hot!");
            } else {
                if (weather.getTemp() < TEMP_BOTTOM_GRADE) {
                    alert.setHazard(true);
                    alert.setAlert("Too cold!");
                }
            }
        }
        return alert;
    }
}
