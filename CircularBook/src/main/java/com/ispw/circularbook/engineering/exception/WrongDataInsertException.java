package com.ispw.circularbook.engineering.exception;

public class WrongDataInsertException extends Exception{
    public WrongDataInsertException(String string){super("La data inserita non può essere precedente a "+string);}
}
