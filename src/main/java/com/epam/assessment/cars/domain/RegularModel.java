package com.epam.assessment.cars.domain;

public class RegularModel extends Model {
    private int engineDisplacement;
    private double fuelConsumption;

    public RegularModel(String manufacturer, String modelName, int power, int engineDisplacement, double fuelConsumption) {
        super(manufacturer,modelName,power);
        this.engineDisplacement = engineDisplacement;
        this.fuelConsumption = fuelConsumption;
    }

    public int getEngineDisplacement() {
        return this.engineDisplacement;
    }

    public double getFuelConsumption() {
        return this.fuelConsumption;
    }

    @Override
    public String toString() {
        return "RegularModel{" +
                super.toString() +
                ", engineDisplacement=" + getEngineDisplacement()+
                ", fuelConsumption=" + getFuelConsumption() +
                '}';
    }
}
