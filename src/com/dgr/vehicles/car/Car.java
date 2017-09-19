package com.dgr.vehicles.car;

import com.dgr.vehicles.Vehicle;

public class Car extends Vehicle {
    public Car(){
        setPriceBehaviour(new CarPrice());
        setPlateBehaviour(new CarPlate());
    }

    public String reportAccepted(){
        return "The car\t\twith plate " + getPlate()
                + "\tspent " + totalHours
                + " hours in the parking and paid \t"
                + getPrice() + " euros";
    }

    public String reportRejected(){
        return "The car\t\twith plate " + getPlate() + " \twas rejected";
    }
}
