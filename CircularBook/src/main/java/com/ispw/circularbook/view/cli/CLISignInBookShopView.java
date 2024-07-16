package com.ispw.circularbook.view.cli;

import com.ispw.circularbook.controller.graficcontroller.cli.CLISignInBookShopController;
import com.ispw.circularbook.engineering.exception.*;
import com.ispw.circularbook.engineering.utils.CLIMessageSupport;
import com.ispw.circularbook.engineering.utils.MessageSupport;

import java.util.Scanner;

public class CLISignInBookShopView {

    private final Scanner scanner = new Scanner(System.in);
    private final CLISignInBookShopController cliSignInBookShopController;

    public CLISignInBookShopView(CLISignInBookShopController cliSignInBookShopController){
        this.cliSignInBookShopController =cliSignInBookShopController;
    }

    public void start()
    {
        CLIMessageSupport.titleMessage("Sign In as Book Shop");
        CLIMessageSupport.simpleMessage("1)Start sign in");
        CLIMessageSupport.simpleMessage("2)Back to sign in");
        String command = scanner.nextLine();
        try {
            cliSignInBookShopController.command(command);
        } catch (CommandNotFoundException e) {
            MessageSupport.cliExceptionSMessage(e.getMessage());
            start();
        }
    }

    public void getEmail()
    {
        CLIMessageSupport.titleMessage("Insert Title");
        CLIMessageSupport.campObligatoryMessage();
        CLIMessageSupport.backValueMessage();
        String email = scanner.nextLine();
        try {
            cliSignInBookShopController.setEmail(email);
        } catch (EmailUsedException | WrongEmailFormattException e) {
            MessageSupport.cliExceptionSMessage(e.getMessage());
            getEmail();
        }
    }

    public void getPassword() {
        CLIMessageSupport.titleMessage("Insert Password");
        CLIMessageSupport.campObligatoryMessage();
        CLIMessageSupport.backValueMessage();
        String password = scanner.nextLine();
        CLIMessageSupport.simpleMessage("re insert password");
        String rePassword = scanner.nextLine();
        try {
            cliSignInBookShopController.checkPassword(password,rePassword);
            cliSignInBookShopController.setPassword(password);
        } catch (NoMatchPasswordException e) {
            MessageSupport.cliExceptionSMessage(e.getMessage());
            getPassword();
        }
    }


    public void getCity()
    {
        CLIMessageSupport.titleMessage("Insert city");
        CLIMessageSupport.campObligatoryMessage();
        CLIMessageSupport.titleMessage("Enter the city, regional capital, starting with a capital letter");
        CLIMessageSupport.backValueMessage();
        String city = scanner.nextLine();
        try {
            cliSignInBookShopController.setCitta(city);
        } catch (WrongCityInsertException e) {
            MessageSupport.cliExceptionSMessage(e.getMessage());
            getCity();
        }
    }

    public void getBookShopName()
    {
        CLIMessageSupport.titleMessage("Insert Book Shop name");
        CLIMessageSupport.backValueMessage();
        String name =  scanner.nextLine();
        cliSignInBookShopController.setName(name);
    }

    public void getPhoneNumber()
    {
        CLIMessageSupport.titleMessage("Insert phone number");
        CLIMessageSupport.backValueMessage();
        String phoneNumber = scanner.nextLine();
        try {
            cliSignInBookShopController.setPhoneNumber(phoneNumber);
        } catch (WrongNPhoneFormatException e) {
            MessageSupport.cliExceptionSMessage(e.getMessage());
            getPhoneNumber();
        }
    }

    public void getAddress()
    {
        CLIMessageSupport.titleMessage("Insert address");
        CLIMessageSupport.backValueMessage();
        String address = scanner.nextLine();
        cliSignInBookShopController.setAddress(address);
    }

}
