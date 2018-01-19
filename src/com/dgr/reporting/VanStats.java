package com.dgr.reporting;

import com.dgr.Parking;
import com.dgr.interfaces.Observer;
import com.dgr.interfaces.Report;
import com.dgr.vehicles.Vehicle;
import com.dgr.vehicles.van.Van;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class VanStats implements Observer, Report {
    private List<Vehicle> acceptedVans = new ArrayList<>();
    private double totalMoneyEarned = 0;

    VanStats(Parking parking){
        parking.registerObserver(this);
    }

    @Override
    public void update(Vehicle vehicle) {
        if(!vehicle.isRejected && vehicle instanceof Van){
            acceptedVans.add(vehicle);
            totalMoneyEarned += vehicle.getPrice();
        }
    }

    @Override
    public void reportToFile(File report) {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(report.getAbsoluteFile(), true)))){
            out.println("Number of vans accepted: " + acceptedVans.size());
            out.println("Total money earned by vans: " + totalMoneyEarned);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
