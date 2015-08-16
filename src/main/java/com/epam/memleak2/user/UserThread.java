package com.epam.memleak2.user;

import com.epam.memleak2.controller.WeatherController;

public class UserThread implements Runnable {

    private WeatherController controller;

    public UserThread(WeatherController controller) {
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