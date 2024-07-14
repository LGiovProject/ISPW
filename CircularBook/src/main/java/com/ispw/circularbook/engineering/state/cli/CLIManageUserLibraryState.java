package com.ispw.circularbook.engineering.state.cli;

import com.ispw.circularbook.controller.appcontroller.SearchBookController;
import com.ispw.circularbook.controller.graficcontroller.cli.CLIManageController;
import com.ispw.circularbook.controller.graficcontroller.cli.CLIManageMyAvailableBookController;
import com.ispw.circularbook.engineering.bean.BookBean;
import com.ispw.circularbook.engineering.exception.CommandNotFoundException;
import com.ispw.circularbook.engineering.exception.NoBookLendedException;
import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.engineering.utils.CLIPrintBookSupport;
import com.ispw.circularbook.engineering.utils.MessageSupport;
import com.ispw.circularbook.view.cli.CLIManageUserLibraryView;

import java.util.List;

public class CLIManageUserLibraryState implements CLIManageState{

    CLIManageController context;
    CLIManageUserLibraryView cliManageUserLibraryView;
    String sessionEmail;

    private static final String MANAGE_AVAILABLE_BOOK ="1";
    private static final String SHOW_BOOK_TOOK ="2";
    private static final String SHOW_BOOK_GIVE ="3";
    private static final String BACK ="4";

    public CLIManageUserLibraryState(CLIManageController cliManageController)
    {
        context=cliManageController;
        cliManageUserLibraryView = new CLIManageUserLibraryView(this);
        sessionEmail = Session.getCurrentSession().getUser().getEmail();
    }

    @Override
    public void start() {
        cliManageUserLibraryView.start();
    }


    @Override
    public void command(String i) throws CommandNotFoundException {
        switch (i)
        {
            case MANAGE_AVAILABLE_BOOK:
                manageMyAvailableBook();
                break;
            case SHOW_BOOK_TOOK:
                showBookITook();
                break;
            case SHOW_BOOK_GIVE:
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

    public void showBookITook()
    {
        List<BookBean>  bookBeanList;
        SearchBookController searchBookController = new SearchBookController();
        try {
            bookBeanList= searchBookController.searchMyTakenBook(sessionEmail);
            CLIPrintBookSupport.showBookITaked(bookBeanList);
            context.start();
        } catch (NoBookLendedException e) {
            MessageSupport.cliExceptionSMessage(e.getMessage());
            context.start();
        }

    }

    @Override
    public void showBookIGive()
    {
        List<BookBean> bookBeanList;
        SearchBookController searchBookController = new SearchBookController();
        try {
            bookBeanList = searchBookController.searchMyGivenBook(sessionEmail);
            CLIPrintBookSupport.showBookGived(bookBeanList);
            context.start();
        } catch (NoBookLendedException e) {
            MessageSupport.cliExceptionSMessage(e.getMessage());
            context.start();
        }

    }

}
