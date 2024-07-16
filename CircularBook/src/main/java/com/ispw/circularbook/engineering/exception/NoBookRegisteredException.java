package com.ispw.circularbook.engineering.exception;

public class NoBookRegisteredException extends Exception{
    public NoBookRegisteredException(){super("There are no books registered for lend or gift");}
}
