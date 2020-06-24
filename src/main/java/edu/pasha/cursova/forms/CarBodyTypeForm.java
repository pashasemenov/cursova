package edu.pasha.cursova.forms;

public class CarBodyTypeForm {
    private String id;
    private String type;
    private String producer;

    public CarBodyTypeForm() {
    }

    public CarBodyTypeForm(String id, String type, String producer) {
        this.id = id;
        this.type = type;
        this.producer = producer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    @Override
    public String toString() {
        return "CarBodyTypeForm{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", producer='" + producer + '\'' +
                '}';
    }
}
