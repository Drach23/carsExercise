package com.epam.assessment.cars.domain;

public class Model implements Comparable<Model> {
    private String manufacturer;
    private String modelName;
    private int power;

    public Model(String manufacturer, String modelName, int power){
        this.manufacturer = manufacturer;
        this.modelName = modelName;
        this.power = power;
    }

    public String getManufacturer() {

        return this.manufacturer;
    }

    public String getModelName() {
        return this.modelName;
    }

    public int getPower() {
        return this.power;
    }

    @Override
    public String toString() {
        return "manufacturer='" + getManufacturer() + "'"
                +
                ", modelName='" + getModelName() + "'" +
                ", power=" + getPower() ;
    }

    @Override
    public int compareTo(Model other) {

        int result = this.manufacturer.compareTo(other.manufacturer);

        if (result == 0) {
            result = this.modelName.compareTo(other.modelName);
        }

        return result;
    }

}
