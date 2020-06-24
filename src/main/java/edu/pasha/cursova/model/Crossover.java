package edu.pasha.cursova.model;

import java.util.Objects;

public class Crossover {
    private String id;
    private String model;
    private String brand;
    private String producingCountry;
    private String graduationYear;

    public Crossover() {
    }

    public Crossover(String id, String model, String brand, String producingCountry, String graduationYear) {
        this.id = id;
        this.model = model;
        this.brand = brand;
        this.producingCountry = producingCountry;
        this.graduationYear = graduationYear;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getProducingCountry() {
        return producingCountry;
    }

    public void setProducingCountry(String producingCountry) {
        this.producingCountry = producingCountry;
    }

    public String getGraduationYear() {
        return graduationYear;
    }

    public void setGraduationYear(String graduationYear) {
        this.graduationYear = graduationYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Crossover crossover = (Crossover) o;
        return Objects.equals(id, crossover.id) &&
                Objects.equals(model, crossover.model) &&
                Objects.equals(brand, crossover.brand) &&
                Objects.equals(producingCountry, crossover.producingCountry) &&
                Objects.equals(graduationYear, crossover.graduationYear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, brand, producingCountry, graduationYear);
    }

    @Override
    public String toString() {
        return "Crossover{" +
                "id='" + id + '\'' +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", producingCountry='" + producingCountry + '\'' +
                ", graduationYear='" + graduationYear + '\'' +
                '}';
    }
}
