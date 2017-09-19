package com.dgr.factories;

import com.dgr.vehicles.Vehicle;
import com.dgr.vehicles.car.Car;
import com.dgr.vehicles.truck.Truck;
import com.dgr.vehicles.van.Van;

import java.util.Random;

public class VehicleFactory {
    private static Random rnd = new Random();

    public static Vehicle vehicleArrives(){
        int num = rnd.nextInt(10);
        if(num < 5){
            return new Car();
        } else if(num < 8){
            return new Van();
        } else {
            return new Truck();
        }
    }
}
