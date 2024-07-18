package com.ispw.circularbook.controller.graficcontroller.cli;

import com.ispw.circularbook.controller.appcontroller.InsertBookController;
import com.ispw.circularbook.controller.appcontroller.SearchBookController;
import com.ispw.circularbook.engineering.bean.BookBean;
import com.ispw.circularbook.engineering.exception.CommandNotFoundException;
import com.ispw.circularbook.engineering.exception.NoBookRegisteredException;
import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.engineering.utils.CLIPrintBookSupport;
import com.ispw.circularbook.engineering.utils.MessageSupport;
import com.ispw.circularbook.view.cli.CLIManageMyAvailableBookView;

import java.util.List;

public class CLIManageMyAvailableBookController {

    private final String sessionEmail;

    private final CLIManageController cliManageController;
    private final CLIManageMyAvailableBookView cliManageMyAvailableBookView;
    private final SearchBookController searchBookController;
    private List<BookBean> bookBeanList;


    private static final String MODIFY_BOOK_INFO="1";
    private static final String DELETE_BOOK="2";
    private static final String BACK="3";


    public CLIManageMyAvailableBookController(CLIManageController cliManageController)
    {
        cliManageMyAvailableBookView = new CLIManageMyAvailableBookView(this);
        this.cliManageController=cliManageController;
        searchBookController = new SearchBookController();
        sessionEmail=getSessionEmail();
    }

    public void startManage() {
        try {
            bookBeanList = searchBookController.searchMyAvailableBook(sessionEmail);
            CLIPrintBookSupport.showMyBookAvailable(bookBeanList);
            cliManageMyAvailableBookView.start();
        } catch (NoBookRegisteredException e) {
            MessageSupport.cliExceptionSMessage(e.getMessage());
            cliManageController.start();
        }

    }

    public void command(String i) throws CommandNotFoundException {
        switch (i)
        {
            case MODIFY_BOOK_INFO:
                cliManageMyAvailableBookView.modifyBook();
                break;
            case DELETE_BOOK:
                cliManageMyAvailableBookView.deleteBook();
                cliManageController.start();
                break;
            case BACK:
                cliManageController.start();
                break;
            default:
                throw new CommandNotFoundException();
        }
    }



    public void modifyBookInfo(int id)
    {
        checkInput(id);
        CLIModifyMyAvailableBookController cliModifyMyAvailableBookController = new CLIModifyMyAvailableBookController(this,bookBeanList);
        cliModifyMyAvailableBookController.start(id);
    }

    public void deleteBook(int id)
    {
        checkInput(id);
        InsertBookController insertBookController = new InsertBookController();
        insertBookController.removeBook(id);

    }

    private String getSessionEmail()
    {
        return Session.getCurrentSession().getUser()==null?Session.getCurrentSession().getBookShop().getEmail():Session.getCurrentSession().getUser().getEmail();
    }


    private void checkInput(int command)
    {
        if (command == -1)
            cliManageController.start();

    }

}
