package com.ispw.circularbook.engineering.exception;

public class WrongDataInsertException extends Exception{
    public WrongDataInsertException(String string){super("The entered date cannot be earlier than "+string);}
}
