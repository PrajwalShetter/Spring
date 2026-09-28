package com.xworkz.airapp.aircraft;

public class ShoppingMall {

    private String name;
    private int numberOfShops;
    private String mallManager;

    public void mallTime() {
        System.out.println("Morning 10:00 to Night 10:00");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfShops() {
        return numberOfShops;
    }

    public void setNumberOfShops(int numberOfShops) {
        this.numberOfShops = numberOfShops;
    }

    public String getMallManager() {
        return mallManager;
    }

    public void setMallManager(String mallManager) {
        this.mallManager = mallManager;
    }

    @Override
    public String toString() {
        return "ShoppingMall{" +
                "name='" + name + '\'' +
                ", numberOfShops=" + numberOfShops +
                ", mallManager='" + mallManager + '\'' +
                '}';
    }
}
