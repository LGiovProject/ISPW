package com.ispw.circularbook.engineering.exception;

public class NoMatchPasswordException extends Exception{
    public NoMatchPasswordException(){
        super("le password inserite non corrispondono");
    }
}
