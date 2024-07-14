package com.ispw.circularbook.controller.graficcontroller.cli;

import com.ispw.circularbook.engineering.exception.CommandNotFoundException;
import com.ispw.circularbook.view.cli.CLISignInView;


public class CLISignInController {

    private final CLISignInView cliSignInView;

    private static final String SIGN_IN_USER ="1";
    private static final String SIGN_IN_BOOKSHOP="2";
    private static final String BACK="3";


    public CLISignInController()
    {
        cliSignInView =new CLISignInView(this);
    }

    public void start()
    {
        cliSignInView.start();
    }

    public void command(String value) throws CommandNotFoundException {
        switch (value)
        {
            case SIGN_IN_USER:
                this.startSignInUser();
                break;
            case SIGN_IN_BOOKSHOP:
                this.startSignInBookShop();
                break;
            case BACK:
                this.goLogin();
                break;
            default:
                throw new CommandNotFoundException();
        }
    }


    public void goLogin()
    {
        CLILoginController cliLoginController = new CLILoginController();
        cliLoginController.start();
    }

    public void startSignInUser()
    {
        CLISignInUserController cliSignInUserController = new CLISignInUserController();
        cliSignInUserController.start();
    }

    public void startSignInBookShop()
    {
       CLISignInBookShopController cliSignInBookShopController = new CLISignInBookShopController();
       cliSignInBookShopController.start();
    }

}
