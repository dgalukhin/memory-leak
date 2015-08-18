package com.epam.memleak.station.service;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.epam.memleak.model.Address;
import com.epam.memleak.model.Alert;
import com.epam.memleak.model.Entry;
import com.epam.memleak.model.WeatherForecast;
import com.epam.memleak.station.WeatherStation;
import com.epam.memleak.station.WeatherStationCache;
import com.epam.memleak.util.Generator;

import static com.epam.memleak.Constants.*;

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

    private WeatherForecast getWeatherAndSaveToCache(final Entry entry) {
        Address addr = entry.getAddress();
        Date date = entry.getDate();
        WeatherForecast weather = null;
        for (WeatherStation station : stations) {
            if (addr.equals(station.getAddr())) {
                weather = station.getWeather(date);
                cache.save(entry, weather);
                return weather;
            }
        }
        return weather;
    }
    

    public WeatherForecast getWeather(final Entry entry) {
        WeatherForecast weather = null;
        if (cache.contains(entry)) {
            weather = cache.get(entry);
        } else {
            weather = getWeatherAndSaveToCache(entry);
        }
        return weather;
    }

    public Alert getAlerts(final Entry entry) {
        WeatherForecast weather = null;
        Alert alert = null;
        if (cache.contains(entry)) {
            weather = cache.get(entry);
        } else {
            weather = getWeatherAndSaveToCache(entry);
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
