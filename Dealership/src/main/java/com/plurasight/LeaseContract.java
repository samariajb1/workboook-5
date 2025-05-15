package com.plurasight;

public class LeaseContract extends Contract {
    private double expectingEndingValue, leaseFee;

    public LeaseContract(String customerName, String customerEmail, String saleDate, double salePrice, double monthlyPayment, Vehicle vehicle, double expectingEndingValue, double leaseFee) {
        super(customerName, customerEmail, saleDate, salePrice, monthlyPayment, vehicle);
        this.expectingEndingValue = salePrice /2;
        this.leaseFee = salePrice *.07;
    }

    @Override
    public double getMonthlyPayment() {
        return (this.salePrice + this.leaseFee) * 1.04/36;//TODO look over percentages and utilizing numbers in java
    }

    @Override
    public double getSalePrice() {
        return  (this.salePrice + this.leaseFee) * 1.04;
    }
}
