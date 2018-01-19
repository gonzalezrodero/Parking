package com.dgr;

import com.dgr.factories.VehicleFactory;
import com.dgr.reporting.ReportPrinter;
import com.dgr.vehicles.Vehicle;

import java.io.File;

public class Main {
    private final static int HOURS = 24;
    private final static int DAYS = 30;
    private static Parking parking = new Parking();
    private static File parkingReport = new File("./reports/parking.txt");
    private static ReportPrinter reportPrinter = new ReportPrinter(parking, parkingReport, DAYS);

    public static void main(String[] args) {
        int numHours = 0;

        while(numHours < HOURS * DAYS){
            parking.decreaseTimeLeftForAllCars();
            Vehicle vehicle = VehicleFactory.vehicleArrives();
            if(!parking.isParkingFull()){
                parking.acceptVehicle(vehicle);
            } else {
                parking.rejectVehicle(vehicle);
            }
            numHours++;
        }
        while (parking.decreaseTimeLeftForAllCars().size() > 0);

        reportPrinter.printReport();
    }
}
