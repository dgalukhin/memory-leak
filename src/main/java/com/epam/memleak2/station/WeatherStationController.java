package com.epam.memleak2.station;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.epam.memleak.util.DataGenerator;
import com.epam.memleak2.model.Address;
import com.epam.memleak2.model.Location;
import com.epam.memleak2.model.Weather;

import static com.epam.memleak2.Constants.*;

public class WeatherStationController {

    private static final Logger LOG = LoggerFactory.getLogger(WeatherStationController.class);
    //private Map<Address, WeatherStation> stations = new HashMap<Address, WeatherStation>();
    private Set<WeatherStation> stations = new HashSet<WeatherStation>();
    private WeatherStationCache cache = new WeatherStationCache();

    public WeatherStationController() {
        setupStations();
    }

    private void setupStations() {
        while (stations.size() < NUMBER_OF_WEATHER_STATIONS) {
            Address addr = DataGenerator.generateAddress();
            WeatherStation station = new WeatherStation();
            station.setAddr(addr);
            stations.add(station);
        }
        LOG.info("Total number of stations set up: {}", stations.size());
    }

    public Weather getWeather(Location location) {
        Weather weather = null;
        Address addr = location.getAddress();
        Date date = location.getDate();
        weather = cache.lookFor(location);
        if (weather == null) {
            for (WeatherStation station: stations) {
                if (addr.equals(station.getAddr())) {
                    weather = station.getWeather(date);
                    cache.save(location, weather);
                    return weather;
                }
            }
        }
        return weather;
    }
}
