package com.ispw.circularbook.engineering.exception;

public class WrongNPhoneFormatException extends Exception{
    public WrongNPhoneFormatException(){super("Il numero di telefono inserito non contiene solo numeri");}
}
