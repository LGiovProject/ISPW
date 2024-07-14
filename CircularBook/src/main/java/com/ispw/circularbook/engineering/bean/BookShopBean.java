package com.ispw.circularbook.engineering.bean;

import com.ispw.circularbook.engineering.enums.City;

public class BookShopBean {

    private String email;

    private String password;
    private String bookShopName;
    private City city;
    private int phoneNumber;
    private String address;

    public BookShopBean() {

    }

    public BookShopBean(String email, String bookShopName, City citta, String address)
    {
        this.email=email;
        this.bookShopName = bookShopName;
        this.city=citta;
        this.address = address;
    }

    public BookShopBean(String email, String bookShopName, String citta, String address, int phoneNumber)
    {
        this.email=email;
        this.bookShopName = bookShopName;
        setCity(citta);
        this.address = address;
        this.phoneNumber = phoneNumber;
    }



    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getBookShopName() {
        return bookShopName;
    }

    public String getCityString() {
        return this.city.getNameCity();
    }

    public City getCity(){return this.city;}

    public String getAddress() {
        return address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBookShopName(String nome) {
        this.bookShopName = nome;
    }

    public void setCity(City city) {this.city = city;}

    public void setCity(String city)
    {
        for(City city1: City.values())
        {
            if(city1.getNameCity().equals(city))
            {
                this.city=city1;
            }
        }
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}

