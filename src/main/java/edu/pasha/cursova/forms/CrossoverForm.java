package edu.pasha.cursova.forms;

public class CrossoverForm {
    private String id;
    private String model;
    private String brand;
    private String producingCountry;
    private String graduationYear;

    public CrossoverForm() {
    }

    public CrossoverForm(String id, String model, String brand, String producingCountry, String graduationYear) {
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
    public String toString() {
        return "CrossoverForm{" +
                "id='" + id + '\'' +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", producingCountry='" + producingCountry + '\'' +
                ", graduationYear='" + graduationYear + '\'' +
                '}';
    }
}
