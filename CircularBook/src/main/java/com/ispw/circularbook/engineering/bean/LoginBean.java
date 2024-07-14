package com.ispw.circularbook.engineering.bean;

import com.ispw.circularbook.engineering.exception.WrongEmailFormattException;

import java.util.regex.Pattern;

public class LoginBean {

    private String password;
    private String email;
    private int type;

    public LoginBean(String password, String email) throws WrongEmailFormattException {
        this.password=password;
        this.email=this.checkEmail(email);
    }

    public LoginBean(){}


    public String getEmail()
    {
        return this.email;
    }

    public void setEmail(String email) throws WrongEmailFormattException {this.email = checkEmail(email);}

    public String getPassword()
    {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public  void setType(int typeAccount){type=typeAccount;}

    public int getType(){return type;}

    private String checkEmail(String email) throws WrongEmailFormattException {
        String checkMail = "[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}";
        if (!Pattern.compile(checkMail).matcher(email).matches())
            throw new WrongEmailFormattException(email);
        return email;
    }
}
