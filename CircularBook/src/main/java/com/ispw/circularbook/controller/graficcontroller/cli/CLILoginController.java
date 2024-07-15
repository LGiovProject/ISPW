package com.ispw.circularbook.controller.graficcontroller.cli;

import com.ispw.circularbook.controller.appcontroller.LoginController;
import com.ispw.circularbook.engineering.bean.LoginBean;
import com.ispw.circularbook.engineering.exception.CommandNotFoundException;
import com.ispw.circularbook.engineering.exception.WrongEmailFormattException;
import com.ispw.circularbook.engineering.utils.MessageSupport;
import com.ispw.circularbook.view.cli.CLILoginView;

public class CLILoginController {

        private final CLILoginView cliLoginView;
        private LoginBean loginBean;
        private LoginController loginController;

        private static final String LOGIN  ="1";
        private static final String SIGN_IN ="2";
        private static final String LOGIN_GUEST ="3";
        private static final String LOGIN_GOOGLE="4";

        public CLILoginController()
        {
            cliLoginView = new CLILoginView(this);
            loginBean = new LoginBean();
            loginController = new LoginController();
        }


        public void start(){
                cliLoginView.start();

        }

        public void command(String value) throws CommandNotFoundException {
                switch (value)
                {
                        case LOGIN:
                                startLogin();
                                break;
                        case SIGN_IN:
                                startSignIn();
                                break;
                        case LOGIN_GUEST:
                                startLoginGuest();
                                break;
                        case LOGIN_GOOGLE:
                                MessageSupport.cliExceptionSMessage("Functionality not yet developed");
                                break;
                        default:
                                throw  new CommandNotFoundException();
                }
        }



        public void startLogin()
        {
             cliLoginView.getEmail();
             cliLoginView.getPassword();
             checkCredential(loginBean);
             endLogin(loginBean);
        }

        public void startLoginGuest()
        {
                loginBean=loginController.setGuestSession();
                CLIHomepageController cliHomepageController = new CLIHomepageController();
                cliHomepageController.homepageStart(loginBean);
        }

        public void startSignIn()
        {
            CLISignInController cliSingInController = new CLISignInController();
            cliSingInController.start();
        }

        private void endLogin(LoginBean loginBean)
        {
                loginController = new LoginController();
                CLIHomepageController cliHomepageController = new CLIHomepageController();

                if (loginBean.getType() == 1) {

                        loginController.setUserSession(loginBean);
                        cliHomepageController.homepageStart(loginBean);


                } else if (loginBean.getType() == 2) {

                        loginController.setBookShopSession(loginBean);
                        cliHomepageController.homepageStart(loginBean);

                } else {
                        MessageSupport.cliExceptionSMessage("Email or password are incorrect");
                        this.start();
                }
        }
        //Verifica se mail e password hanno corrispondenza nel database.
        private void checkCredential(LoginBean loginBean){
                loginController = new LoginController();
                loginController.checkLogin(loginBean);
        }



        public void setEmail(String email) throws WrongEmailFormattException {
            checkInput(email);
            loginBean.setEmail(email);
        }

        public void setPassword(String password)
        {
            checkInput(password);
            loginBean.setPassword(password);
        }

    private void checkInput(String value)
    {
        try {
            int command = Integer.parseInt(value);
            if (command == -1)
                cliLoginView.start();
        } catch (NumberFormatException e) {
            // Non è un comando numerico, prosegui normalmente
        }
    }
}
