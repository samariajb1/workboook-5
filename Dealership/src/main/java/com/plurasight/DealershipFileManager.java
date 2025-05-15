package com.plurasight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

// a bunch of functions we need , but not object itself
public class DealershipFileManager {
    private static final String filePath = "todo"; //Todo: add proper file path

    //Read & Parse Dealership + inventory from file
    public static Dealership getDealership() throws Exception{

        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        Dealership dealership = new Dealership(reader.readLine());
        String line;

        while((line = reader.readLine()) != null){
            dealership.addVehicle(new Vehicle(line));
        }
        reader.close();
        return dealership;
    }

    //Overwrite Dealership file with new contents
    public static void saveDealership(Dealership dealership) throws Exception{

        FileWriter writer = new FileWriter(filePath, false);

        //TODO: Test to Make Sure write overwrites the files contents completely with new data
        writer.write(dealership.toString());
        writer.close();
    }



}
