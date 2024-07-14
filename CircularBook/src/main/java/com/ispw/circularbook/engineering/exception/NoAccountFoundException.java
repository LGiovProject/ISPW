package com.ispw.circularbook.engineering.exception;

public class NoAccountFoundException extends Exception{

    public NoAccountFoundException(){ super("Nessun account trovato con questa mail");}
}
