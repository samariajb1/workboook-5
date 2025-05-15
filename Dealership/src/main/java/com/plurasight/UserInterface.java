package com.plurasight;

import java.util.Scanner;

public class UserInterface {

        private Dealership dealership;
        private Scanner scanner;

    public UserInterface(Dealership dealership) {
        this.dealership = dealership;
        this.scanner = new Scanner(System.in);
    }

    public void display() throws Exception{
        //TODO: Add Main UI Loop
        scanner.close();
        DealershipFileManager.saveDealership(dealership);
    }
    public void processGetByPriceRequest() {

    }
    public void processGetByMakeModelRequest() {

    }
    public void processGetByYear(){

    }
    public void processGetByColor() {

    }
    public void processGetByMileageRequest() {

    }
    public void processGetByVehicleTypeRequest() {

    }
    public void processGetAllVehicleRequest() {

    }
    public void processAddVehicleRequest() {

    }
    public void processRemoveRequest() {

    }


}
