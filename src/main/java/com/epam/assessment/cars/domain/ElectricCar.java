package com.epam.assessment.cars.domain;

public class ElectricCar extends Car {

    private int batteryLevel;

    public ElectricCar(String licensePlate, ElectricModel electricModel, int batteryLevel) {
        super(licensePlate, electricModel);
        this.batteryLevel = batteryLevel;
    }

    public ElectricModel getElectricModel(){
        return (ElectricModel) super.getModel();
    }


    public int getBatteryLevel() {
        return this.batteryLevel;
    }

    public void charge(int amount) {
        batteryLevel += amount;
        if (batteryLevel > getElectricModel().getBatteryCapacity()) {
            batteryLevel = getElectricModel().getBatteryCapacity();
        }
    }

    @Override
    public void drive(int distance) {
        ElectricModel model = getElectricModel();


        double consumptionPerKm = model.getEnergyConsumption() / 100.0;
        double batteryUsedDouble = consumptionPerKm * distance;


        int consumption = (int) Math.round(batteryUsedDouble);


        if (consumption > batteryLevel) {
            throw new IllegalStateException(
                    "Cannot drive " + distance + " km. Battery too low."
            );
        }


        batteryLevel -= consumption;
        distanceDriven += distance;


        System.out.println("Driving for " + distance + " km");
        System.out.println("\tOdometer: " + distanceDriven + " km");
        System.out.println("\tConsumption: " + consumption + " kWh");
        System.out.println("\tBattery level: " + batteryLevel + " kWh");
    }
}
