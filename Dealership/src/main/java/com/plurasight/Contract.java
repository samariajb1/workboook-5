package com.plurasight;

public abstract class Contract {
    protected String customerName,customerEmail,saleDate;
    protected double salePrice, monthlyPayment;
    protected Vehicle vehicle;

    public Contract(String customerName, String customerEmail, String saleDate, double salePrice, double monthlyPayment,Vehicle vehicle) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.saleDate = saleDate;
        this.salePrice = salePrice;
        this.monthlyPayment = monthlyPayment;
        this.vehicle = vehicle;


    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    public abstract double getSalePrice();

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public abstract double getMonthlyPayment();

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

}
