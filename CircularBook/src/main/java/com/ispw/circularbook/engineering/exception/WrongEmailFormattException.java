package com.ispw.circularbook.engineering.exception;

public class WrongEmailFormattException extends Exception {

        public WrongEmailFormattException(String email) {

        super("'"+email+"' Invalid email format. Please follow the format example@domain.com/it.");
    }

}
