package com.example.mvcsinglepattern.to;

public class Phone {

    private String imei;
    private String brand;
    private String model;
    private int ram;
    private double price;

    public Phone() {
    }

    public Phone(String imei, String brand, String model, int ram, double price) {
        this.imei = imei;
        this.brand = brand;
        this.model = model;
        this.ram = ram;
        this.price = price;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

