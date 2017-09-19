package com.dgr.reports;

import com.dgr.Parking;

import java.io.File;

public class ReportPrinter {
    private File reportFile;
    private GeneralStats generalStats;
    private RejectedVehiclesStats rejectedVehiclesStats;
    private CarStats carStats;
    private VanStats vanStats;
    private TruckStats truckStats;
    private WholeStats wholeStats;

    public ReportPrinter(Parking parking, File reportFile, int days){
        this.reportFile = reportFile;
        generalStats = new GeneralStats(parking, days);
        rejectedVehiclesStats = new RejectedVehiclesStats(parking);
        carStats = new CarStats(parking);
        vanStats = new VanStats(parking);
        truckStats = new TruckStats(parking);
        wholeStats = new WholeStats(parking);
    }

    public void printReport(){
        generalStats.reportToFile(reportFile);
        rejectedVehiclesStats.reportToFile(reportFile);
        carStats.reportToFile(reportFile);
        vanStats.reportToFile(reportFile);
        truckStats.reportToFile(reportFile);
        wholeStats.reportToFile(reportFile);
    }
}
