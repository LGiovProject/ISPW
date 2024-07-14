package com.ispw.circularbook.engineering.state.cli;

import com.ispw.circularbook.controller.appcontroller.SearchBookController;
import com.ispw.circularbook.controller.graficcontroller.cli.*;
import com.ispw.circularbook.engineering.bean.BookBean;
import com.ispw.circularbook.engineering.exception.CommandNotFoundException;
import com.ispw.circularbook.engineering.exception.NoBookLendedException;
import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.engineering.utils.CLIPrintBookSupport;
import com.ispw.circularbook.engineering.utils.MessageSupport;

import com.ispw.circularbook.view.cli.CLIManageBookShopLibraryView;


import java.util.List;

public class CLIManageBookShopLibraryState implements CLIManageState{

    private CLIManageController context;

    private CLIManageBookShopLibraryView cliManageBookShopLibraryView;

    String sessionEmail;

    private static final String MANAGE_AVAILABLE_BOOK ="1";
    private static final String MANAGE_OPPORTUNITY ="2";
    private static final String MANAGE_BOOK_GIVE ="3";
    private static final String BACK ="4";

    public CLIManageBookShopLibraryState(CLIManageController cliManageController)
    {
        context=cliManageController;
        cliManageBookShopLibraryView = new CLIManageBookShopLibraryView(this);
        sessionEmail = Session.getCurrentSession().getBookShop().getEmail();
    }

    @Override
    public void start() {
        cliManageBookShopLibraryView.start();
    }

    @Override
    public void command(String i) throws CommandNotFoundException {
        switch (i)
        {
            case MANAGE_AVAILABLE_BOOK:
                manageMyAvailableBook();
                break;
            case MANAGE_OPPORTUNITY:
                manageMyOpportunity();
                break;
            case MANAGE_BOOK_GIVE:
                showBookIGive();
                break;
            case BACK:
                context.goBack();
                break;
            default:
                throw new CommandNotFoundException();

        }
    }

    @Override
    public void manageMyAvailableBook()
    {
        CLIManageMyAvailableBookController cliManageMyAvailableBookController= new CLIManageMyAvailableBookController(context);
        cliManageMyAvailableBookController.startManage();

    }

    public void manageMyOpportunity()
    {
        CLIManageMyOpportunityController cliManageMyOpportunityController = new CLIManageMyOpportunityController(context);
        cliManageMyOpportunityController.start();
    }

    @Override
    public void showBookIGive()
    {
        List<BookBean> bookBeanList;
        SearchBookController searchBookController = new SearchBookController();
        try {
            bookBeanList = searchBookController.searchMyGivenBook(sessionEmail);
            CLIPrintBookSupport.showBookAvailable(bookBeanList);
            context.start();
        } catch (NoBookLendedException e) {
            MessageSupport.cliExceptionSMessage(e.getMessage());
            context.start();
        }

    }

}
