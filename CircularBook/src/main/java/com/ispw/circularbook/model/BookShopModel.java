package com.ispw.circularbook.model;

public class BookShopModel extends GenericAccountModel{

    private int phoneNumber;
    private String address;


    public BookShopModel(){}

    public BookShopModel(String email)
    {
        super(email);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getPhoneNumberString(){ return String.valueOf(phoneNumber);}

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPhoneNumber(String telNumber){this.phoneNumber = Integer.parseInt(telNumber);}


}
