package com.dgr.vehicles.van;

import com.dgr.interfaces.PlateBehaviour;

import java.util.Random;

public class VanPlate implements PlateBehaviour {
    private String plate;

    @Override
    public void create() {
        plate = "V" + (new Random().nextInt(9000) + 1000);

    }

    @Override
    public String getPlate() {
        return plate;
    }
}
