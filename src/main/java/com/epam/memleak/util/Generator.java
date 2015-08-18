package com.epam.memleak.util;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

import com.epam.memleak.model.Address;

import static com.epam.memleak.Constants.*;

public class Generator {

    private static final Random random = new Random();
    private static final char[] capitalLetters = "QWERTYUIOPASDFGHJKLZXCVBNM".toCharArray();

    public static Address generateAddress() {
        char[] result = new char[ADDRESS_ABBREVIATION_SIZE];
        for (int i = 0; i < ADDRESS_ABBREVIATION_SIZE; i++) {
            int randomInt = random.nextInt(capitalLetters.length);
            result[i] = capitalLetters[randomInt];
        }
        Address addr = new Address();
        addr.setAddress(new String(result));
        return addr;
    }

    public static double generateTemperature() {
        return (random.nextDouble()) * TEMP_RANGE + TEMP_OFFSET;
    }

    public static int generatePressure() {
        return random.nextInt(PRESSURE_RANGE) + PRESSURE_OFFSET;
    }

    public static int generateHumidity() {
        return random.nextInt(HUMIDITY_RANGE) + HUMIDITY_OFFSET;
    }

    public static Date generateDate() {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTimeInMillis(0);
        gc.set(gc.YEAR, 2015);
        int dayOfYear = randBetween(1, 7);
        gc.set(gc.DAY_OF_YEAR, dayOfYear);
        return gc.getTime();
    }

    public static CommandEnum generateCommand() {
        int pick = random.nextInt(CommandEnum.values().length);
        return CommandEnum.values()[pick];
    }

    public static int randBetween(final int start, final int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }
}
