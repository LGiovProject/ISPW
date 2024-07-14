package com.ispw.circularbook.view.cli;

import com.ispw.circularbook.engineering.exception.CommandNotFoundException;
import com.ispw.circularbook.engineering.state.cli.CLIHomepageState;
import com.ispw.circularbook.engineering.utils.CLIMessageSupport;
import com.ispw.circularbook.engineering.utils.MessageSupport;

import java.util.Scanner;

public class CLIHomepageUserView {



    public CLIHomepageUserView(CLIHomepageState cliHomepageState)
    {
        this.cliHomepageState = cliHomepageState;
    }

    private final CLIHomepageState cliHomepageState;

    public void start()
    {
        CLIMessageSupport.titleMessage("USER Homepage");
        CLIMessageSupport.simpleMessage("*Insert:");
        CLIMessageSupport.simpleMessage("1)Insert new Book");
        CLIMessageSupport.simpleMessage("2)Search Book");
        CLIMessageSupport.simpleMessage("3)Search Opportunity");
        CLIMessageSupport.simpleMessage("4)Library");
        CLIMessageSupport.simpleMessage("5)Setting");
        CLIMessageSupport.simpleMessage("6)Logout");
        Scanner scanner = new Scanner(System.in);
        String command= scanner.nextLine();
        try {
            cliHomepageState.command(command);
        } catch (CommandNotFoundException e) {
            MessageSupport.cliExceptionSMessage(e.getMessage());
            start();
        }
    }
}
