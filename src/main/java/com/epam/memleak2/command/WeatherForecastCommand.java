package com.epam.memleak2.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.epam.memleak2.model.Entry;
import com.epam.memleak2.model.WeatherForecast;
import com.epam.memleak2.user.User;

public class WeatherForecastCommand implements Command {

    private static final Logger LOG = LoggerFactory.getLogger(User.class);

    @Override
    public void execute(User user) {
        WeatherForecast weather = user.getController().getWeather(user.getLocation());
        user.setWeather(weather);
    }

    @Override
    public void report(User user) {
        WeatherForecast weather = user.getWeather();
        int id = user.getId();
        Entry location = user.getLocation();
        if (weather != null) {
            LOG.info("User {} reports weather in {} at {} is {}", id, location.getAddress(), location.getDate(), weather);
        } else {
            LOG.info("User {} unable to get weather in {}", id, location.getAddress());
        }
    }
}
