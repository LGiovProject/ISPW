package com.ispw.circularbook.controller.graficcontroller.cli;

import com.ispw.circularbook.controller.appcontroller.SearchBookController;
import com.ispw.circularbook.controller.appcontroller.UserController;
import com.ispw.circularbook.engineering.bean.CircularBookInfoBean;
import com.ispw.circularbook.engineering.bean.UpdateUserInfoBean;
import com.ispw.circularbook.engineering.bean.UserBean;
import com.ispw.circularbook.engineering.exception.CommandNotFoundException;
import com.ispw.circularbook.engineering.exception.WrongCityInsertException;
import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.engineering.utils.MessageSupport;
import com.ispw.circularbook.view.cli.CLISettingUserView;

public class CLISettingUserController {

    CLIHomepageController cliHomepageController;
    CLISettingUserView cliSettingUserView;

    UserBean userBean;

    private static final String MODIFY_PERSONAL_INFO ="1";
    private static final String SHOW_PERSONAL_INFO="2";
    private static final String SHOW_CIRCULAR_BOOK_USE="3";
    private static final String BACK ="4";

    private static final String NAME="1";
    private static final String SURNAME="2";
    private static final String USERNAME="3";
    private static final String CITY="4";
    private static final String CONFIRM_CHANGE="5";
    private static final String BACK_TO_SETTING="6";

    private UpdateUserInfoBean updateUserInfoBean;

    public CLISettingUserController(CLIHomepageController cliHomepageController){
        this.cliHomepageController= cliHomepageController;
        cliSettingUserView = new CLISettingUserView(this);

    }

    public void start()
    {
        userBean =Session.getCurrentSession().getUser();
        updateUserInfoBean= new UpdateUserInfoBean(userBean.getEmail(),userBean.getCity());
        cliSettingUserView.start();
    }


    public void command(String value) throws CommandNotFoundException {
        switch (value)
        {
            case MODIFY_PERSONAL_INFO:
                cliSettingUserView.choseCamp();
                break;
            case SHOW_PERSONAL_INFO:
                showPersonalInfo();
                break;
            case SHOW_CIRCULAR_BOOK_USE:
                showCircularBookUse();
                break;
            case BACK:
                goBack();
                break;
            default:
                throw new CommandNotFoundException();
        }
    }

    public void modifyPersonalInfo(String camp) throws CommandNotFoundException {
        switch (camp)
        {
            case NAME:
                cliSettingUserView.insertName();
                cliSettingUserView.choseCamp();
                break;
            case SURNAME:
                cliSettingUserView.insertSurname();
                cliSettingUserView.choseCamp();
                break;
            case USERNAME:
                cliSettingUserView.insertUsername();
                cliSettingUserView.choseCamp();
                break;
            case CITY:
                cliSettingUserView.insertCity();
                cliSettingUserView.choseCamp();
                break;
            case CONFIRM_CHANGE:
                applyChange();
                break;
            case BACK_TO_SETTING:
                cliSettingUserView.start();
                break;
            default:
                throw new CommandNotFoundException();
        }

    }

    public void getName(String name)
    {
        updateUserInfoBean.setNameUser(name);
        cliSettingUserView.choseCamp();
    }

    public void getSurname(String surname)
    {
        updateUserInfoBean.setSurname(surname);
        cliSettingUserView.choseCamp();
    }

    public void getUsername(String username)
    {
        updateUserInfoBean.setUsername(username);
        cliSettingUserView.choseCamp();
    }

    public void getCity(String city) throws WrongCityInsertException {
        checkInput(city);
        updateUserInfoBean.setCity(city);
        cliSettingUserView.choseCamp();
    }



    private void showPersonalInfo()
    {
        cliSettingUserView.showPersonalInfo(userBean);
        cliSettingUserView.start();
    }

    private void showCircularBookUse()
    {
        SearchBookController searchBookController = new SearchBookController();
        CircularBookInfoBean circularBookInfoBean = searchBookController.searchUserCircularBookInfo(userBean.getEmail());
        cliSettingUserView.showInfoCircularBook(circularBookInfoBean);
        cliSettingUserView.start();
    }

    public void applyChange()
    {
        UserController userController = new UserController();
        userController.updateUser(updateUserInfoBean);
        MessageSupport.cliSuccessMessage("The changes have been applied");
        cliSettingUserView.start();
    }

    private void goBack()
    {
        cliHomepageController.start();
    }


    private void checkInput(String value)
    {
        try {
            int command = Integer.parseInt(value);
            if (command == -1)
                cliSettingUserView.choseCamp();
        } catch (NumberFormatException e) {
            // Non è un comando numerico, prosegui normalmente
        }
    }



}
