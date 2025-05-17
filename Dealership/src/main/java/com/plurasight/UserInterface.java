package com.plurasight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private List<Vehicle> vehicleList = new ArrayList<>();
        private Dealership dealership;
        private Scanner scanner;

    public UserInterface(Dealership dealership) {
        this.dealership = dealership;
        this.scanner = new Scanner(System.in);
    }

    public void display() throws Exception{
        System.out.println("*** Welcome to Karisma Car Shop ***");
         boolean running = true;
         while (running){
             System.out.println("\tMain Menu:");
             System.out.println("1. View all vehicles");
             System.out.println("2. Search by price");
             System.out.println("3. Search by make/model");
             System.out.println("4. Search by year");
             System.out.println("5. Search by color");
             System.out.println("6. Search by mileage");
             System.out.println("7. Search by type");
             System.out.println("8. Add a vehicle");
             System.out.println("9. Remove a vehicle");
             System.out.println("0. Exit");
             System.out.print("Choose an option: ");

             int selection = scanner.nextInt();
             scanner.nextLine();
             switch (selection){
                 case 0 -> running = false;
                 case 1 -> processGetAllVehicleRequest();
                 case 2 -> processGetByPriceRequest();
                 case 3 -> processGetByMakeModelRequest();
                 case 4 -> processGetByYear();
                 case 5 -> processGetByColor();
                 case 6 -> processGetByMileageRequest();
                 case 7 -> processGetByVehicleTypeRequest();
                 case 8 -> processAddVehicleRequest();
                 case 9 -> processRemoveRequest();
                 default -> System.out.println("Invalid input. Please enter a number from 0 to 9.");
             }
        }
        scanner.close();
        DealershipFileManager.saveDealership(dealership);
        System.out.println("Thank you for using Karisma Car Shop!");
    }

    //Collecting user input and activating respective function
    public void processGetByPriceRequest() {
        System.out.println("What is the Min Price?: ");
        float min = scanner.nextFloat();
        scanner.nextLine();
        System.out.println("What is the Max Price?: ");
        float max = scanner.nextFloat();
        scanner.nextLine();


        dealership.getVehiclesByPrice(min,max).forEach(System.out::println);
    }

    public void processGetByMakeModelRequest() {
        System.out.println("What is the Make of your Car?:  ");
        String make = scanner.nextLine();
        System.out.println("What is the Model Of Your Car?: ");
        String model = scanner.nextLine();
        scanner.nextLine();

        dealership.getVehicleMakeModel(make,model).forEach(System.out::println);

    }

    public void processGetByYear(){
        System.out.println("What is the Min Year Of The Car?: ");
        int min = scanner.nextInt();
        System.out.println("What is the Max Year Of The Car?: ");
        int max = scanner.nextInt();
        scanner.nextLine();

        dealership.getVehicleYear(min,max).forEach(vehicle -> System.out.print(vehicle));

    }

    public void processGetByColor() {
        System.out.println("What Color is The Car?: ");
        String color = scanner.nextLine();

        dealership.getVehicleColor(color).forEach(System.out::println);

    }
    public void processGetByMileageRequest() {
        System.out.print("Enter Min Mileage: ");
        float min = scanner.nextFloat();
        scanner.nextLine();
        System.out.print("Enter Max Mileage: ");
        float max = scanner.nextFloat();
        scanner.nextLine();

        dealership.getVehicleByMileage(min, max).forEach(System.out::println);
    }
    public void processGetByVehicleTypeRequest() {
        System.out.println("Enter Your Vehicle Type: ");
        String vehicle = scanner.nextLine();
        scanner.nextLine();

        dealership.getVehicleByType(vehicle).forEach(System.out::println);

    }
    public void processGetAllVehicleRequest() {
        if (vehicleList.isEmpty()){  // I asked chat -> "for this function how can I add the right display for the user to be able to see all vehilces that i have stored? heres the funcation  public void processGetAllVehicleRequest() {
// Did it myself and didn't copy
            System.out.print("No Vehicle's Found.");
        }else{
            System.out.println("Vehicles Stored: ");
            for (Vehicle v : vehicleList){
                System.out.println(v);
            }
            dealership.getAllVehicles();// don't feel like this belong
        }


        dealership.getAllVehicles().forEach(System.out::println);
    }
    public void processAddVehicleRequest() {
        System.out.println("What Vehicle Are We Adding?");



    }
    public void processRemoveRequest() {

    }
    public void addVehicle(){
    }
    public void removeVehicle(){
    }

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }
}
