package com.ispw.circularbook.engineering.state.cli;

import com.ispw.circularbook.controller.graficcontroller.cli.*;
import com.ispw.circularbook.engineering.exception.CommandNotFoundException;
import com.ispw.circularbook.engineering.utils.MessageSupport;
import com.ispw.circularbook.view.cli.CLIHomepageUserView;



public class CLIHomepageGuestState implements CLIHomepageState{

    private CLIHomepageController context;

    private CLIHomepageUserView cliHomepageUserView;


    private static final String INSERT_BOOK ="1";
    private static final String SEARCH_BOOK="2";
    private static final String SEARCH_OPPORTUNITY ="3";
    private static final String MENAGE_LIBRARY ="4";
    private static final String SETTING="5";
    private static final String LOGOUT="6";

    public CLIHomepageGuestState(CLIHomepageController context)
    {
        this.context= context;
        cliHomepageUserView = new CLIHomepageUserView(this);
    }

    @Override
    public void startHomepage(){

        cliHomepageUserView.start();
    }

    public void insertBook()
    {
        deniedMethod();
    }

    public void searchBook()
    {
        CLIResearchBookController cliResearchBookController = new CLIResearchBookController(context);
        cliResearchBookController.start();
    }

    public void searchOpportunity()
    {
        CLIResearchOpportunityController cliResearchOpportunityController = new CLIResearchOpportunityController(context);
        cliResearchOpportunityController.start();
    }

    public void manageLibrary()
    {
        deniedMethod();
    }

    @Override
    public void setting()
    {
        deniedMethod();
    }

    @Override
    public void logOut() {
        context.logOut();
    }

    @Override
    public void command(String i) throws CommandNotFoundException{
        switch (i)
        {
            case INSERT_BOOK:
                this.insertBook();
                break;
            case SEARCH_BOOK:
                this.searchBook();
                break;
            case SEARCH_OPPORTUNITY:
                this.searchOpportunity();
                break;
            case MENAGE_LIBRARY:
                this.manageLibrary();
                break;
            case SETTING:
                this.setting();
                break;
            case LOGOUT:
                this.logOut();
                break;
            default:
                throw new CommandNotFoundException();

        }
    }


    private void deniedMethod()
    {
        MessageSupport.cliDaniedAccesMessage();
        context.start();
    }
}
