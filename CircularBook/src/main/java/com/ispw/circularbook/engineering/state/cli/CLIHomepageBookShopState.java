package com.ispw.circularbook.engineering.state.cli;

import com.ispw.circularbook.controller.graficcontroller.cli.*;
import com.ispw.circularbook.engineering.exception.CommandNotFoundException;
import com.ispw.circularbook.view.cli.CLIHomepageBookShopView;

public class CLIHomepageBookShopState implements CLIHomepageState{

    private CLIHomepageController context;
    private CLIHomepageBookShopView cliHomepageBookShopView;

    private static final String INSERT_BOOK ="1";
    private static final String INSERT_OPPORTUNITY ="2";
    private static final String MANAGE_LIBRARY ="3";
    private static final String SETTING="4";
    private static final String LOGOUT="5";


    public CLIHomepageBookShopState(CLIHomepageController context)
    {
        this.context=context;
        cliHomepageBookShopView = new CLIHomepageBookShopView(this);
    }

    @Override
    public void startHomepage() {

      cliHomepageBookShopView.start();

    }

    @Override
    public void command(String i) throws CommandNotFoundException {
        switch (i)
        {
            case INSERT_BOOK:
                this.insertBook();
                break;
            case INSERT_OPPORTUNITY:
                this.insertOpportunity();
                break;
            case MANAGE_LIBRARY:
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


    public void insertBook(){context.insertBook();}


    public void insertOpportunity()
    {
        CLIInsertOpportunityController cliInsertOpportunityController = new CLIInsertOpportunityController(context);
        cliInsertOpportunityController.start();
    }

    public void manageLibrary()
    {
        CLIManageController cliManageController = new CLIManageController(context);
        cliManageController.startManage(2);
    }

    @Override
    public void setting(){

        CLISettingBookShopController cliSettingBookShopController = new CLISettingBookShopController(context);
        cliSettingBookShopController.start();
    }

    @Override
    public void logOut() {
        context.logOut();
    }

}
