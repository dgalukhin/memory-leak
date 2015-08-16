package com.epam.memleak2.model;

import java.util.Date;

public class Entry {

    private Address address;
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "address: " + address + ", date: " + date;
    }
}
