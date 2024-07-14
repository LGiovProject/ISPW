package com.ispw.circularbook.view.cli;

import com.ispw.circularbook.controller.graficcontroller.cli.CLIManageMyAvailableBookController;
import com.ispw.circularbook.engineering.exception.CommandNotFoundException;
import com.ispw.circularbook.engineering.utils.CLIMessageSupport;
import com.ispw.circularbook.engineering.utils.MessageSupport;

import java.util.Scanner;

public class CLIManageMyAvailableBookView {

    private final Scanner scanner = new Scanner(System.in);
    private final CLIManageMyAvailableBookController cliManageMyAvailableBookController;

    public CLIManageMyAvailableBookView(CLIManageMyAvailableBookController cliManageMyAvailableBookController)
    {
        this.cliManageMyAvailableBookController = cliManageMyAvailableBookController;
    }

    public void start()
    {
        CLIMessageSupport.titleMessage("Personal Book Available");
        CLIMessageSupport.simpleMessage("1)Modify book info");
        CLIMessageSupport.simpleMessage("2)Deleted book from list");
        CLIMessageSupport.simpleMessage("3)go back");
        String command = scanner.nextLine();
        try {
            cliManageMyAvailableBookController.command(command);
        } catch (CommandNotFoundException e) {
            MessageSupport.cliExceptionSMessage(e.getMessage());
            start();
        }
    }

    public void modifyBook()
    {
        CLIMessageSupport.titleMessage("Insert book id to modify");
        CLIMessageSupport.backValueMessage();
        int id = scanner.nextInt();
        cliManageMyAvailableBookController.modifyBookInfo(id);
    }

    public void deleteBook()
    {
        CLIMessageSupport.titleMessage("Insert book id to delete");
        CLIMessageSupport.backValueMessage();
        int id = scanner.nextInt();
        cliManageMyAvailableBookController.deleteBook(id);
    }


}
