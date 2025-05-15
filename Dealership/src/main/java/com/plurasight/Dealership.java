package com.plurasight;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Dealership {
private String name,address,phone;
private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    public Dealership(String parsable){
        this.inventory = new ArrayList<>();

        //Parse dealership
        String[] tokens = parsable.split("\\|");
        this.name = tokens[0];
        this.address = tokens[1];
        this.phone = tokens[2];

    }

    public ArrayList<Vehicle> getAllVehicles(){
        return this.inventory;
    }

    public void addVehicle(Vehicle vehicle){
        inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle){
        inventory.remove(vehicle);
    }

   public ArrayList<Vehicle> getVehiclesByPrice(float min, float max) {
        return inventory.stream().filter(vehicle -> vehicle.getPrice() > min && vehicle.getPrice() <max).collect(Collectors.toCollection(ArrayList::new));
    }
    public ArrayList<Vehicle> getVehicleMakeModel(String make, String model){
        return inventory.stream().filter(vehicle -> vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)).collect(Collectors.toCollection(ArrayList::new));
    }                                                   //lambda                      //A predicate is a bit of logic that returns true or false
    public ArrayList<Vehicle> getVehicleYear(int min, int max) {
        return inventory.stream().filter(vehicle -> vehicle.getYear() >min && vehicle.getYear() <max).collect(Collectors.toCollection(ArrayList::new));
    }
    public ArrayList<Vehicle> getVehicleColor(String color){
        return inventory.stream().filter(vehicle -> vehicle.getColor().equalsIgnoreCase(color)).collect(Collectors.toCollection(ArrayList::new));
    }
    public ArrayList<Vehicle> getVehicleByMileage(float min, float max){
        return inventory.stream().filter(vehicle -> vehicle.getOdometer()>min && vehicle.getOdometer()<max).collect(Collectors.toCollection(ArrayList::new));

    }
    public ArrayList<Vehicle> getVehicleByType(String vehicleType) {
        return inventory.stream().filter(vehicle -> vehicle.getVehicleType().equalsIgnoreCase(vehicleType)).collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(String.format("%s|%s|%s"));
        for(Vehicle vehicle : inventory){
            builder.append("\n").append(vehicle);
        }
        return builder.toString();
    }
}
