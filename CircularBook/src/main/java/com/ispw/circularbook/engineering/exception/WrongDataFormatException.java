package com.ispw.circularbook.engineering.exception;

public class WrongDataFormatException extends Exception{
    public WrongDataFormatException(){ super("La data è stata inserita nel formato sbagliato deve essere yyyy-mm-dd");}
}
