package com.ispw.circularbook.view.cli;


import com.ispw.circularbook.controller.graficcontroller.cli.CLISignInController;
import com.ispw.circularbook.engineering.exception.CommandNotFoundException;
import com.ispw.circularbook.engineering.utils.CLIMessageSupport;
import com.ispw.circularbook.engineering.utils.MessageSupport;

import java.util.Scanner;

public class CLISignInView {

    private final Scanner scanner = new Scanner(System.in);
    private final CLISignInController cliSignInController;

    public CLISignInView(CLISignInController cliSignInController){
        this.cliSignInController = cliSignInController;
    }

    public void start()
    {
        CLIMessageSupport.titleMessage("Choose whether to register as a User or as a Book Shop");
        CLIMessageSupport.simpleMessage("1)as User");
        CLIMessageSupport.simpleMessage("2)as Book Shop");
        CLIMessageSupport.simpleMessage("3)back to login");
        String command = scanner.nextLine();
        try {
            cliSignInController.command(command);
        } catch (CommandNotFoundException e) {
            MessageSupport.cliExceptionSMessage(e.getMessage());
            start();
        }
    }


}
