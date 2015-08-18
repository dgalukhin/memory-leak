package com.epam.memleak.util;

import com.epam.memleak.command.AlertsCommand;
import com.epam.memleak.command.Command;
import com.epam.memleak.command.WeatherForecastCommand;

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
