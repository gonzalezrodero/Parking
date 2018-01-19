package com.dgr.reporting;

import com.dgr.Parking;
import com.dgr.interfaces.Observer;
import com.dgr.interfaces.Report;
import com.dgr.vehicles.Vehicle;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RejectedVehiclesStats implements Observer, Report {
    private List<Vehicle> rejectedVehicles = new ArrayList<>();

    RejectedVehiclesStats(Parking parking){
        parking.registerObserver(this);
    }

    @Override
    public void update(Vehicle vehicle) {
        if (vehicle.isRejected){
            rejectedVehicles.add(vehicle);
        }
    }

    @Override
    public void reportToFile(File report) {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(report.getAbsoluteFile(), true)))){
            out.println("Number of vehicles rejected: " + rejectedVehicles.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
