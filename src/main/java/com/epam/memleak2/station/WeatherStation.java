package com.epam.memleak2.station;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.epam.memleak2.model.Address;
import com.epam.memleak2.model.Weather;
import com.epam.memleak2.util.Generator;

public class WeatherStation {

    private Address addr;
    private Map<Date, Weather> forecast = new HashMap<Date, Weather>();
    private static final Logger LOG = LoggerFactory.getLogger(WeatherStation.class);

    public Weather getWeather(Date date) {
        if (forecast.containsKey(date)) {
            return forecast.get(date);
        } else {
            Weather weather = generateWeatherReport();
            forecast.put(date, weather);
            return weather;
        }
    }

    private Weather generateWeatherReport() {
        Weather weather = new Weather();
        weather.setTemp(Generator.generateTemperature());
        weather.setPressure(Generator.generatePressure());
        weather.setHumidity(Generator.generateHumidity());
        return weather;
    }

    public void setAddr(Address addr) {
        this.addr = addr;
    }

    public Address getAddr() {
        return addr;
    }
    

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((addr == null) ? 0 : addr.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        WeatherStation other = (WeatherStation) obj;
        if (addr == null) {
            if (other.addr != null)
                return false;
        } else if (!addr.equals(other.addr))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "WeatherStation [addr=" + addr + "]";
    }
}
