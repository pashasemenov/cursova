package edu.pasha.cursova.model;

import org.springframework.data.annotation.Id;

import java.util.Objects;

public class Customers {

    @Id
    private String id;
    private String clientsName;
    private String passportData;
    private String  homeAddress;
    private String phone;

    public Customers() {
    }

    public Customers(String id, String clientsName, String passportData, String homeAddress, String phone) {
        this.id = id;
        this.clientsName = clientsName;
        this.passportData = passportData;
        this.homeAddress = homeAddress;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClientsName() {
        return clientsName;
    }

    public void setClientsName(String clientsName) {
        this.clientsName = clientsName;
    }

    public String getPassportData() {
        return passportData;
    }

    public void setPassportData(String passportData) {
        this.passportData = passportData;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customers customers = (Customers) o;
        return id == customers.id &&
                Objects.equals(clientsName, customers.clientsName) &&
                Objects.equals(passportData, customers.passportData) &&
                Objects.equals(homeAddress, customers.homeAddress) &&
                Objects.equals(phone, customers.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clientsName, passportData, homeAddress, phone);
    }

    @Override
    public String toString() {
        return "Customers{" +
                "id=" + id +
                ", clientsName='" + clientsName + '\'' +
                ", passportData=" + passportData +
                ", homeAddress='" + homeAddress + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
