package edu.pasha.cursova.forms;

public class PurchaseForm {
    private String id;
    private String productCode;
    private String clientCode;
    private String date;
    private String delivery;
    private String typeOfPayment;

    public PurchaseForm() {
    }

    public PurchaseForm(String id, String productCode, String clientCode, String date, String delivery, String typeOfPayment) {
        this.id = id;
        this.productCode = productCode;
        this.clientCode = clientCode;
        this.date = date;
        this.delivery = delivery;
        this.typeOfPayment = typeOfPayment;
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

    public String getClientCode() {
        return clientCode;
    }

    public void setClientCode(String clientCode) {
        this.clientCode = clientCode;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public String getTypeOfPayment() {
        return typeOfPayment;
    }

    public void setTypeOfPayment(String typeOfPayment) {
        this.typeOfPayment = typeOfPayment;
    }

    @Override
    public String toString() {
        return "PurchaseForm{" +
                "id='" + id + '\'' +
                ", productCode='" + productCode + '\'' +
                ", clientCode='" + clientCode + '\'' +
                ", date='" + date + '\'' +
                ", delivery='" + delivery + '\'' +
                ", typeOfPayment='" + typeOfPayment + '\'' +
                '}';
    }
}
