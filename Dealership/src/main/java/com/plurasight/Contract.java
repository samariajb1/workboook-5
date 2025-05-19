package com.plurasight;

public abstract class Contract {
    protected String customerName,customerEmail,saleDate;
    protected double salePrice;
    protected Vehicle vehicle;

    public Contract(String customerName, String customerEmail, String saleDate, double salePrice,Vehicle vehicle) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.saleDate = saleDate;
        this.salePrice = salePrice;
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


    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    public static Contract parseContract(String parsable) {
        String[] parts = parsable.split("\\|");
        String contractType = parts[0];
        String date = parts[1];
        String name = parts[2];
        String email = parts[3];
        int vin = Integer.parseInt(parts[4]);
        String make = parts[5];
        String model = parts[6];
        String carType = parts[7];
        String color = parts[8];
        int year = 0; //TODO: Figure out what part year is!
        boolean isFinancing = true;// TODO: Figure out what is being financed
        int odometer = Integer.parseInt(parts[9]);
        float price = Float.parseFloat(parts[10]);
        return switch (contractType){
            case "SALE" -> new SalesContract(name,email,date,price,new Vehicle(vin,odometer,year,price,make,model,carType,color),isFinancing);

            case "LEASE" -> new LeaseContract(name,email,date,price,new Vehicle(vin,odometer,year,price,make,model,carType,color));
            default -> throw new IllegalStateException("Unexpected value: " + contractType);
        };

    }

}
