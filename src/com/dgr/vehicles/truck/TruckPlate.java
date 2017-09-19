package com.dgr.vehicles.truck;

import com.dgr.interfaces.PlateBehaviour;

import java.util.Random;

public class TruckPlate implements PlateBehaviour {
    private String plate;

    @Override
    public void create() {
        plate = "T" + (new Random().nextInt(9000) + 1000);
    }

    @Override
    public String getPlate() {
        return plate;
    }
}
