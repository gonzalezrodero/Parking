package com.dgr.vehicles.van;

import com.dgr.interfaces.PriceBehaviour;

public class VanPrice implements PriceBehaviour {
    private double price;

    @Override
    public void calculate(int hours) {
        price = 2.25 * hours;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
