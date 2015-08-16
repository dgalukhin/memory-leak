package com.epam.memleak2.util;

import com.epam.memleak2.command.AlertsCommand;
import com.epam.memleak2.command.Command;
import com.epam.memleak2.command.WeatherForecastCommand;

public enum CommandEnum {

    DAILY_FORECAST(new WeatherForecastCommand()), ALERTS(new AlertsCommand());

    private Command command;

    private CommandEnum(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return this.command;
    }

}
