package com.xworkz.airapp.aircraft;

public class Laptop {

    private String brand;
    private int ram;
    private double price;

    public void upgradeRam(int additionalRam) {
        ram += additionalRam;
        System.out.println("RAM upgraded to: " + ram + " GB");
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
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

    @Override
    public String toString() {
        return "Laptop{" +
                "brand='" + brand + '\'' +
                ", ram=" + ram +
                ", price=" + price +
                '}';
    }
}
