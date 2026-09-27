package com.xworkz.airapp.Year;

import org.springframework.stereotype.Component;

@Component
public class Calender  {

    private String name;
    private double size;
    private double cost;

    public void newYear(){
        System.out.println("New Year start's");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Calender{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", cost=" + cost +
                '}';
    }
}
