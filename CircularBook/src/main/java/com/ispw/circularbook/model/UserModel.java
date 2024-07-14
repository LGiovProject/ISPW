package com.ispw.circularbook.model;

public class UserModel extends GenericAccountModel{

    private String name;
    private String surname;
    private boolean guest;

    public UserModel(){}

    public UserModel(String email) {
        super(email);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public boolean isGuest() {
        return guest;
    }

    public void setGuest(boolean guest) {
        this.guest = guest;
    }
}
