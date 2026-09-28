package com.xworkz.airapp.aircraft;

public class Movie {

    private String name;
    private double budget;
    private String heroName;

    public void watchMovie(){
        System.out.println("Movie Time");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", budget=" + budget +
                ", heroName='" + heroName + '\'' +
                '}';
    }
}
