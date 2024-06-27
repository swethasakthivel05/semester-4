package com.example.description.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Description {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int plantId;
    private String plantName;
    private String plantLight;
    private String plantSoil;
    private String plantWater;
    private String tempHumi;

    public Description() {
    }

    public Description(int plantId, String plantName, String plantLight, String plantSoil, String plantWater,
            String tempHumi) {
        this.plantId = plantId;
        this.plantName = plantName;
        this.plantLight = plantLight;
        this.plantSoil = plantSoil;
        this.plantWater = plantWater;
        this.tempHumi = tempHumi;
    }

    public int getPlantId() {
        return plantId;
    }

    public void setPlantId(int plantId) {
        this.plantId = plantId;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public String getPlantLight() {
        return plantLight;
    }

    public void setPlantLight(String plantLight) {
        this.plantLight = plantLight;
    }

    public String getPlantSoil() {
        return plantSoil;
    }

    public void setPlantSoil(String plantSoil) {
        this.plantSoil = plantSoil;
    }

    public String getPlantWater() {
        return plantWater;
    }

    public void setPlantWater(String plantWater) {
        this.plantWater = plantWater;
    }

    public String getTempHumi() {
        return tempHumi;
    }

    public void setTempHumi(String tempHumi) {
        this.tempHumi = tempHumi;
    }

}
