package com.epam.assessment.cars.logic;

import com.epam.assessment.cars.domain.ElectricModel;
import com.epam.assessment.cars.domain.Model;
import com.epam.assessment.cars.domain.RegularModel;

public class ModelParser {
    public static Model parse(String line) {
        String[] parts = line.split(",");

        String type = parts[0];

        if(!type.equals("Regular") && !type.equals("Electric")){
            throw new IllegalArgumentException(
                    "Unknown type: " + type
            );
        }

        if(parts.length != 6){
            throw new IllegalArgumentException(
                    "Invalid number of parameters. Expected 6, received: " + parts.length
            );
        }


        String manufacturer = parts[1];
        String modelName = parts[2];
        int power = Integer.parseInt(parts[3]);

        switch(type) {
            case "Regular": {
                int engineDisplacement = Integer.parseInt(parts[4]);
                double fuelConsumption = Double.parseDouble(parts[5]);
                return new RegularModel(manufacturer, modelName, power, engineDisplacement, fuelConsumption);
            }

            case "Electric": {
                int batteryCapacity = Integer.parseInt(parts[4]);
                int energyConsumption = Integer.parseInt(parts[5]);
                return new ElectricModel(manufacturer, modelName, power, batteryCapacity, energyConsumption);
            }
            default:{
                throw new IllegalArgumentException(
                        "Unknown type: " + type
                );
            }

        }
    }
}
