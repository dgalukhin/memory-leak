package com.epam.memleak.model;

import java.text.DecimalFormat;

import static com.epam.memleak.Constants.*;

public class WeatherForecast {

    private static final ThreadLocal<DecimalFormat> dateFormatHolder = new ThreadLocal<DecimalFormat>() {
        @Override
        protected DecimalFormat initialValue() {
            return new DecimalFormat(DECIMAL_FORMAT);
        }
    };

    private double temp;
    private int pressure;
    private int humidity;

    public double getTemp() {
        return temp;
    }
    public void setTemp(double temp) {
        this.temp = temp;
    }
    public int getPressure() {
        return pressure;
    }
    public void setPressure(int pressure) {
        this.pressure = pressure;
    }
    public int getHumidity() {
        return humidity;
    }
    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + humidity;
        result = prime * result + pressure;
        long temp;
        temp = Double.doubleToLongBits(this.temp);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        WeatherForecast other = (WeatherForecast) obj;
        if (humidity != other.humidity)
            return false;
        if (pressure != other.pressure)
            return false;
        if (Double.doubleToLongBits(temp) != Double
                .doubleToLongBits(other.temp))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "temp: " + dateFormatHolder.get().format(temp) + ", pressure: " + pressure
                + ", humidity: " + humidity;
    }
}
