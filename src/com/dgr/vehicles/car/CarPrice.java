package com.dgr.vehicles.car;

import com.dgr.interfaces.PriceBehaviour;

public class CarPrice implements PriceBehaviour {
    private double price;

    @Override
    public void calculate(int hours) {
        price = 1.5 * hours;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
