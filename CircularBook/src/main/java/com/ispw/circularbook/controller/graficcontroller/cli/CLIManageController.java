package com.ispw.circularbook.controller.graficcontroller.cli;

import com.ispw.circularbook.engineering.enums.Account;
import com.ispw.circularbook.engineering.state.cli.CLIManageBookShopLibraryState;
import com.ispw.circularbook.engineering.state.cli.CLIManageState;
import com.ispw.circularbook.engineering.state.cli.CLIManageUserLibraryState;

public class CLIManageController {

    private CLIManageState currentState;

    private final CLIHomepageController cliHomepageController;

    public CLIManageController(CLIHomepageController cliHomepageController){this.cliHomepageController=cliHomepageController;}

    public void setState(CLIManageState cliManageState){this.currentState = cliManageState;}

    public void startManage(Account type)
    {
        if(type==Account.USER)
        {
            this.setState(new CLIManageUserLibraryState(this));
        } else{
            this.setState(new CLIManageBookShopLibraryState(this));
        }
        start();
    }

    public void start()
    {
        currentState.start();
    }

    public void goBack()
    {
        cliHomepageController.start();
    }
}
