package com.rk.messaging.dao;

public class Address {
    private String city;
    private String state;
    private String country;


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        StringBuffer customerAsString = new StringBuffer();
        customerAsString.append(", Address[")
                .append("City: ").append(city)
                .append(", State: ").append(state)
                .append(", Country: ").append(country)
                .append(" ]");
        return customerAsString.toString();
    }
}
