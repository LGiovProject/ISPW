package com.ispw.circularbook.engineering.exception;

public class NoBookFoundException extends Exception{
    public NoBookFoundException()
    {
        super("Nessun libro con questi parametri");
    }
}
