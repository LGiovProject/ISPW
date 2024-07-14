package com.ispw.circularbook.view.cli;

import com.ispw.circularbook.engineering.exception.CommandNotFoundException;
import com.ispw.circularbook.engineering.state.cli.CLIHomepageBookShopState;
import com.ispw.circularbook.engineering.utils.CLIMessageSupport;
import com.ispw.circularbook.engineering.utils.MessageSupport;

import java.util.Scanner;

public class CLIHomepageBookShopView {

    public CLIHomepageBookShopView(CLIHomepageBookShopState cliHomepageBookShopState)
    {
        this.cliHomepageBookShopState = cliHomepageBookShopState;
    }

    private final CLIHomepageBookShopState cliHomepageBookShopState;

    public void start()
    {
        CLIMessageSupport.titleMessage("Book Shop Homepage");
        CLIMessageSupport.simpleMessage("Insert:");
        CLIMessageSupport.simpleMessage("1)Insert new Book");
        CLIMessageSupport.simpleMessage("2)Insert Opportunity");
        CLIMessageSupport.simpleMessage("3)Library");
        CLIMessageSupport.simpleMessage("4)Setting");
        CLIMessageSupport.simpleMessage("5)Logout");
        Scanner scanner = new Scanner(System.in);
        String command= scanner.nextLine();
        try {
            cliHomepageBookShopState.command(command);
        } catch (CommandNotFoundException e) {
            MessageSupport.cliExceptionSMessage(e.getMessage());
            start();
        }
    }
}
