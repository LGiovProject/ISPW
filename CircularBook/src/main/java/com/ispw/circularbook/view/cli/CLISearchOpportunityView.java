package com.ispw.circularbook.view.cli;

import com.ispw.circularbook.controller.graficcontroller.cli.CLIResearchOpportunityController;
import com.ispw.circularbook.engineering.bean.SearchOpportunityBean;
import com.ispw.circularbook.engineering.exception.CommandNotFoundException;
import com.ispw.circularbook.engineering.utils.CLIMessageSupport;
import com.ispw.circularbook.engineering.utils.MessageSupport;

import java.util.Scanner;

public class CLISearchOpportunityView {

    private final CLIResearchOpportunityController cliResearchOpportunityController;
    private final Scanner scanner = new Scanner(System.in);


    public CLISearchOpportunityView(CLIResearchOpportunityController cliResearchOpportunityController) {
        this.cliResearchOpportunityController = cliResearchOpportunityController;
    }




    public void start()
    {
        CLIMessageSupport.titleMessage("Search Opportunity");
        CLIMessageSupport.simpleMessage("Please enter the search parameters.");
        CLIMessageSupport.simpleMessage("If you don't enter any parameters, the search will display all available results.");
        CLIMessageSupport.simpleMessage("1)Nome Book Shop");
        CLIMessageSupport.simpleMessage("2)Month to conduct the search");
        CLIMessageSupport.simpleMessage("3)Type of opportunity");
        CLIMessageSupport.simpleMessage("4)Start search");
        CLIMessageSupport.simpleMessage("5)Clean parameters");
        CLIMessageSupport.simpleMessage("6)Display search parameters");
        CLIMessageSupport.simpleMessage("7)go back");
        String command = scanner.nextLine();
        try {
            cliResearchOpportunityController.command(command);
        } catch (CommandNotFoundException e) {
            MessageSupport.cliExceptionSMessage(e.getMessage());
            start();
        }
    }

    public void searchParameters(SearchOpportunityBean searchOpportunityBean)
    {
        CLIMessageSupport.simpleMessage("Nome Book Shop"+ searchOpportunityBean.getNameLib());
        CLIMessageSupport.simpleMessage("Month to conduct the search: "+ searchOpportunityBean.getMonthString());
        CLIMessageSupport.simpleMessage("Type of opportunity: "+ searchOpportunityBean.getTypeOfOpportunity());
    }

    public void insertBookShopName()
    {
        CLIMessageSupport.delimiterMessage();
        CLIMessageSupport.titleMessage("Enter the name of a bookstore for which you are searching opportunity");
        CLIMessageSupport.simpleMessage("If you don't enter any name the search will be across all book shop");
        CLIMessageSupport.simpleMessage("Bookshop name: ");
        String name = scanner.nextLine();
        cliResearchOpportunityController.insertBookShopName(name);
    }

    public void insertMonth() {
        CLIMessageSupport.titleMessage("Enter the name of the month you want to search");
        CLIMessageSupport.simpleMessage("If you don't enter any month the search will be across all months");
        CLIMessageSupport.simpleMessage("Month name should be capitalized, e.g., \"January\"");
        CLIMessageSupport.simpleMessage("Month name: ");
        String month = scanner.nextLine();
        cliResearchOpportunityController.insertMonth(month);
    }

    public void insertTypologyInsertion()
    {
        CLIMessageSupport.titleMessage("Enter the type of insertion");
        CLIMessageSupport.simpleMessage("Options are \"Event\" or \"Promotion\"");
        CLIMessageSupport.simpleMessage("If you don't enter any type the search will be across all types");
        CLIMessageSupport.simpleMessage("Type: ");
        String type = scanner.nextLine();
        cliResearchOpportunityController.insertTypologyInsertion(type);
    }

}
