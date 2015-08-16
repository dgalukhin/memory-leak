package com.epam.memleak2;

import com.epam.memleak2.controller.WeatherController;
import com.epam.memleak2.controller.WeatherControllerImpl;
import com.epam.memleak2.user.UserThread;

public class Runner {

    public static void main(String[] args) {

        WeatherController controller = new WeatherControllerImpl();
        while(true) {
            Runnable worker = new UserThread(controller);
            worker.run();
        }
    }
}
