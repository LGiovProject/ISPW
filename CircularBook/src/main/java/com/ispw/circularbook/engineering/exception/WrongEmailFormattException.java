package com.ispw.circularbook.engineering.exception;

public class WrongEmailFormattException extends Exception {

        public WrongEmailFormattException(String email) {

        super("'"+email+"' formato email non valido,seguire il formato prova@prova.com/it");
    }

}
