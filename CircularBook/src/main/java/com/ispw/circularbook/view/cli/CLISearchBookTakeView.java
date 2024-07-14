package com.ispw.circularbook.view.cli;

import com.ispw.circularbook.controller.graficcontroller.cli.CLISearchedBookController;
import com.ispw.circularbook.engineering.exception.CommandNotFoundException;
import com.ispw.circularbook.engineering.exception.NoBookFoundException;
import com.ispw.circularbook.engineering.exception.NoBookMoreAvailableException;
import com.ispw.circularbook.engineering.utils.CLIMessageSupport;
import com.ispw.circularbook.engineering.utils.MessageSupport;

import java.util.Scanner;

public class CLISearchBookTakeView {

    private final CLISearchedBookController cliSearchedBookController;
    private final Scanner scanner = new Scanner(System.in);

    public CLISearchBookTakeView(CLISearchedBookController cliSearchedBookController){
        this.cliSearchedBookController = cliSearchedBookController;
    }

    public void start()
    {
        CLIMessageSupport.titleMessage("Check the books above");
        CLIMessageSupport.simpleMessage("1)Enter the id of the book you take ");
        CLIMessageSupport.simpleMessage("2)Back to Research");
        String command = scanner.nextLine();
        try {
            cliSearchedBookController.command(command);
        } catch (CommandNotFoundException e) {
            MessageSupport.cliExceptionSMessage(e.getMessage());
            start();
        }
    }

    public void getIdBook()
    {
        CLIMessageSupport.titleMessage("Insert book id");
        CLIMessageSupport.backValueMessage();
        int id = scanner.nextInt();
        try {
            cliSearchedBookController.takeBook(id);
        } catch (NoBookMoreAvailableException | NoBookFoundException e) {
            MessageSupport.cliExceptionSMessage(e.getMessage());
            getIdBook();
        }
    }
}
