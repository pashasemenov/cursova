package edu.pasha.cursova.model;

import java.util.Objects;

public class CarBodyType {
    private String id;
    private String type;
    private String producer;

    public CarBodyType() {
    }

    public CarBodyType(String id, String type, String producer) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarBodyType that = (CarBodyType) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(type, that.type) &&
                Objects.equals(producer, that.producer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, producer);
    }

    @Override
    public String toString() {
        return "CarBodyType{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", producer='" + producer + '\'' +
                '}';
    }
}
