package com.dgr.vehicles.car;

import com.dgr.interfaces.PlateBehaviour;

import java.util.Random;

public class CarPlate implements PlateBehaviour {
    private String plate;

    @Override
    public void create() {
        plate = "C" + (new Random().nextInt(9000) + 1000);
    }

    @Override
    public String getPlate() {
        return plate;
    }
}
