package com.github.karlklin.yaml;

public class Address {

    private String given;
    private String family;

    String address;

    public Address() {
    }

    public Address(String given, String family, String address) {
        this.given = given;
        this.family = family;
        this.address = address;
    }

    public String getGiven() {
        return given;
    }

    public void setGiven(String given) {
        this.given = given;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
