package com.ispw.circularbook.engineering.bean;

import com.ispw.circularbook.engineering.enums.City;
import com.ispw.circularbook.engineering.exception.WrongCityInsertException;

public class UpdateUserInfoBean {

    private String email;
    private String nameUser;
    private String surname;
    private String username;
    private String nameBookShop;
    private String address;
    int numberPhone;

    private City city;


public UpdateUserInfoBean(){}

    public UpdateUserInfoBean(String email, City city) {
        this.email = email;
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNameBookShop() {
        return nameBookShop;
    }

    public void setNameBookShop(String nameBookShop) {
        this.nameBookShop = nameBookShop;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumberPhone() {
        return numberPhone;
    }

    public String getNumberPhoneString(){
        return String.valueOf(numberPhone);
    }

    public void setNumberPhone(int numberPhone) {
        this.numberPhone = numberPhone;
    }

    public void setNumberPhone(String numberPhone){
        this.numberPhone = Integer.parseInt(numberPhone);
    }

    public City getCity() {
        return city;
    }

    public void setCity(String city) throws WrongCityInsertException {
        for(City city1: City.values())
            if(city1.getNameCity().equals(city))
                this.city=city1;
        if(this.city==null)
            throw new WrongCityInsertException();

    }

    public String getCityString()
    {
        return city.getNameCity();
    }

    public void setCity(City city) {
        this.city = city;
    }
}
