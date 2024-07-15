package com.ispw.circularbook.controller.graficcontroller.cli;

import com.ispw.circularbook.controller.appcontroller.BookShopController;
import com.ispw.circularbook.controller.appcontroller.SearchBookController;
import com.ispw.circularbook.engineering.bean.CircularBookInfoBean;
import com.ispw.circularbook.engineering.bean.BookShopBean;
import com.ispw.circularbook.engineering.bean.UpdateUserInfoBean;
import com.ispw.circularbook.engineering.exception.CommandNotFoundException;
import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.engineering.utils.MessageSupport;
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
                cliSettingBookShopView.start();
                break;
            case SHOW_CIRCULAR_BOOK_USE:
                showCircularBookUse();
                cliSettingBookShopView.start();
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
        checkInputBack(view);
        bookShopBean.setAddress(view);
        cliSettingBookShopView.choseCamp();
    }

    public void getPhoneNumber(int phoneNumber)
    {
        checkInputBack(String.valueOf(phoneNumber));
        bookShopBean.setPhoneNumber(phoneNumber);
        cliSettingBookShopView.choseCamp();
    }

    public void getCity(String city)
    {
        checkInputBack(city);
        bookShopBean.setCity(city);
        cliSettingBookShopView.choseCamp();
    }

    public void applyChange()
    {
        BookShopController bookShopController = new BookShopController();
        UpdateUserInfoBean updateUserInfoBean = new UpdateUserInfoBean(bookShopBean.getEmail(), bookShopBean.getCity());
        updateUserInfoBean.setNameBookShop(bookShopBean.getBookShopName());
        updateUserInfoBean.setAddress(bookShopBean.getAddress());
        updateUserInfoBean.setNumberPhone(bookShopBean.getPhoneNumber());
        bookShopController.updateBookShop(updateUserInfoBean);
        MessageSupport.cliSuccessMessage("The changes have been applied");
        cliSettingBookShopView.start();
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




}
