package com.ispw.circularbook.view.cli;

import com.ispw.circularbook.controller.graficcontroller.cli.CLISignInUserController;
import com.ispw.circularbook.engineering.exception.*;
import com.ispw.circularbook.engineering.utils.CLIMessageSupport;
import com.ispw.circularbook.engineering.utils.MessageSupport;

import java.util.Scanner;

public class CLISignInUserView {

    private final Scanner scanner = new Scanner(System.in);
    private final CLISignInUserController cliSignInUserController;

    public CLISignInUserView(CLISignInUserController cliSignInUserController)
    {
        this.cliSignInUserController=cliSignInUserController;
    }

    public void start(){
        CLIMessageSupport.titleMessage("Sign In as USER");
        CLIMessageSupport.simpleMessage("1)Start sign in");
        CLIMessageSupport.simpleMessage("2)Back to sign in");
        String command = scanner.nextLine();
        try {
            cliSignInUserController.command(command);
        } catch (CommandNotFoundException e) {
            MessageSupport.cliExceptionSMessage(e.getMessage());
            start();
        }
    }

    public void getEmail()
    {
        CLIMessageSupport.titleMessage("Insert email");
        CLIMessageSupport.campObligatoryMessage();
        CLIMessageSupport.backValueMessage();
        String email = scanner.nextLine();
        try {
            cliSignInUserController.setEmail(email);
        } catch (WrongEmailFormattException | EmailUsedException e) {
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
            cliSignInUserController.checkPassword(password,rePassword);
            cliSignInUserController.setPassword(password);
        } catch (NoMatchPasswordException e) {
            MessageSupport.cliExceptionSMessage(e.getMessage());
            getPassword();
        }
    }

    public void getCity()
    {
        CLIMessageSupport.titleMessage("Enter the city, regional capital, starting with a capital letter");
        CLIMessageSupport.campObligatoryMessage();
        CLIMessageSupport.backValueMessage();
        String city = scanner.nextLine();
        try {
            cliSignInUserController.setCity(city);
        } catch (WrongCityInsertException e) {
            MessageSupport.cliExceptionSMessage(e.getMessage());
            getCity();
        }
    }

    public void getName(){
        CLIMessageSupport.titleMessage("Insert name");
        CLIMessageSupport.backValueMessage();
        String name = scanner.nextLine();
        cliSignInUserController.setName(name);
    }

    public void getSurname(){
        CLIMessageSupport.titleMessage("Insert surname");
        CLIMessageSupport.backValueMessage();
        String surname = scanner.nextLine();
        cliSignInUserController.setSurname(surname);
    }

    public void getUsername()
    {
        CLIMessageSupport.titleMessage("Insert username");
        CLIMessageSupport.backValueMessage();
        String username = scanner.nextLine();
        cliSignInUserController.setUsername(username);
    }

}
