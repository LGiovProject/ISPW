package com.ispw.circularbook.engineering.exception;

public class WrongNPhoneFormatException extends Exception{
    public WrongNPhoneFormatException(){super("The phone number entered does not contain only numbers");}
}
