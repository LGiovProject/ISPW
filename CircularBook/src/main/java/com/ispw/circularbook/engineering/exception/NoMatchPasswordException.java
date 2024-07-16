package com.ispw.circularbook.engineering.exception;

public class NoMatchPasswordException extends Exception{
    public NoMatchPasswordException(){
        super("The entered passwords do not match.");
    }
}
