package com.epam.memleak.user;

import com.epam.memleak.controller.WeatherController;

public class UserThread implements Runnable {

    private WeatherController controller;

    public UserThread(final WeatherController controller) {
        this.controller = controller;
    }

    public void run() {
        User user = new User();
        user.setWeatherController(controller);
        user.generateEnquiryData();
        user.execute();
        user.report();
    }
}