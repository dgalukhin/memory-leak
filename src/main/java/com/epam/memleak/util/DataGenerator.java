package com.epam.memleak.util;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import com.epam.memleak.weather.model.City;

public class DataGenerator {

    private static final int CITY_ABBREVIATION_SIZE = 2;
    private static final int TEMP_RANGE = 40;
    private static final int TEMP_OFFSET = 15;
    private static final int PRESSURE_RANGE = 70;
    private static final int PRESSURE_OFFSET = 980;
    private static final int HUMIDITY_RANGE = 54;
    private static final int HUMIDITY_OFFSET = 45;
    private static final int DATE_FROM = 2014;
    private static final int DATE_TO = 2015;
    private static final int ID_RANGE = 10000; 

    private static final Random random = new Random();
    private static final char[] capitalLetters = {'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', 'A', 'S', 'D', 'F', 'G', 'H',
        'J', 'K', 'L', 'Z', 'X', 'C', 'V', 'B', 'N', 'M'};

    public static City generateCity() {
        char[] result = new char[CITY_ABBREVIATION_SIZE];
        for (int i = 0; i < CITY_ABBREVIATION_SIZE; i++) {
            int randomInt = random.nextInt(capitalLetters.length);
            result[i] = capitalLetters[randomInt];
        }
        City city = new City();
        city.setCityAbbreviation(new String(result));
        return city;
    }

    public static int geterateRandomId() {
        return random.nextInt(ID_RANGE);
    }

    public static int generateTemp() {
        return random.nextInt(TEMP_RANGE) - TEMP_OFFSET;
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
        int year = randBetween(DATE_FROM, DATE_TO);
        gc.set(gc.YEAR, year);
        int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));
        gc.set(gc.DAY_OF_YEAR, dayOfYear);

        return gc.getTime();
    }

    public static int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }

    public static void main(String[] args) {
        Set<Date> ds = new HashSet<Date>();
        for (int i = 0; i < 1000; i++) {
            Date d = generateDate();
            ds.add(d);
        }
        System.out.println(ds.size());

    }
}
