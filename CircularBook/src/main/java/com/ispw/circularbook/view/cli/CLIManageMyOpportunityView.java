package com.ispw.circularbook.view.cli;

import com.ispw.circularbook.controller.graficcontroller.cli.CLIManageMyOpportunityController;
import com.ispw.circularbook.engineering.exception.CommandNotFoundException;
import com.ispw.circularbook.engineering.utils.CLIMessageSupport;
import com.ispw.circularbook.engineering.utils.MessageSupport;

import java.util.Scanner;

public class CLIManageMyOpportunityView {

    private final Scanner scanner = new Scanner(System.in);
    private final CLIManageMyOpportunityController cliManageMyOpportunityController;

    public CLIManageMyOpportunityView(CLIManageMyOpportunityController cliManageMyOpportunityController){
        this.cliManageMyOpportunityController = cliManageMyOpportunityController;
    }
    public void start()
    {
        CLIMessageSupport.titleMessage("Opportunity Insert");
        CLIMessageSupport.simpleMessage("1)Modify Opportunity");
        CLIMessageSupport.simpleMessage("2)Delete Opportunity");
        CLIMessageSupport.simpleMessage("3)go back");
        String command = scanner.nextLine();
        try {
            cliManageMyOpportunityController.command(command);
        } catch (CommandNotFoundException e) {
            MessageSupport.cliExceptionSMessage(e.getMessage());
            start();
        }
    }

    public void modifyOpportunity()
    {
        CLIMessageSupport.titleMessage("Insert Opportunity id to modify");
        CLIMessageSupport.backValueMessage();
        int id = Integer.parseInt(scanner.nextLine());
        cliManageMyOpportunityController.modifyOpportunity(id);
    }

    public void deleteOpportunity()
    {
        CLIMessageSupport.titleMessage("Insert Opportunity id to delete");
        CLIMessageSupport.campObligatoryMessage();
        int id = Integer.parseInt(scanner.nextLine());
        cliManageMyOpportunityController.deleteOpportunity(id);
    }
}
