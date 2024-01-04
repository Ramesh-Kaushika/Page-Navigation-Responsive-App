package com.example.mvcsinglepattern.tm;

public class CustomerTM {

    private String customerId;
    private String customerName;
    private int telephoneNo;
    private String address;

    public CustomerTM() {
    }

    public CustomerTM(String customerId, String customerName, int telephoneNo, String address) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.telephoneNo = telephoneNo;
        this.address = address;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getTelephoneNo() {
        return telephoneNo;
    }

    public void setTelephoneNo(int telephoneNo) {
        this.telephoneNo = telephoneNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
