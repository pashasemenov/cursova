package edu.pasha.cursova.model;

import java.util.Objects;

public class Employees {
    private String id;
    private String surname;
    private String name;
    private String patronymic;
    private String position;
    private String address;
    private String phone;

    public Employees() {
    }

    public Employees(String id, String surname, String name, String patronymic, String position, String address, String phone) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.position = position;
        this.address = address;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
        Employees employees = (Employees) o;
        return Objects.equals(id, employees.id) &&
                Objects.equals(surname, employees.surname) &&
                Objects.equals(name, employees.name) &&
                Objects.equals(patronymic, employees.patronymic) &&
                Objects.equals(position, employees.position) &&
                Objects.equals(address, employees.address) &&
                Objects.equals(phone, employees.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, surname, name, patronymic, position, address, phone);
    }

    @Override
    public String toString() {
        return "Employees{" +
                "id='" + id + '\'' +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", position='" + position + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
