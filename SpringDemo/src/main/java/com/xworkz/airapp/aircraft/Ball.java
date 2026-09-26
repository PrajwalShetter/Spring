package com.xworkz.airapp.aircraft;

public class Ball  {

    private double ballSize;
    private String ballName;
    private double cost;

    public void play(){
        System.out.println("lets play Cricket");
    }

    public double getBallSize() {
        return ballSize;
    }

    public void setBallSize(double ballSize) {
        this.ballSize = ballSize;
    }

    public String getBallName() {
        return ballName;
    }

    public void setBallName(String ballName) {
        this.ballName = ballName;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Ball{" +
                "ballSize=" + ballSize +
                ", ballName='" + ballName + '\'' +
                ", cost=" + cost +
                '}';
    }
}
