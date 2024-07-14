package com.ispw.circularbook.engineering.bean;

import com.ispw.circularbook.engineering.enums.City;

public class UserBean {

    private String email;
    private String username;
    private String password;
    private String name;
    private String surname;
    private City city;
    private boolean guest;

    public UserBean(){}

    public UserBean(String email, String username, String password, String name, String surname, String city) {
        this.email=email;
        this.username=username;
        this.password=password;
        this.name = name;
        this.surname = surname;
        setCity(city);
    }

    public UserBean(String email, String username, String name, String surname, String city) {
        this.email=email;
        this.username=username;
        this.name = name;
        this.surname = surname;
        setCity(city);
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() { return username;}
    public void setUsername(String username) { this.username = username;}

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCityString() {
        return this.city.getNameCity();
    }

    public City getCity(){return this.city;}

    public void setCity(City city) {
        this.city = city;
    }

    public void setCity(String city) {
        for(City city1: City.values())
        {
            if(city1.getNameCity().equals(city))
            {
                this.city=city1;
            }
        }
    }

    public boolean isGuest() {
        return guest;
    }

    public void setGuest(boolean guest) {
        this.guest = guest;
    }
}
