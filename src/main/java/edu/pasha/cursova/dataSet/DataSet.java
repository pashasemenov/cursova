package edu.pasha.cursova.dataSet;

import edu.pasha.cursova.model.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Component
public class DataSet {
    private List<Customers> customers = new ArrayList<>(Arrays.asList(
            new Customers("1", "243", "23.03.2019",
                    "Шевченка 50", "0967015428"),
            new Customers("2", "243", "25.05.2017",
                    "Шевченка 50", "0967015428"),
            new Customers("3", "243", "11.07.2001",
                    "Шевченка 50", "0967015428")
    ));

    public List<Customers> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customers> customers) {
        this.customers = customers;
    }

    

    private List<Purchase> purchase = new ArrayList<>(Arrays.asList(
            new Purchase("1", "243", "43443","23.05.7","dfgdfd","wdcs"),
            new Purchase("4", "243", "43443","23.05.7","dfgdfd","wdcs")


    ));

    public List<Purchase> getPurchase() {
        return purchase;
    }

    public void setPurchase(List<Purchase> purchase) {
        this.purchase = purchase;
    }



    private List<TechnicalData> technicalData = new ArrayList<>(Arrays.asList(
            new TechnicalData("23", "123","dgsdcs","3","5","sdfeds",
                    "efdv","uygi")

    ));

    public List<TechnicalData> getTechnicalData() {
        return technicalData;
    }

    public void setTechnicalData(List<TechnicalData> technicalData) {
        this.technicalData = technicalData;
    }



    private List<Employees> employees = new ArrayList<>(Arrays.asList(
            new Employees("2","Semenov","Pavlo","Olex","dsc","123 b","123323")

    ));

    public List<Employees> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employees> employees) {
        this.employees = employees;
    }



    private List<Universal> universal = new ArrayList<>(Arrays.asList(
            new Universal("1","Skoda", "Superb Combi","Germany","2019")


    ));

    public List<Universal> getUniversal() {
        return universal;
    }

    public void setUniversal(List<Universal> universal) {
        this.universal = universal;
    }



    private List<Sedan> sedan = new ArrayList<>(Arrays.asList(
            new Sedan("1","Skoda", "Superb Combi","Germany","2019")


    ));

    public List<Sedan> getSedan() {
        return sedan;
    }

    public void setSedan(List<Sedan> sedan) {
        this.sedan = sedan;
    }


    private List<Crossover> crossover = new ArrayList<>(Arrays.asList(
            new Crossover("1","Nissan", "Qashqai","Japan","2020")


    ));

    public List<Crossover> getCrossover() {
        return crossover;
    }

    public void setCrossover(List<Crossover> crossover) {
        this.crossover = crossover;
    }


    private List<Coupe> coupe = new ArrayList<>(Arrays.asList(
            new Coupe("1","Ford", "Mustang","America","2020")


    ));

    public List<Coupe> getCoupe() {
        return coupe;
    }

    public void setCoupe(List<Coupe> coupe) {
        this.coupe = coupe;
    }


    private List<Cabriolet> cabriolet = new ArrayList<>(Arrays.asList(
            new Cabriolet("1","Ford", "Mustang","America","2020"),
            new Cabriolet("2","dfxbds", "fdsv","sdfv","1919")


    ));

    public List<Cabriolet> getCabriolet() {
        return cabriolet;
    }

    public void setCabriolet(List<Cabriolet> cabriolet) {
        this.cabriolet = cabriolet;
    }

    private List<CarBodyType> carBodyType = new ArrayList<>(Arrays.asList(
            new CarBodyType()
    ));

    public List<CarBodyType> getCarBodyType() {
        return carBodyType;
    }

    public void setCarBodyType(List<CarBodyType> carBodyType) {
        this.carBodyType = carBodyType;
    }
}

