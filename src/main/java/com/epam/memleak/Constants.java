package com.epam.memleak;

public class Constants {

    private Constants() {}

    public static final int NUMBER_OF_WEATHER_STATIONS = 10000;
    public static final String DECIMAL_FORMAT = "#0.0";
    
    // generator
    public static final int ADDRESS_ABBREVIATION_SIZE = 3;
    public static final int TEMP_RANGE = 35; //from -5 to +30
    public static final int TEMP_OFFSET = -5;
    public static final double TEMP_BOTTOM_GRADE = 0;
    public static final double TEMP_TOP_GRADE = 30;
    
    public static final int PRESSURE_RANGE = 70;
    public static final int PRESSURE_OFFSET = 980;
    public static final int HUMIDITY_RANGE = 54;
    public static final int HUMIDITY_OFFSET = 45;

}
