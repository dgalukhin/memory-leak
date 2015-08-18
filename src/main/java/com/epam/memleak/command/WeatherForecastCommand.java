package com.epam.memleak.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.epam.memleak.model.Entry;
import com.epam.memleak.model.WeatherForecast;
import com.epam.memleak.user.User;

public class WeatherForecastCommand implements Command {

    private static final Logger LOG = LoggerFactory.getLogger(User.class);

    public void execute(final User user) {
        WeatherForecast weather = user.getController().getWeather(user.getEntry());
        user.setWeather(weather);
    }

    public void report(final User user) {
        WeatherForecast weather = user.getWeather();
        int id = user.getId();
        Entry entry = user.getEntry();
        if (weather != null) {
            LOG.info("User {} reports weather in {} at {} is {}", id, entry.getAddress(), entry.getDate(), weather);
        } else {
            LOG.info("User {} unable to get weather in {}", id, entry.getAddress());
        }
    }
}
