package com.ispw.circularbook.engineering.exception;

public class AccountRequiredException extends Exception{
    public AccountRequiredException(){
        super("account required!");
    }
}
