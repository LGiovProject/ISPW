package com.ispw.circularbook.engineering.exception;

public class NoBookLendedException extends Exception{
    public NoBookLendedException(){super("Non ci sono libri in prestito");}
}
