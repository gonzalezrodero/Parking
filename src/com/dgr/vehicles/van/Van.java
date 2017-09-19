package com.dgr.vehicles.van;

import com.dgr.vehicles.Vehicle;

public class Van extends Vehicle {
    public Van(){
        setPriceBehaviour(new VanPrice());
        setPlateBehaviour(new VanPlate());
    }

    public String reportAccepted(){
        return "The van\t\twith plate " + getPlate()
                + "\tspent " + totalHours
                + " hours in the parking and paid \t"
                + getPrice() + " euros";
    }

    public String reportRejected(){
        return "The van\t\twith plate " + getPlate() + " \twas rejected";
    }
}
