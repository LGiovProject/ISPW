package com.ispw.circularbook.engineering.exception;

public class NoBookMoreAvailableException extends Exception{
    public NoBookMoreAvailableException(){super("The book is no more available");}
}
