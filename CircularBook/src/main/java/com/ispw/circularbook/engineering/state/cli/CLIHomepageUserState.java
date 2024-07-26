package com.ispw.circularbook.engineering.state.cli;

import com.ispw.circularbook.controller.graficcontroller.cli.*;
import com.ispw.circularbook.engineering.enums.Account;
import com.ispw.circularbook.engineering.exception.CommandNotFoundException;
import com.ispw.circularbook.view.cli.CLIHomepageUserView;

public class CLIHomepageUserState implements CLIHomepageState{

    private CLIHomepageController context;
    private final CLIHomepageUserView cliHomepageUserView;

    private static final String INSERT_BOOK ="1";
    private static final String SEARCH_BOOK="2";
    private static final String SEARCH_OPPORTUNITY ="3";
    private static final String MENAGE_LIBRARY ="4";
    private static final String SETTING="5";
    private static final String LOGOUT="6";


    public CLIHomepageUserState(CLIHomepageController context)
    {
        this.context= context;
        cliHomepageUserView = new CLIHomepageUserView(this);
    }

    @Override
    public void startHomepage(){

         cliHomepageUserView.start();
    }

    public void insertBook(){context.insertBook();}

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
        CLIManageController cliManageController = new CLIManageController(context);
        cliManageController.startManage(Account.USER);
    }

    @Override
    public void setting()
    {
        CLISettingUserController cliSettingUserController = new CLISettingUserController(context);
        cliSettingUserController.start();
    }
    @Override
    public void logOut() {
        context.logOut();
    }

    @Override
    public void command(String value) throws CommandNotFoundException{
        switch (value)
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
}
