package com.ispw.circularbook.controller.graficcontroller.cli;

import com.ispw.circularbook.controller.appcontroller.InsertBookController;
import com.ispw.circularbook.engineering.bean.BookBean;
import com.ispw.circularbook.engineering.exception.CommandNotFoundException;
import com.ispw.circularbook.engineering.exception.NoBookFoundException;
import com.ispw.circularbook.engineering.utils.MessageSupport;
import com.ispw.circularbook.view.cli.CLIModifyMyAvailableBookView;
import java.util.List;

public class CLIModifyMyAvailableBookController {

    private final CLIModifyMyAvailableBookView cliModifyMyAvailableBookView;

    private final CLIManageMyAvailableBookController cliManageMyAvailableBookController;

    private BookBean bookBean;

    private final List<BookBean> bookBeanList;

    private static final String INSERT_TITLE ="1";
    private static final String INSERT_AUTHOR="2";
    private static final String INSERT_PUBLISHER="3";
    private static final String INSERT_ARGUMENT="4";
    private static final String INSERT_TYPE_OF_BOOK="5";
    private static final String INSERT_NUMBER_OF_PAGE="6";
    private static final String INSERT_COMMENT="7";
    private static final String SAVE_UPDATE="8";
    private static final String ACTUALLY_VALUE="9";
    private static final String BACK="10";



    public CLIModifyMyAvailableBookController(CLIManageMyAvailableBookController cliManageMyAvailableBookController,List<BookBean> bookBeanList)
    {
        cliModifyMyAvailableBookView = new CLIModifyMyAvailableBookView(this);
        this.cliManageMyAvailableBookController = cliManageMyAvailableBookController;
        this.bookBeanList=bookBeanList;
    }

    public void start(int id)
    {

        try {
            bookBean=getBookBean(id);
            cliModifyMyAvailableBookView.start();
            cliModifyMyAvailableBookView.actualyValue(bookBean);

        } catch (NoBookFoundException e) {
            MessageSupport.cliExceptionSMessage(e.getMessage());
            cliManageMyAvailableBookController.startManage();
        }
    }

    public void continueModify()
    {
        cliModifyMyAvailableBookView.start();
    }

    public void command(String i) throws CommandNotFoundException {
        switch (i) {
            case INSERT_TITLE:
                cliModifyMyAvailableBookView.insertTitle();
                break;
            case INSERT_AUTHOR:
                cliModifyMyAvailableBookView.insertAuthor();
                break;
            case INSERT_PUBLISHER:
                cliModifyMyAvailableBookView.insertPublisher();
                break;
            case INSERT_ARGUMENT:
                cliModifyMyAvailableBookView.insertArgument();
                break;
            case INSERT_TYPE_OF_BOOK:
                cliModifyMyAvailableBookView.insertTypeOfBook();
                break;
            case INSERT_NUMBER_OF_PAGE:
                cliModifyMyAvailableBookView.insertNPage();
                break;
            case INSERT_COMMENT:
                cliModifyMyAvailableBookView.insertComment();
                break;
            case SAVE_UPDATE:
                saveUpdate();
                break;
            case ACTUALLY_VALUE:
                cliModifyMyAvailableBookView.actualyValue(bookBean);
                continueModify();
                break;
            case BACK:
                goBack();
                break;
            default:
                throw new CommandNotFoundException();
        }
    }

    public void insertTitle(String title)
    {
        checkInput(title);
        bookBean.setTitle(title);
        continueModify();
    }

    public void insertArgument(String argument)
    {
        checkInput(argument);
        bookBean.setArgument(argument);
        continueModify();
    }

    public void setInsertPublisher(String publisher)
    {
        checkInput(publisher);
        bookBean.setPublisher(publisher);
        continueModify();
    }

    public void insertAuthor(String author)
    {

        checkInput(author);
        bookBean.setAuthor(author);
        continueModify();
    }

    public void insertTypeOfBook(int typeOfBook)
    {
        checkInput(String.valueOf(typeOfBook));
        bookBean.setTypeOfBook(typeOfBook);
        continueModify();
    }

    public void insertNPage(int nPage)
    {

        checkInput(String.valueOf(nPage));
        bookBean.setNPage(nPage);
        continueModify();
    }

    public void insertComment(String comment)
    {
        checkInput(comment);
        bookBean.setComment(comment);
        continueModify();
    }

    public void saveUpdate()
    {
        InsertBookController insertBookController = new InsertBookController();
        insertBookController.updateBook(bookBean);
        goBack();
    }

    private void checkInput(String i)
    {
        try {
            int command = Integer.parseInt(i);
            if (command < 0)
                cliModifyMyAvailableBookView.start();
        } catch (NumberFormatException e) {
            // Non è un comando numerico, prosegui normalmente
        }
    }



    private void goBack()
    {
        cliManageMyAvailableBookController.startManage();
    }

    private BookBean getBookBean(int id) throws NoBookFoundException {

            for(BookBean book: bookBeanList)
            {
                if(book.getId()==id) {
                    return book;
                }
            }
            throw new NoBookFoundException();
    }

}

