package com.epam.memleak2.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.epam.memleak2.command.Command;
import com.epam.memleak2.controller.WeatherController;
import com.epam.memleak2.model.Alert;
import com.epam.memleak2.model.Entry;
import com.epam.memleak2.model.WeatherForecast;
import com.epam.memleak2.util.CommandEnum;
import com.epam.memleak2.util.Generator;

public class User {

    private WeatherController controller; 
    private CommandEnum commandEnum;
    private Command command;
    private static int id = 0;
    private Entry location;
    private Alert alert;
    private WeatherForecast weather;
    private static final Logger LOG = LoggerFactory.getLogger(User.class);

    // ----------------- constructor and getters and setters ------------------------------
    public User() {
        id++;
    }

    public void setWeatherController(final WeatherController controller) {
        this.controller = controller;
    }

    public CommandEnum getCommandEnum() {
        return commandEnum;
    }

    public void setCommandEnum(CommandEnum commandEnum) {
        this.commandEnum = commandEnum;
    }

    public Alert getAlert() {
        return alert;
    }

    public void setAlert(Alert alert) {
        this.alert = alert;
    }

    public void setWeather(WeatherForecast weather) {
        this.weather = weather;
    }

    public Entry getLocation() {
        return location;
    }

    public void setLocation(Entry location) {
        this.location = location;
    }

    public WeatherController getController() {
        return controller;
    }

    public void setController(WeatherController controller) {
        this.controller = controller;
    }

    public int getId() {
        return id;
    }

    public WeatherForecast getWeather() {
        return weather;
    }

    // -------------------- actions -----------------------------
    public void execute() {
        command.execute(this);
    }

    public void report() {
        command.report(this);
    }

    public void generateEnquiryData() {
        commandEnum = Generator.generateCommand();
        command = commandEnum.getCommand();
        Entry location = new Entry();
        location.setAddress(Generator.generateAddress());
        location.setDate(Generator.generateDate());
        this.location = location;
    }
}
