package edu.pasha.cursova.model;

import java.util.Objects;

public class TechnicalData {
    private String id;
    private String productCode;
    private String bodyType;
    private String  numberOfDoors;
    private String numberOfSeats;
    private String engineType;
    private String locationOfTheEngine;
    private String  engineDisplacement;

    public TechnicalData() {
    }

    public TechnicalData(String id, String productCode, String bodyType, String numberOfDoors, String numberOfSeats, String engineType, String locationOfTheEngine, String engineDisplacement) {
        this.id = id;
        this.productCode = productCode;
        this.bodyType = bodyType;
        this.numberOfDoors = numberOfDoors;
        this.numberOfSeats = numberOfSeats;
        this.engineType = engineType;
        this.locationOfTheEngine = locationOfTheEngine;
        this.engineDisplacement = engineDisplacement;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public String getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(String numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public String getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(String numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public String getLocationOfTheEngine() {
        return locationOfTheEngine;
    }

    public void setLocationOfTheEngine(String locationOfTheEngine) {
        this.locationOfTheEngine = locationOfTheEngine;
    }

    public String getEngineDisplacement() {
        return engineDisplacement;
    }

    public void setEngineDisplacement(String engineDisplacement) {
        this.engineDisplacement = engineDisplacement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TechnicalData that = (TechnicalData) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(productCode, that.productCode) &&
                Objects.equals(bodyType, that.bodyType) &&
                Objects.equals(numberOfDoors, that.numberOfDoors) &&
                Objects.equals(numberOfSeats, that.numberOfSeats) &&
                Objects.equals(engineType, that.engineType) &&
                Objects.equals(locationOfTheEngine, that.locationOfTheEngine) &&
                Objects.equals(engineDisplacement, that.engineDisplacement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productCode, bodyType, numberOfDoors, numberOfSeats, engineType, locationOfTheEngine, engineDisplacement);
    }

    @Override
    public String toString() {
        return "TechnicalData{" +
                "id=" + id +
                ", productCode='" + productCode + '\'' +
                ", bodyType='" + bodyType + '\'' +
                ", numberOfDoors=" + numberOfDoors +
                ", numberOfSeats=" + numberOfSeats +
                ", engineType='" + engineType + '\'' +
                ", locationOfTheEngine='" + locationOfTheEngine + '\'' +
                ", engineDisplacement='" + engineDisplacement + '\'' +
                '}';
    }
}
