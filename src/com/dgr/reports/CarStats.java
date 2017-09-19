package com.dgr.reports;

import com.dgr.Parking;
import com.dgr.interfaces.Observer;
import com.dgr.interfaces.Report;
import com.dgr.vehicles.Vehicle;
import com.dgr.vehicles.car.Car;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CarStats implements Observer, Report {
    private List<Vehicle> acceptedCars = new ArrayList<>();
    private double totalMoneyEarned = 0;

    CarStats(Parking parking){
        parking.registerObserver(this);
    }

    @Override
    public void update(Vehicle vehicle) {
        if(!vehicle.isRejected && vehicle instanceof Car){
            acceptedCars.add(vehicle);
            totalMoneyEarned += vehicle.getPrice();
        }
    }

    @Override
    public void reportToFile(File report) {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(report.getAbsoluteFile(), true)))){
            out.println("Number of cars accepted: " + acceptedCars.size());
            out.println("Total money earned by cars: " + totalMoneyEarned);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
