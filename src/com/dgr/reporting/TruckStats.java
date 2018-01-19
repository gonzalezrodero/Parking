package com.dgr.reporting;

import com.dgr.Parking;
import com.dgr.interfaces.Observer;
import com.dgr.interfaces.Report;
import com.dgr.vehicles.Vehicle;
import com.dgr.vehicles.truck.Truck;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TruckStats implements Observer, Report {
    private List<Vehicle> acceptedTrucks = new ArrayList<>();
    private double totalMoneyEarned = 0;

    TruckStats(Parking parking){
        parking.registerObserver(this);
    }

    @Override
    public void update(Vehicle vehicle) {
        if(!vehicle.isRejected && vehicle instanceof Truck){
            acceptedTrucks.add(vehicle);
            totalMoneyEarned += vehicle.getPrice();
        }
    }

    @Override
    public void reportToFile(File report) {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(report.getAbsoluteFile(), true)))){
            out.println("Number of trucks accepted: " + acceptedTrucks.size());
            out.println("Total money earned by trucks: " + totalMoneyEarned);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
