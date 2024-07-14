package com.ispw.circularbook.controller.graficcontroller.cli;

import com.ispw.circularbook.controller.appcontroller.SignInController;
import com.ispw.circularbook.engineering.bean.SignInBean;
import com.ispw.circularbook.engineering.exception.*;
import com.ispw.circularbook.view.cli.CLISignInUserView;

public class CLISignInUserController {

    private final CLISignInUserView cliSignInUserView;
    private final SignInBean signInBean;
    private final SignInController signInController;

    private static final String START_SIGN_IN="1";
    private static final String BACK_TO_SIGN_IN="2";
    
    public CLISignInUserController()
    {
        cliSignInUserView = new CLISignInUserView(this);
        signInBean= new SignInBean();
        signInController= new SignInController();
    }

    public void start()
    {
        cliSignInUserView.start();
    }

    public void command(String cmn) throws CommandNotFoundException {
        switch (cmn){
        case START_SIGN_IN:
            startSignInUser();
            break;
        case BACK_TO_SIGN_IN:
            goBack();
            break;
        default:
            throw new CommandNotFoundException();
        }
    }
    
    public void startSignInUser(){

        cliSignInUserView.getEmail();
        cliSignInUserView.getPassword();
        cliSignInUserView.getName();
        cliSignInUserView.getSurname();
        cliSignInUserView.getUsername();
        cliSignInUserView.getCity();
        this.endSignInU();

    }

    public void endSignInU(){
        signInController.signInU(signInBean);
        CLILoginController cliLoginController = new CLILoginController();
        cliLoginController.start();

    }

    public void setCity(String city) throws WrongCityInsertException {

        checkInputBack(city);
        signInBean.setCitta(city);
    }

    public void setEmail(String email) throws WrongEmailFormattException, EmailUsedException {
        checkInputBack(email);
        signInController.checkMail(email);
        signInBean.setEmail(email);

    }

    public void setPassword(String password)  {

        signInBean.setPassword(password);
    }

    public void setName(String name){

        checkInputBack(name);
        signInBean.setName(name);

    }

    public void setSurname(String surname){
        checkInputBack(surname);
        signInBean.setSurname(surname);
    }

    public void setUsername(String username){

        checkInputBack(username);
        signInBean.setUsername(username);
    }

    public void checkPassword(String password,String rePassword) throws NoMatchPasswordException {
        checkInputBack(password);
        checkInputBack(rePassword);
        if (!password.equals(rePassword))
            throw new NoMatchPasswordException();

    }

    private void checkInputBack(String value)
    {
        try {
            int command = Integer.parseInt(value);
            if (command == -1)
                goBack();
        } catch (NumberFormatException e) {
            // Non è un comando numerico, prosegui normalmente
        }

    }

    private void goBack()
    {
        CLISignInController cliSignInController = new CLISignInController();
        cliSignInController.start();
    }
}
