package com.epam.memleak.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.epam.memleak.command.Command;
import com.epam.memleak.controller.WeatherController;
import com.epam.memleak.model.Alert;
import com.epam.memleak.model.Entry;
import com.epam.memleak.model.WeatherForecast;
import com.epam.memleak.util.CommandEnum;
import com.epam.memleak.util.Generator;

public class User {

    private WeatherController controller; 
    private CommandEnum commandEnum;
    private Command command;
    private static int id = 0;
    private Entry entry;
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

    public void setCommandEnum(final CommandEnum commandEnum) {
        this.commandEnum = commandEnum;
    }

    public Alert getAlert() {
        return alert;
    }

    public void setAlert(final Alert alert) {
        this.alert = alert;
    }

    public void setWeather(final WeatherForecast weather) {
        this.weather = weather;
    }

    public Entry getEntry() {
        return entry;
    }

    public void setEntry(final Entry entry) {
        this.entry = entry;
    }

    public WeatherController getController() {
        return controller;
    }

    public void setController(final WeatherController controller) {
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
        Entry entry = new Entry();
        entry.setAddress(Generator.generateAddress());
        entry.setDate(Generator.generateDate());
        this.entry = entry;
    }
}
