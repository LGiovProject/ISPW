package com.ispw.circularbook.view.cli;

import com.ispw.circularbook.controller.graficcontroller.cli.CLIModifyOpportunityController;
import com.ispw.circularbook.engineering.bean.RegistrationOpportunityBean;
import com.ispw.circularbook.engineering.exception.CommandNotFoundException;
import com.ispw.circularbook.engineering.exception.TitleCampRequiredException;
import com.ispw.circularbook.engineering.exception.WrongDataFormatException;
import com.ispw.circularbook.engineering.exception.WrongDataInsertException;
import com.ispw.circularbook.engineering.utils.CLIMessageSupport;
import com.ispw.circularbook.engineering.utils.MessageSupport;

import java.util.Scanner;

public class CLIModifyMyOpportunityView {

    private final Scanner scanner = new Scanner(System.in);
    private final CLIModifyOpportunityController cliModifyOpportunityController;

    public CLIModifyMyOpportunityView(CLIModifyOpportunityController cliModifyOpportunityController){
        this.cliModifyOpportunityController = cliModifyOpportunityController;
    }

    public void start()
    {
        CLIMessageSupport.titleMessage("Chose which data to modify");
        CLIMessageSupport.simpleMessage("1)Title");
        CLIMessageSupport.simpleMessage("2)Type");
        CLIMessageSupport.simpleMessage("3)Date start");
        CLIMessageSupport.simpleMessage("4)Date finish");
        CLIMessageSupport.simpleMessage("5)Comment");
        CLIMessageSupport.simpleMessage("6)Apply change");
        CLIMessageSupport.simpleMessage("7)Actually value");
        CLIMessageSupport.simpleMessage("8)go back");
        String command = scanner.nextLine();
        try {
            cliModifyOpportunityController.command(command);
        } catch (CommandNotFoundException e) {
            MessageSupport.cliExceptionSMessage(e.getMessage());
            start();
        }
    }

    public void actuallyValue(RegistrationOpportunityBean registrationOpportunityBean)
    {
        CLIMessageSupport.simpleMessage("Title :"+ registrationOpportunityBean.getTitle());
        CLIMessageSupport.simpleMessage("Type :"+ registrationOpportunityBean.getTypeOfOpportunityString());
        CLIMessageSupport.simpleMessage("Date start :"+ registrationOpportunityBean.getDateStart());
        CLIMessageSupport.simpleMessage("Date finish :"+ registrationOpportunityBean.getDateFinish());
        CLIMessageSupport.simpleMessage("Comment :"+ registrationOpportunityBean.getDescription());
    }

    public void insertTitle()
    {
        CLIMessageSupport.titleMessage("Insert Title:");
        CLIMessageSupport.backValueMessage();
        String title = scanner.nextLine();
        try {
            cliModifyOpportunityController.insertTitle(title);
        } catch (TitleCampRequiredException e) {
            MessageSupport.cliExceptionSMessage(e.getMessage());
            insertTitle();
        }
    }

    public void insertTypeOfOpportunity()
    {

        CLIMessageSupport.titleMessage("Insert type of opportunity 1 Promotion o 2 Event");
        CLIMessageSupport.backValueMessage();
        int type = Integer.parseInt(scanner.nextLine());
        cliModifyOpportunityController.insertType(type);
    }

    public void insertDescription()
    {
        CLIMessageSupport.titleMessage("Insert Description");
        CLIMessageSupport.backValueMessage();
        String description = scanner.nextLine();
        cliModifyOpportunityController.insertDescription(description);
    }

    public void insertDateStart()
    {
        CLIMessageSupport.titleMessage("Insert date start");
        CLIMessageSupport.simpleMessage("Use the format yyyy-mm-dd");
        CLIMessageSupport.backValueMessage();
        String dateStart = scanner.nextLine();
        try {
            cliModifyOpportunityController.insertDateStart(dateStart);
        } catch (WrongDataFormatException | WrongDataInsertException e) {
            MessageSupport.cliExceptionSMessage(e.getMessage());
            insertDateStart();
        }
    }

    public void insertDateFinish()
    {
        CLIMessageSupport.delimiterMessage();
        CLIMessageSupport.titleMessage("Insert date finish");
        CLIMessageSupport.simpleMessage("Use the format yyyy-mm-dd\n");
        CLIMessageSupport.backValueMessage();
        String dateFinish = scanner.nextLine();
        try {
            cliModifyOpportunityController.insertDateFinish(dateFinish);
        } catch (WrongDataInsertException e) {
            MessageSupport.cliExceptionSMessage(e.getMessage());
            insertDateStart();
        }
    }
}
