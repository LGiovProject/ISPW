package com.ispw.circularbook.view.cli;

import com.ispw.circularbook.engineering.exception.CommandNotFoundException;
import com.ispw.circularbook.engineering.state.cli.CLIManageBookShopLibraryState;
import com.ispw.circularbook.engineering.utils.CLIMessageSupport;
import com.ispw.circularbook.engineering.utils.MessageSupport;

import java.util.Scanner;

public class CLIManageBookShopLibraryView {

    private final Scanner scanner = new Scanner(System.in);
    private final CLIManageBookShopLibraryState cliManageBookShopLibraryState;

    public CLIManageBookShopLibraryView(CLIManageBookShopLibraryState cliManageBookShopLibraryState){
        this.cliManageBookShopLibraryState = cliManageBookShopLibraryState;
    }

    public void start()
    {
        CLIMessageSupport.titleMessage("Manage Book Shop View");
        CLIMessageSupport.simpleMessage("1)For view Personal Book Available");
        CLIMessageSupport.simpleMessage("2)For view opportunity inserted");
        CLIMessageSupport.simpleMessage("3)For view Personal book took");
        CLIMessageSupport.simpleMessage("4)Back to homepage");
        String command = scanner.nextLine();
        try {
            cliManageBookShopLibraryState.command(command);
        } catch (CommandNotFoundException e) {
            MessageSupport.cliExceptionSMessage(e.getMessage());
            start();
        }

    }
}
