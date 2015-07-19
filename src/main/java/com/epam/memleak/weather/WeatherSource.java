package com.epam.memleak.weather;

import java.util.ArrayList;
import java.util.List;

import com.epam.memleak.weather.model.CityDateEntry;
import com.epam.memleak.weather.model.WeatherData;

public class WeatherSource implements Subject{

    private List<Observer> observerList;
    private WeatherData weatherData;
    private CityDateEntry cde;

    public WeatherSource() {
        observerList = new ArrayList<Observer>();
    }

    @Override
    public void registerObserver(Observer o) {
        observerList.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observerList.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer obs: observerList) {
            obs.update(cde, weatherData);
        }
    }

    public void measurementsChanged() {
        notifyObservers();
    }

    public void setWeatherData(CityDateEntry cde, WeatherData weatherData) {
        this.cde = cde;
        this.weatherData = weatherData;
        measurementsChanged();
    }
}
