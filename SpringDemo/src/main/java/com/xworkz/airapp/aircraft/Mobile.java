package com.xworkz.airapp.aircraft;

public class Mobile {

    private String name;
    private boolean isWaterProof;
    private double cost;

    public void working(){
        System.out.println("smoothly working in heavy usage");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isWaterProof() {
        return isWaterProof;
    }

    public void setWaterProof(boolean waterProof) {
        isWaterProof = waterProof;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Mobile{" +
                "name='" + name + '\'' +
                ", isWaterProof=" + isWaterProof +
                ", cost=" + cost +
                '}';
    }
}
