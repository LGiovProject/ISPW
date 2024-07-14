package com.ispw.circularbook.controller.graficcontroller.cli;

import com.ispw.circularbook.controller.appcontroller.SearchBookController;
import com.ispw.circularbook.engineering.bean.BookBean;
import com.ispw.circularbook.engineering.bean.SearchBookBean;
import com.ispw.circularbook.engineering.enums.Arguments;
import com.ispw.circularbook.engineering.exception.CommandNotFoundException;
import com.ispw.circularbook.engineering.exception.NoBookFoundException;
import com.ispw.circularbook.engineering.exception.WrongArgumentInsertException;
import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.engineering.utils.CLIPrintBookSupport;
import com.ispw.circularbook.engineering.utils.MessageSupport;
import com.ispw.circularbook.view.cli.CLISearchBookView;

import java.util.List;

public class CLIResearchBookController {

    CLISearchBookView cliSearchBookView;
    SearchBookBean searchBookBean;
    CLIHomepageController cliHomepageController;

    private static final String INSERT_TITLE ="1";
    private static final String INSERT_ARGUMENT="2";
    private static final String INSERT_AUTHOR="3";
    private static final String SEARCH_BOOK ="4";
    private static final String CLEAN_PARAMETERS="5";
    private static final String SHOW_PARAMETERS="6";
    private static final String BACK="7";


    public CLIResearchBookController(CLIHomepageController cliHomepageController)
    {
        this.cliHomepageController=cliHomepageController;

        searchBookBean = new SearchBookBean("",Arguments.ANY,"","");

        cliSearchBookView = new CLISearchBookView(this);

    }

    public void start(){
        cliSearchBookView.start();
    }


    public void command(String i) throws CommandNotFoundException {
        switch (i)
        {
            case INSERT_TITLE:
                cliSearchBookView.insertTitle();
                break;
            case INSERT_ARGUMENT:
                cliSearchBookView.insertArgument();
                break;
            case INSERT_AUTHOR:
                cliSearchBookView.insertAuthor();
                break;
            case SEARCH_BOOK:
                searchBook();
                break;
            case CLEAN_PARAMETERS:
                cleanParameters();
                break;
            case SHOW_PARAMETERS:
                cliSearchBookView.searchParameters(searchBookBean);
                cliSearchBookView.start();
                break;
            case BACK:
                cliHomepageController.start();
                break;
            default:
                throw new CommandNotFoundException();
        }
    }


    public void insertTitle(String title)
    {
       searchBookBean.setTitle(title);
       start();
    }

    public void insertArgument(String argument) throws WrongArgumentInsertException {

        searchBookBean.setArgument(argument);
        start();
    }

    public void insertAuthor(String author)
    {
        searchBookBean.setAuthor(author);
        start();
    }

    private void searchBook()
    {
        SearchBookController searchBookController = new SearchBookController();
        String email = Session.getCurrentSession().getUser().isGuest()?"null":Session.getCurrentSession().getUser().getEmail();
        searchBookBean.setEmail(email);
        List<BookBean> bookBeanList;
        try {
            bookBeanList = searchBookController.searchAvailableBook(searchBookBean);
            CLIPrintBookSupport.showBookAvailable(bookBeanList);
            CLISearchedBookController cliSearchedBookController = new CLISearchedBookController(this, bookBeanList);
            cliSearchedBookController.start();
        } catch (NoBookFoundException e) {
            MessageSupport.cliExceptionSMessage(e.getMessage());
            start();
        }
    }

    private void cleanParameters()
    {
        searchBookBean.setArgument(Arguments.ANY);
        searchBookBean.setAuthor("");
        searchBookBean.setTitle("");
        start();
    }

}
