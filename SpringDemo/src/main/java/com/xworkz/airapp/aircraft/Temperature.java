package com.xworkz.airapp.aircraft;

public class Temperature {
    private double celsius;
    private double fahrenheit;
    private String unit;

    public void convertToFahrenheit() {
        fahrenheit = (celsius * 9 / 5) + 32;
        System.out.println("Temperature: " + fahrenheit + " F");
    }

    public double getCelsius() {
        return celsius;
    }

    public void setCelsius(double celsius) {
        this.celsius = celsius;
    }

    public double getFahrenheit() {
        return fahrenheit;
    }

    public void setFahrenheit(double fahrenheit) {
        this.fahrenheit = fahrenheit;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Temperature{" +
                "celsius=" + celsius +
                ", fahrenheit=" + fahrenheit +
                ", unit='" + unit + '\'' +
                '}';
    }
}
