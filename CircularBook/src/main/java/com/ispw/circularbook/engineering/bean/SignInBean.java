package com.ispw.circularbook.engineering.bean;

import com.ispw.circularbook.engineering.enums.City;
import com.ispw.circularbook.engineering.exception.*;

import java.util.regex.Pattern;

public class SignInBean {

    private String email;
    private String username;
    private String password;
    private String name;
    private String surname;
    private City city;
    private String address;
    private String nameBookShop;
    private String phoneNumber;

    public SignInBean(){}

    public SignInBean(String email, String password, String nameBookShop, String address, City city, String phoneNumber) throws WrongEmailFormattException, WrongNPhoneFormatException {
        setEmail(email);
        this.password=password;
        this.city = city;
        this.address = address;
        this.nameBookShop = nameBookShop;
        setNTel(phoneNumber);
    }

    public SignInBean(String email, String username, String password, String name, String surname, City city) throws WrongEmailFormattException {
        setEmail(email);
        this.username=username;
        this.password=password;
        this.name = name;
        this.surname = surname;
        this.city = city;

    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws WrongEmailFormattException {
        String checkMail="[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}";
        if(!Pattern.compile(checkMail).matcher(email).matches())
            throw new WrongEmailFormattException(email);
        this.email=email;
    }

    public String getUsername(){ return username;}

    public void setUsername(String username){this.username=username;}

    public String getPassword() {
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCittaString() {
        return this.city.getNameCity();
    }

    public City getCittaCity()
    {
        return this.city;
    }

    public void setCity(City city){
            this.city =city;
    }

    public void setCitta(String city) throws WrongCityInsertException {
        for (City cityTemp : City.values())
        {
            if(cityTemp.getNameCity().equals(city))
                this.city = cityTemp;
        }
        if(this.city ==null)
            throw new WrongCityInsertException();

    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNameBookShop() {
        return nameBookShop;
    }

    public void setNameBookShop(String nameBookShop) {
        this.nameBookShop = nameBookShop;
    }

    public void setNTel(String nTel) throws WrongNPhoneFormatException {
        String checkNumber="\\d+";
        if(!Pattern.compile(checkNumber).matcher(nTel).matches())
            throw new WrongNPhoneFormatException();
        this.phoneNumber =nTel;
    }

    public String getPhoneNumber(){return phoneNumber;}



}
