package com.ispw.circularbook.engineering.exception;

public class NoAccountFoundException extends Exception{

    public NoAccountFoundException(){ super("No account found with this email");}
}
