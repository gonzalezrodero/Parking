package com.dgr.vehicles;

import com.dgr.interfaces.*;

public abstract class Vehicle {

    // Strategy design pattern applied

    private PlateBehaviour plateBehaviour;
    private PriceBehaviour priceBehaviour;
    public boolean isRejected = false;
    public int hoursLeft;
    public int totalHours;

    protected Vehicle(){
    }

    protected void setPlateBehaviour(PlateBehaviour pb){
        plateBehaviour = pb;
    }

    protected void setPriceBehaviour(PriceBehaviour pb){
        priceBehaviour = pb;
    }

    private void setPlate(){
        plateBehaviour.create();
    }

    public String getPlate(){
        return plateBehaviour.getPlate();
    }

    private void setPrice(int hours){
        priceBehaviour.calculate(hours);
    }

    public double getPrice(){
        return priceBehaviour.getPrice();
    }

    public void entersIntoParking(int hours){
        totalHours = hoursLeft = hours;
        setPlate();
        setPrice(totalHours);
    }

    public void doesNotEnterIntoParking(){
        isRejected = true;
        setPlate();
    }

    public void leavesParking(){

    }

    public void decreaseTimeLeft(){
        hoursLeft--;
    }

    public abstract String reportAccepted();

    public abstract String reportRejected();
}
