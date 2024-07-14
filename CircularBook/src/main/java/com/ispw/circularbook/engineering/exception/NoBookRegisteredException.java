package com.ispw.circularbook.engineering.exception;

public class NoBookRegisteredException extends Exception{
    public NoBookRegisteredException(){super("Non ci sono libri registrati in prestito o regalo");}
}
