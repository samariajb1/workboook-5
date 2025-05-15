package com.plurasight;

public class Program {
    public static void main(String[] args) {
        UserInterface userInterface = null;
        try {
            //userinterface object and loading with a dealership object
            userInterface = new UserInterface(DealershipFileManager.getDealership());
        } catch (Exception ignore) {
           System.out.println("Failed to Load Dealership File!");
           System.exit(1);
        }

        try {
            userInterface.display();
        } catch (Exception e) {
            System.out.println("Failed to Save Dealership File!");
            System.exit(1);
        }
    }


}
