package com.ispw.circularbook.engineering.exception;

public class NoBookLendedException extends Exception{
    public NoBookLendedException(){super("There are no books on loan");}
}
