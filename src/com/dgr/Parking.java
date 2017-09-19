package com.dgr;

import com.dgr.interfaces.Observer;
import com.dgr.interfaces.Subject;
import com.dgr.vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Parking implements Subject{
    private final static int PARKING_CAPACITY = 25;
    private final static int MAX_STAY = 48;

    private List<Vehicle> vehiclesInParking = new ArrayList<>();
    private Vehicle currentVehicle;

    private void setCurrentVehicle(Vehicle v){
        currentVehicle = v;
    }

    boolean isParkingFull(){
        return vehiclesInParking.size() >= PARKING_CAPACITY;
    }

    void acceptVehicle(Vehicle vehicle) {
        vehicle.entersIntoParking(new Random().nextInt(MAX_STAY) + 1);
        vehiclesInParking.add(vehicle);
    }

    void rejectVehicle(Vehicle vehicle) {
        vehicle.doesNotEnterIntoParking();
        setCurrentVehicle(vehicle);
        vehicleAction();
    }

    private void removeVehicle(Vehicle vehicle) {
        vehicle.leavesParking();
        vehiclesInParking.remove(vehicle);
        setCurrentVehicle(vehicle);
        vehicleAction();
    }

    List<Vehicle> decreaseTimeLeftForAllCars() {
        List<Vehicle> vehiclesNotLeavingYet = new ArrayList<>();
        List<Vehicle> temp = new ArrayList<>(vehiclesInParking);
        for(Vehicle v : temp){
            v.decreaseTimeLeft();
            if (v.hoursLeft == 0) {
                removeVehicle(v);
            } else  {
                vehiclesNotLeavingYet.add(v);
            }
        }
        return vehiclesNotLeavingYet;
    }

    // Observer design pattern applied

    private List<Observer> observers = new ArrayList<>();

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    public void notifyObservers() {
        for (Observer observer : observers){
            observer.update(currentVehicle);
        }
    }

    private void vehicleAction() {
        notifyObservers();
    }
}
