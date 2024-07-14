package com.ispw.circularbook.controller.graficcontroller.cli;

import com.ispw.circularbook.controller.appcontroller.SearchBookController;
import com.ispw.circularbook.controller.appcontroller.UserController;
import com.ispw.circularbook.engineering.bean.CircularBookInfoBean;
import com.ispw.circularbook.engineering.bean.BookShopBean;
import com.ispw.circularbook.engineering.bean.UpdateUserInfoBean;
import com.ispw.circularbook.engineering.exception.CommandNotFoundException;
import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.view.cli.CLISettingBookShopView;


public class CLISettingBookShopController {
    private BookShopBean bookShopBean;

    CLIHomepageController cliHomepageController;
    CLISettingBookShopView cliSettingBookShopView;

    private static final String MODIFY_PERSONAL_INFO ="1";
    private static final String SHOW_PERSONAL_INFO="2";
    private static final String SHOW_CIRCULAR_BOOK_USE="3";
    private static final String BACK ="4";

    private static final String  ADDRESS ="1";
    private static final String  PHONE_NUMBER="2";
    private static final String  CITY="3";
    private static final String  CONFIRM_CHANGE ="4";
    private static final String  BACK_TO_SETTING="5";

    public CLISettingBookShopController(CLIHomepageController cliHomepageController) {
        this.cliHomepageController = cliHomepageController;
        cliSettingBookShopView = new CLISettingBookShopView(this);
    }

    public void start()
    {
        bookShopBean = Session.getCurrentSession().getBookShop();
        cliSettingBookShopView.start();
    }

    public void command(String value) throws CommandNotFoundException {
        switch (value)
        {
            case MODIFY_PERSONAL_INFO:
                cliSettingBookShopView.choseCamp();
                break;
            case SHOW_PERSONAL_INFO:
                cliSettingBookShopView.showPersonalInfo(bookShopBean);
                break;
            case SHOW_CIRCULAR_BOOK_USE:
                showCircularBookUse();
                break;
            case BACK:
                this.goBack();
                break;
            default:
                throw new CommandNotFoundException();
        }
    }

    public void modifyPersonalInfo(String camp) throws CommandNotFoundException {
        switch (camp)
        {
            case ADDRESS:
                cliSettingBookShopView.insertView();
                break;
            case PHONE_NUMBER:
                cliSettingBookShopView.insertNPhone();
                break;
            case CITY:
                cliSettingBookShopView.insertCity();
                break;
            case CONFIRM_CHANGE:
                applyChange();
                break;
            case BACK_TO_SETTING:
                cliSettingBookShopView.start();
                break;
            default:
                throw  new CommandNotFoundException();

        }

    }

    public void getView(String view)
    {
        bookShopBean.setAddress(view);
    }

    public void getPhoneNumber(int phoneNumber)
    {
        bookShopBean.setPhoneNumber(phoneNumber);
    }

    public void getCity(String city)
    {
        bookShopBean.setCity(city);
    }

    public void applyChange()
    {
        UserController userController = new UserController();
        UpdateUserInfoBean updateUserInfoBean = new UpdateUserInfoBean(bookShopBean.getEmail(), bookShopBean.getCity());
        updateUserInfoBean.setNameBookShop(bookShopBean.getBookShopName());
        updateUserInfoBean.setAddress(bookShopBean.getAddress());
        updateUserInfoBean.setNumberPhone(bookShopBean.getPhoneNumber());
        userController.updateUser(updateUserInfoBean);
    }

    private void goBack()
    {
        cliHomepageController.start();
    }


    private void showCircularBookUse()
    {
        SearchBookController searchBookController = new SearchBookController();
        CircularBookInfoBean circularBookInfoBean = searchBookController.searchBookShopCircularBookInfo(bookShopBean.getEmail());
        cliSettingBookShopView.showInfoCircularBook(circularBookInfoBean);
    }




}
