package com.ispw.circularbook.view.cli;


import com.ispw.circularbook.controller.graficcontroller.cli.CLILoginController;
import com.ispw.circularbook.engineering.exception.CommandNotFoundException;
import com.ispw.circularbook.engineering.exception.WrongEmailFormattException;
import com.ispw.circularbook.engineering.utils.CLIMessageSupport;
import com.ispw.circularbook.engineering.utils.MessageSupport;

import java.util.Scanner;

public class CLILoginView {


    private final Scanner scanner = new Scanner(System.in);

    private final CLILoginController cliLoginController;

    public CLILoginView(CLILoginController cliLoginController)
    {
        this.cliLoginController = cliLoginController;
    }

    public void start()
    {
        CLIMessageSupport.titleMessage("Login");
        CLIMessageSupport.simpleMessage("*Insert:");
        CLIMessageSupport.simpleMessage("1)For Login");
        CLIMessageSupport.simpleMessage("2)Sign in");
        CLIMessageSupport.simpleMessage("3)Guest Access");
        CLIMessageSupport.simpleMessage("4)Google Access");
        String command = scanner.nextLine();
        try {
            cliLoginController.command(command);
        } catch (CommandNotFoundException e) {
            MessageSupport.cliExceptionSMessage(e.getMessage());
            start();
        }
    }

    public void getEmail(){
        CLIMessageSupport.titleMessage("Insert Email");
        String email = scanner.nextLine();
        try {
            cliLoginController.setEmail(email);
        } catch (WrongEmailFormattException e) {
            MessageSupport.cliExceptionSMessage(e.getMessage());
            getEmail();

        }
    }

    public void getPassword(){
        CLIMessageSupport.titleMessage("Insert Password");
        String password = scanner.nextLine();
        cliLoginController.setPassword(password);
    }


}
