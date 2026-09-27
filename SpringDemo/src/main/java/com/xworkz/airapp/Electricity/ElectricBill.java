package com.xworkz.airapp.Electricity;

import org.springframework.stereotype.Component;

@Component
public class ElectricBill {

    private String customerName;
    private int unitsConsumed;
    private double billAmount;

    public void calculateBill() {
        billAmount = unitsConsumed * 7.5;
        System.out.println("Bill Amount: " + billAmount);
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getUnitsConsumed() {
        return unitsConsumed;
    }

    public void setUnitsConsumed(int unitsConsumed) {
        this.unitsConsumed = unitsConsumed;
    }

    public double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(double billAmount) {
        this.billAmount = billAmount;
    }

    @Override
    public String toString() {
        return "ElectricBill{" +
                "customerName='" + customerName + '\'' +
                ", unitsConsumed=" + unitsConsumed +
                ", billAmount=" + billAmount +
                '}';
    }
}
