package com.epam.assessment.cars.domain;

public abstract class Car {
    private String licensePlate;
    private Model model;
    protected int distanceDriven;

    public Car(String licensePlate, Model model) {
        this.licensePlate = licensePlate;
        this.model = model;
        this.distanceDriven = 0;
    }

    public abstract void drive(int distance);

    public int getDistanceDriven() {
        return distanceDriven;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public Model getModel() {
        return model;
    }
}
