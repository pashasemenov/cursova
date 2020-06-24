package edu.pasha.cursova.forms;

public class CustomersForm {
    private String id;
    private String clientsName;
    private String passportData;
    private String  homeAddress;
    private String phone;

    public CustomersForm() {
    }

    public CustomersForm(String id, String clientsName, String passportData, String homeAddress, String phone) {
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
    public String toString() {
        return "CustomersForm{" +
                "id='" + id + '\'' +
                ", clientsName='" + clientsName + '\'' +
                ", passportData=" + passportData +
                ", homeAddress='" + homeAddress + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
