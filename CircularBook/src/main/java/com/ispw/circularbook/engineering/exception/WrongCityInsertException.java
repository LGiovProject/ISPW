package com.ispw.circularbook.engineering.exception;

public class WrongCityInsertException extends Exception {
    public WrongCityInsertException(){super("The city entered was not found.");}
}
