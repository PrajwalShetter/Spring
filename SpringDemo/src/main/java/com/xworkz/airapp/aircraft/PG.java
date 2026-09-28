package com.xworkz.airapp.aircraft;

public class PG {

    private String name;
    private Double rent;
    private boolean isGood;

    public void livingCost(){
        System.out.println("High");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getRent() {
        return rent;
    }

    public void setRent(Double rent) {
        this.rent = rent;
    }

    public boolean isGood() {
        return isGood;
    }

    public void setGood(boolean good) {
        isGood = good;
    }

    @Override
    public String toString() {
        return "PG{" +
                "name='" + name + '\'' +
                ", rent=" + rent +
                ", isGood=" + isGood +
                '}';
    }
}
