package com.epam.assessment.cars.logic;

import com.epam.assessment.cars.domain.ElectricModel;
import com.epam.assessment.cars.domain.Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ModelsCollection {
    private List<Model> models = new ArrayList<>();

    public void readFromFile(String filePath) {
        try(BufferedReader br  = new BufferedReader(new FileReader(filePath))){
            String line;

            while((line = br.readLine()) != null){
                Model model = ModelParser.parse(line);
                models.add(model);
            }
        }catch (IOException e){
            throw new RuntimeException(
                    "Error occurred while reading file: " + filePath
            );
        }
    }

    public Optional<Model> getModel(String manufacturer, String modelName) {
        return models.stream()
                .filter(m -> m.getManufacturer().equals(manufacturer)
                && m.getModelName().equals(modelName))
                .findFirst();
    }

    public List<ElectricModel> getElectricModelsByBatteryCapacity(int batteryCapacityLimit) {
        return models.stream()
                .filter(m -> m instanceof ElectricModel)
                .map(m -> (ElectricModel) m)
                .filter(m -> m.getBatteryCapacity() >= batteryCapacityLimit)
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Model> getAllSorted(){
            return models.stream()
                    .sorted()
                    .collect(Collectors.toList());
    }
}
