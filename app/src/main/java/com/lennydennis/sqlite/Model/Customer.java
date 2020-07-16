package com.lennydennis.sqlite.Model;

public class Customer {
    private int id;
    private String customerName;
    private Integer customerAge;
    private Boolean isActive;

    public Customer() {
    }

    public Customer(int id, String customerName, Integer customerAge, Boolean isActive) {
        this.id = id;
        this.customerName = customerName;
        this.customerAge = customerAge;
        this.isActive = isActive;
    }

    @Override
    public String  toString() {
        return "Customer{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", customerAge='" + customerAge + '\'' +
                ", isActive=" + isActive +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getCustomerAge() {
        return customerAge;
    }

    public void setCustomerAge(Integer customerAge) {
        this.customerAge = customerAge;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
