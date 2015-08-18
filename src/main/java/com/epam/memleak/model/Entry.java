package com.epam.memleak.model;

import java.util.Date;

public class Entry {

    private Address address;
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(final Date date) {
        this.date = date;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(final Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "address: " + address + ", date: " + date;
    }
}
