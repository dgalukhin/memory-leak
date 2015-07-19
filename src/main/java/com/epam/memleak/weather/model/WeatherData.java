package com.epam.memleak.weather.model;

public class WeatherData {

    private int temp;
    private int humidity;
    private int pressure;
    private double visibility;
    private int heatIndex; // 29 grad C
    private int dewPoint; // 17 grad C
    private int rainfall; // 0 - 20mm
    private int ultraviolet; // 0-12
    private double windspeed; // 0-20 km/h

    public double getVisibility() {
        return visibility;
    }

    public void setVisibility(double visibility) {
        this.visibility = visibility;
    }

    public int getHeatIndex() {
        return heatIndex;
    }

    public void setHeatIndex(int heatIndex) {
        this.heatIndex = heatIndex;
    }

    public int getDewPoint() {
        return dewPoint;
    }

    public void setDewPoint(int dewPoint) {
        this.dewPoint = dewPoint;
    }

    public int getRainfall() {
        return rainfall;
    }

    public void setRainfall(int rainfall) {
        this.rainfall = rainfall;
    }

    public int getUltraviolet() {
        return ultraviolet;
    }

    public void setUltraviolet(int ultraviolet) {
        this.ultraviolet = ultraviolet;
    }

    public double getWindspeed() {
        return windspeed;
    }

    public void setWindspeed(double windspeed) {
        this.windspeed = windspeed;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    //displays
    public String getBriefDisplay() {
        StringBuilder sb = new StringBuilder();
        sb.append("Temp: ");
        sb.append(getTemp());
        sb.append(", humidity: ");
        sb.append(getHumidity());
        sb.append(", pressure: ");
        sb.append(getPressure());
        return sb.toString();
    }

    public String getFullDisplay() {
        StringBuilder sb = new StringBuilder();
        sb.append("Temp: ");
        sb.append(getTemp());
        sb.append(", humidity: ");
        sb.append(getHumidity());
        sb.append(", pressure: ");
        sb.append(getPressure());
        return sb.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + dewPoint;
        result = prime * result + heatIndex;
        result = prime * result + humidity;
        result = prime * result + pressure;
        result = prime * result + rainfall;
        result = prime * result + temp;
        result = prime * result + ultraviolet;
        long temp;
        temp = Double.doubleToLongBits(visibility);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(windspeed);
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
        WeatherData other = (WeatherData) obj;
        if (dewPoint != other.dewPoint)
            return false;
        if (heatIndex != other.heatIndex)
            return false;
        if (humidity != other.humidity)
            return false;
        if (pressure != other.pressure)
            return false;
        if (rainfall != other.rainfall)
            return false;
        if (temp != other.temp)
            return false;
        if (ultraviolet != other.ultraviolet)
            return false;
        if (Double.doubleToLongBits(visibility) != Double
                .doubleToLongBits(other.visibility))
            return false;
        if (Double.doubleToLongBits(windspeed) != Double
                .doubleToLongBits(other.windspeed))
            return false;
        return true;
    }
}