package com.xworkz.airapp.aircraft;

public class Building   {

    private int floors;
    private String buildingName;
    private double appriciationAmt;

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public double getAppriciationAmt() {
        return appriciationAmt;
    }

    public void setAppriciationAmt(double appriciationAmt) {
        this.appriciationAmt = appriciationAmt;
    }

    public void buildingEnvironment(){
        System.out.println("Best for family");
    }

    @Override
    public String toString() {
        return "Building{" +
                "floors=" + floors +
                ", buildingName='" + buildingName + '\'' +
                ", appriciationAmt=" + appriciationAmt +
                '}';
    }
}
