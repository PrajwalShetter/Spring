package com.xworkz.airapp.aircraft;

public class Court {

    private String name;
    private int numberOfLawyers;
    private String judgeName;

    public void courtTime(){
        System.out.println("Mor 9:30 to evn 5:00");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfLawyers() {
        return numberOfLawyers;
    }

    public void setNumberOfLawyers(int numberOfLawyers) {
        this.numberOfLawyers = numberOfLawyers;
    }

    public String getJudgeName() {
        return judgeName;
    }

    public void setJudgeName(String judgeName) {
        this.judgeName = judgeName;
    }

    @Override
    public String toString() {
        return "Court{" +
                "name='" + name + '\'' +
                ", numberOfLawyers=" + numberOfLawyers +
                ", judgeName='" + judgeName + '\'' +
                '}';
    }
}
