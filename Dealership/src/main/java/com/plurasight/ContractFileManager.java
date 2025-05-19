package com.plurasight;

import java.io.*;
import java.util.ArrayList;

public class ContractFileManager {
    public static void saveContract(Contract contractToBeSaved){
       try {
           FileWriter fileWriter = new FileWriter("src/main/resources/contracts.csv");
           fileWriter.append(contractToBeSaved.toString());
           fileWriter.close();
       } catch (IOException e) { //Reminder: This is just to crash the program.. throws exception
           throw new RuntimeException(e); //TODO: Allow user to know it failed
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


                loadedContracts.add(Contract.parseContract(line) );
            }

            return loadedContracts;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
