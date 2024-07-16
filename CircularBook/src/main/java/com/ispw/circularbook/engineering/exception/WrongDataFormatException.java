package com.ispw.circularbook.engineering.exception;

public class WrongDataFormatException extends Exception{
    public WrongDataFormatException(){ super("The date was entered in the wrong format. It should be yyyy-mm-dd.");}
}
