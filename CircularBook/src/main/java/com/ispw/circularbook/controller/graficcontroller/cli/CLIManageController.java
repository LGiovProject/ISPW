package com.ispw.circularbook.controller.graficcontroller.cli;

import com.ispw.circularbook.engineering.state.cli.CLIManageBookShopLibraryState;
import com.ispw.circularbook.engineering.state.cli.CLIManageState;
import com.ispw.circularbook.engineering.state.cli.CLIManageUserLibraryState;

public class CLIManageController {

    private CLIManageState currentState;

    private final CLIHomepageController cliHomepageController;

    public CLIManageController(CLIHomepageController cliHomepageController){this.cliHomepageController=cliHomepageController;}

    public void setState(CLIManageState cliManageState){this.currentState = cliManageState;}

    public void startManage(int type)
    {
        if(type==1)
        {
            this.setState(new CLIManageUserLibraryState(this));
        } else if (type==2) {
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
