package com.epam.memleak.model;

public class Alert {

    private String alert;
    private boolean hazard = false;

    public String getAlert() {
        return alert;
    }

    public void setAlert(final String alert) {
        this.alert = alert;
    }

    public boolean isHazard() {
        return hazard;
    }

    public void setHazard(final boolean hazard) {
        this.hazard = hazard;
    }
}
