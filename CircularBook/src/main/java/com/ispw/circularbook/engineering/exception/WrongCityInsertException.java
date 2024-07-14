package com.ispw.circularbook.engineering.exception;

public class WrongCityInsertException extends Exception {
    public WrongCityInsertException(){super("la città inserita non è stata trovata");}
}
