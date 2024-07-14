package com.ispw.circularbook.controller.graficcontroller.cli;

import com.ispw.circularbook.controller.appcontroller.SignInController;
import com.ispw.circularbook.engineering.bean.SignInBean;
import com.ispw.circularbook.engineering.exception.*;
import com.ispw.circularbook.engineering.utils.MessageSupport;
import com.ispw.circularbook.view.cli.CLISignInBookShopView;

public class CLISignInBookShopController {

    private final CLISignInBookShopView cliSignInBookShopView;
    private final SignInBean signInBean;
    private final SignInController signInController;

    private static final String START_SIGN_IN="1";
    private static final String BACK_TO_SIGN_IN="2";


    public CLISignInBookShopController()
    {
        cliSignInBookShopView = new CLISignInBookShopView(this);
        signInBean= new SignInBean();
        signInController= new SignInController();
    }

    public void start()
    {
        cliSignInBookShopView.start();
    }


    public void command(String cmn) throws CommandNotFoundException {
        switch (cmn)
        {
            case START_SIGN_IN:
                startSignInBookShop();
                break;
            case BACK_TO_SIGN_IN:
                goBack();
                break;
            default:
                throw new CommandNotFoundException();
        }
    }

    public void startSignInBookShop(){

        cliSignInBookShopView.getEmail();
        cliSignInBookShopView.getPassword();
        cliSignInBookShopView.getBookShopName();
        cliSignInBookShopView.getPhoneNumber();
        cliSignInBookShopView.getAddress();
        this.endSignInL();
    }


    public void endSignInL(){
        signInController.signInL(signInBean);
        MessageSupport.cliSuccessMessage("Successful Registration");
        CLILoginController cliLoginController = new CLILoginController();
        cliLoginController.start();
    }

    public void setCitta(String city) throws WrongCityInsertException {

        checkInputBack(city);
        signInBean.setCitta(city);

    }

    public void setEmail(String email) throws EmailUsedException, WrongEmailFormattException {
        checkInputBack(email);
        signInController.checkMail(email);
        signInBean.setEmail(email);
    }

    public void setPassword(String password)  {

        signInBean.setPassword(password);
    }

    public void setName(String name)
    {
        checkInputBack(name);
        signInBean.setNameBookShop(name);
    }

    public void setPhoneNumber(String phoneNumber) throws WrongNPhoneFormatException {
        checkInputBack(phoneNumber);
        signInBean.setNTel(phoneNumber);
    }

    public void setAddress(String address)
    {
        checkInputBack(address);
        signInBean.setAddress(address);
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
