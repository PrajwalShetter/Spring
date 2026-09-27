package com.xworkz.airapp.aircraft;

public class Kite {

    private String shape;
    private String madeUpOff;
    private double durability;

    public void fly(){
        System.out.println("Hureee the kite is flying");
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public String getMadeUpOff() {
        return madeUpOff;
    }

    public void setMadeUpOff(String madeUpOff) {
        this.madeUpOff = madeUpOff;
    }

    public double getDurability() {
        return durability;
    }

    public void setDurability(double durability) {
        this.durability = durability;
    }

    @Override
    public String toString() {
        return "Kite{" +
                "shape='" + shape + '\'' +
                ", madeUpOff='" + madeUpOff + '\'' +
                ", durability=" + durability +
                '}';
    }
}
