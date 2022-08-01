package com.rk.messaging.dao;

public class Customer {
    private Long id;
    private String name;
    private String type;
    private Address address = new Address();
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        StringBuffer customerAsString = new StringBuffer();
        customerAsString.append("Customer[")
                .append("id: ").append(id)
                .append(", Name: ").append(name)
                .append(", Type: ").append(type)
                .append(address.toString())
                .append(" ]");
        return customerAsString.toString();
    }
}
