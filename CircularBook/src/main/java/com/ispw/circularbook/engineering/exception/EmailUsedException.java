package com.ispw.circularbook.engineering.exception;

public class EmailUsedException extends Exception{
    public EmailUsedException(){super("The email is already registered");}
}
