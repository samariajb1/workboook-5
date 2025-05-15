package com.plurasight;

public class Vehicle {
    private int vin,year;
    private float odometer,price;
    private String make,model,vehicleType,color;

    public Vehicle(int vin, float odometer, int year, float price, String make, String model, String vehicleType, String color) {
        this.vin = vin;
        this.odometer = odometer;
        this.year = year;
        this.price = price;
        this.make = make;
        this.model = model;
        this.vehicleType = vehicleType;
        this.color = color;
    }

    public Vehicle(String parsable){
       String[] tokens = parsable.split("\\|");

       //Parse Vehicle Info
       this.vin = Integer.parseInt(tokens[0]);
       this.year = Integer.parseInt(tokens[1]);
       this.make = tokens[2];
       this.model = tokens[3];
       this.vehicleType = tokens[4];
       this.color = tokens[5];
       this.odometer = Float.parseFloat(tokens[6]);
       this.price = Float.parseFloat(tokens[7]);
    }

    public int getVin() {
        return vin;
    }

    public float getOdometer() {
        return odometer;
    }

    public int getYear() {
        return year;
    }

    public float getPrice() {
        return price;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return String.format("%d|%d|%s|%s|%s|%s|%.2f|%.2f", vin, year, make, model, vehicleType, color, odometer, price);
    }
}
