package com.epam.memleak.weather.model;

public class City {

    private String cityAbbreviation;

    public String getCityAbbreviation() {
        return cityAbbreviation;
    }

    public void setCityAbbreviation(String cityAbbreviation) {
        this.cityAbbreviation = cityAbbreviation;
    }

    @Override
    public String toString() {
        return "City [cityAbbreviation=" + cityAbbreviation + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime
                * result
                + ((cityAbbreviation == null) ? 0 : cityAbbreviation.hashCode());
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
        City other = (City) obj;
        if (cityAbbreviation == null) {
            if (other.cityAbbreviation != null)
                return false;
        } else if (!cityAbbreviation.equals(other.cityAbbreviation))
            return false;
        return true;
    }

}
