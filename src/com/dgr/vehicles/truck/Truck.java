package com.dgr.vehicles.truck;

import com.dgr.vehicles.Vehicle;

public class Truck extends Vehicle {
    public Truck(){
        setPriceBehaviour(new TruckPrice());
        setPlateBehaviour(new TruckPlate());
    }

    public String reportAccepted(){
        return "The truck\twith plate " + getPlate()
                + "\tspent " + totalHours
                + " hours in the parking and paid \t"
                + getPrice() + " euros";
    }

    public String reportRejected(){
        return "The truck\twith plate " + getPlate() + " \twas rejected";
    }
}
