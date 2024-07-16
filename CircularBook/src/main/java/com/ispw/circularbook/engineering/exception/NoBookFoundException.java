package com.ispw.circularbook.engineering.exception;

public class NoBookFoundException extends Exception{
    public NoBookFoundException()
    {
        super("No book found with these parameters");
    }
}
