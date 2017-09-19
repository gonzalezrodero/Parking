package com.dgr.vehicles.truck;

import com.dgr.interfaces.PriceBehaviour;

public class TruckPrice implements PriceBehaviour {
    private double price;

    @Override
    public void calculate(int hours) {
        price = 4.5 * hours;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
