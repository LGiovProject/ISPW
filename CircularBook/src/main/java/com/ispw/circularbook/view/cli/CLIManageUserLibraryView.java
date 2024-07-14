package com.ispw.circularbook.view.cli;

import com.ispw.circularbook.engineering.exception.CommandNotFoundException;
import com.ispw.circularbook.engineering.state.cli.CLIManageUserLibraryState;
import com.ispw.circularbook.engineering.utils.CLIMessageSupport;
import com.ispw.circularbook.engineering.utils.MessageSupport;

import java.util.Scanner;

public class CLIManageUserLibraryView {

    private final Scanner scanner = new Scanner(System.in);
    private final CLIManageUserLibraryState cliManageUserLibraryState;

    public CLIManageUserLibraryView(CLIManageUserLibraryState cliManageUserLibraryState){
        this.cliManageUserLibraryState = cliManageUserLibraryState;
    }

    public void start()
    {
        CLIMessageSupport.titleMessage("Manage User View");
        CLIMessageSupport.simpleMessage("1)For view Personal Book Available");
        CLIMessageSupport.simpleMessage("2)For view Books took");
        CLIMessageSupport.simpleMessage("3)For view Personal book took");
        CLIMessageSupport.simpleMessage("4)Back to homepage");
        String command = scanner.nextLine();
        try {
            cliManageUserLibraryState.command(command);
        } catch (CommandNotFoundException e) {
            MessageSupport.cliExceptionSMessage(e.getMessage());
            start();
        }
    }





}
