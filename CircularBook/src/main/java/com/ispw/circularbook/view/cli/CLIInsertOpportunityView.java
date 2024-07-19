package com.ispw.circularbook.view.cli;

import com.ispw.circularbook.controller.graficcontroller.cli.CLIInsertOpportunityController;
import com.ispw.circularbook.engineering.exception.*;
import com.ispw.circularbook.engineering.utils.CLIMessageSupport;
import com.ispw.circularbook.engineering.utils.MessageSupport;

import java.util.Scanner;

public class CLIInsertOpportunityView {

    private final Scanner scanner = new Scanner(System.in);

    private final CLIInsertOpportunityController cliInsertOpportunityController;

    public CLIInsertOpportunityView(CLIInsertOpportunityController cliInsertOpportunityController)
    {
        this.cliInsertOpportunityController = cliInsertOpportunityController;
    }

    public void start()
    {
        CLIMessageSupport.titleMessage("Insert new Opportunity");
        CLIMessageSupport.simpleMessage("1)Start entering the data");
        CLIMessageSupport.simpleMessage("2)go back");
        String command = scanner.nextLine();
        try {
            cliInsertOpportunityController.command(command);
        } catch (CommandNotFoundException e) {
            MessageSupport.cliExceptionSMessage(e.getMessage());
            start();
        }
    }

    public void finish()
    {
        CLIMessageSupport.titleMessage("Insert new Opportunity");
        CLIMessageSupport.simpleMessage("1)Send data");
        CLIMessageSupport.simpleMessage("2)go back");
        String command = scanner.nextLine();
        try {
            cliInsertOpportunityController.finishCommand(command);
        } catch (CommandNotFoundException e) {
            MessageSupport.cliExceptionSMessage(e.getMessage());
            finish();
        }
    }

    public void insertTitle()
    {
        CLIMessageSupport.titleMessage("Insert Title:");
        CLIMessageSupport.campObligatoryMessage();
        CLIMessageSupport.backValueMessage();
        String title = scanner.nextLine();
        try {
            cliInsertOpportunityController.insertTitle(title);
        } catch (TitleCampRequiredException e) {
            MessageSupport.cliExceptionSMessage(e.getMessage());
            insertTitle();
        }
    }

    public void insertTypeOfOpportunity()
    {
        CLIMessageSupport.titleMessage("Insert type of opportunity 1 Promotion o 2 Event");
        CLIMessageSupport.backValueMessage();
        int typeOfOpportunity = Integer.parseInt(scanner.nextLine());
        try {
            cliInsertOpportunityController.insertTypeOfOpportunity(typeOfOpportunity);
        } catch (TypeOfOpportunityNotFound e) {
            MessageSupport.cliExceptionSMessage(e.getMessage());
            insertTypeOfOpportunity();
        }
    }

    public void insertDescription()
    {
        CLIMessageSupport.titleMessage("Insert Description");
        CLIMessageSupport.backValueMessage();
        String description = scanner.nextLine();
        cliInsertOpportunityController.insertDescription(description);
    }

    public void insertDateStart()
    {
        CLIMessageSupport.titleMessage("Insert date start");
        CLIMessageSupport.simpleMessage("Use the format yyyy-mm-dd");
        CLIMessageSupport.campObligatoryMessage();
        CLIMessageSupport.backValueMessage();
        String dateStart = scanner.nextLine();
        try {
            cliInsertOpportunityController.insertDateStart(dateStart);
        } catch (WrongDataFormatException | WrongDataInsertException e) {
            MessageSupport.cliExceptionSMessage(e.getMessage());
            insertDateStart();
        }
    }

    public void insertDateFinish()
    {
        CLIMessageSupport.titleMessage("Insert date finish");
        CLIMessageSupport.simpleMessage("use the format yyyy-mm-dd");
        CLIMessageSupport.campObligatoryMessage();
        CLIMessageSupport.backValueMessage();
        String dateFinish = scanner.nextLine();
        try {
            cliInsertOpportunityController.insertDateFinish(dateFinish);
        } catch (WrongDataInsertException | WrongDataFormatException e) {
            MessageSupport.cliExceptionSMessage(e.getMessage());
            insertDateFinish();
        }
    }


}
