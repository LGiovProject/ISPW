package com.ispw.circularbook.model;

import com.ispw.circularbook.engineering.enums.City;

public abstract class GenericAccountModel {

    private String email;
    private String accountName;
    private City city;

    protected GenericAccountModel(){}

    protected GenericAccountModel(String email)
    {
        this.email=email;
    }


    protected GenericAccountModel(String accountName, String email) {
        this.accountName = accountName;
        this.email = email;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getCityString() {
        return this.city.getNameCity();
    }

    public void setCity(String city) {
        for (City city1 : City.values()) {
            if (city1.getNameCity().equals(city)) {
                this.city = city1;
            }
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

}
