package com.epam.memleak;

import com.epam.memleak.controller.WeatherController;
import com.epam.memleak.controller.WeatherControllerImpl;
import com.epam.memleak.user.UserThread;

public class MemoryLeakRunner {

    public static void main(String[] args) {

        WeatherController controller = new WeatherControllerImpl();
        while(true) {
            Runnable worker = new UserThread(controller);
            worker.run();
        }
    }
}
