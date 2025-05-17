package com.plurasight;

import java.io.*;
import java.util.ArrayList;

public class ContractFileManager {
    public static void saveContract(Contract contractToBeSaved){
       try {
           FileWriter fileWriter = new FileWriter("src/main/resources/contracts.csv");
           fileWriter.append(contractToBeSaved.toString());
           fileWriter.close();
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
    }
    public static ArrayList<Contract> loadContracts(){
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/contracts.csv"));
            String line;

            //Empty contract list
            ArrayList<Contract> loadedContracts = new ArrayList<>();

            //Fill the list
            while ((line = bufferedReader.readLine()) != null){
                String[] parts =  line.split("\\|");
                String contractType = parts[0];
                String date = parts[1];
                String name = parts[2];
                String email = parts[3];
                int vin = Integer.parseInt(parts[4]);
                String make = parts[5];
                String model = parts[6];
                String carType = parts[7];
                String color = parts[8];
                int odometer = Integer.parseInt(parts[9]);
                double price = Double.parseDouble(parts[10]);






//                loadedContracts.add(new )
            }

            return loadedContracts;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
