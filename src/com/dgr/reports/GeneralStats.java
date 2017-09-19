package com.dgr.reports;

import com.dgr.Parking;
import com.dgr.interfaces.Observer;
import com.dgr.interfaces.Report;
import com.dgr.vehicles.Vehicle;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GeneralStats implements Observer, Report{
    private List<Vehicle> acceptedVehicles = new ArrayList<>();
    private double totalMoneyEarned = 0;
    private int longestStay = 0;
    private int days;

    GeneralStats(Parking parking, int days){
        parking.registerObserver(this);
        this.days = days;
    }

    @Override
    public void update(Vehicle vehicle) {
        if(!vehicle.isRejected) {
            acceptedVehicles.add(vehicle);
            totalMoneyEarned += vehicle.getPrice();
        }

    }

    @Override
    public void reportToFile(File report) {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(report.getAbsoluteFile(), true)))){
            out.println("These stats correspond to " + days + " days of Parking service:");
            out.println("Number of vehicles accepted: " + acceptedVehicles.size());
            out.println("Total money earned: " + totalMoneyEarned);
            List<Vehicle> longestStayVehicles = getLongestStayVehicles();
            out.print("The following vehicles have stayed " + longestStay + " hours in the Parking, which is the longest a vehicle has been: ");
            for(Vehicle v : longestStayVehicles){
                out.print(v.getPlate() + " ");
            }
            out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Vehicle> getLongestStayVehicles(){
        List<Vehicle> longestStayVehicles = new ArrayList<>();
        for(Vehicle v : acceptedVehicles){
            if(v.totalHours > longestStay){
                longestStay = v.totalHours;
            }
        }
        for(Vehicle v : acceptedVehicles){
            if(v.totalHours == longestStay){
                longestStayVehicles.add(v);
            }
        }
        return longestStayVehicles;
    }
}
