package com.dgr.reports;

import com.dgr.Parking;
import com.dgr.interfaces.Observer;
import com.dgr.interfaces.Report;
import com.dgr.vehicles.Vehicle;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WholeStats implements Observer, Report {
    private List<Vehicle> rejectedVehicles = new ArrayList<>();
    private List<Vehicle> acceptedVehicles = new ArrayList<>();

    WholeStats(Parking parking){
        parking.registerObserver(this);
    }

    @Override
    public void update(Vehicle vehicle) {
        if(vehicle.isRejected){
            rejectedVehicles.add(vehicle);
        } else {
            acceptedVehicles.add(vehicle);
        }
    }

    @Override
    public void reportToFile(File report) {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(report.getAbsoluteFile(), true)))){
            for(Vehicle v : acceptedVehicles){
                out.println(v.reportAccepted());
            }
            for(Vehicle v : rejectedVehicles){
                out.println(v.reportRejected());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
