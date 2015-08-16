package com.epam.memleak2.model;

public class Alert {

    private Entry location;
    private String alert;
    private boolean hazard = false;

    public Entry getLocation() {
        return location;
    }

    public void setLocation(Entry location) {
        this.location = location;
    }

    public String getAlert() {
        return alert;
    }

    public void setAlert(String alert) {
        this.alert = alert;
    }

    public boolean isHazard() {
        return hazard;
    }

    public void setHazard(boolean hazard) {
        this.hazard = hazard;
    }
}
