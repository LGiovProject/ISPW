package com.ispw.circularbook.controller.graficcontroller.cli;

import com.ispw.circularbook.controller.appcontroller.InsertBookController;
import com.ispw.circularbook.engineering.bean.RegistrationBookBean;
import com.ispw.circularbook.engineering.exception.CommandNotFoundException;
import com.ispw.circularbook.engineering.exception.TitleCampRequiredException;
import com.ispw.circularbook.engineering.exception.WrongArgumentInsertException;
import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.view.cli.CLIInsertBookView;

public class CLIInsertBookController {

    private final CLIHomepageController cliHomepageController;
    private CLIInsertBookView cliInsertBookView;
    private RegistrationBookBean registrationBookBean;

    private static final String INSERT_DATA="1";
    private static final String BACK="2";
    private static final String REGISTRATION_DATA="1";


    public CLIInsertBookController(CLIHomepageController cliHomepageController)
    {
        this.cliHomepageController= cliHomepageController;
    }

    public void start()
    {
        cliInsertBookView = new CLIInsertBookView(this);
        cliInsertBookView.start();

    }

    public void command(String cmn) throws CommandNotFoundException {
        switch (cmn)
        {
            case INSERT_DATA:
                insertData();
                break;
            case BACK:
                cliHomepageController.start();
                break;
            default:
                throw new CommandNotFoundException();
        }
    }



    public void finishCommand(String i) throws CommandNotFoundException {
        switch (i)
        {
            case REGISTRATION_DATA:
                registrationData();
                start();
                break;
            case BACK:
                cliHomepageController.start();
                break;
            default:
                throw new CommandNotFoundException();
        }
    }



    public void insertData(){
        registrationBookBean = new RegistrationBookBean();
        cliInsertBookView.insertTitle();
        cliInsertBookView.insertPublisher();
        cliInsertBookView.insertArgument();
        cliInsertBookView.insertAuthor();
        cliInsertBookView.insertTypeOfBook();
        cliInsertBookView.insertNPage();
        cliInsertBookView.insertComment();
        cliInsertBookView.finish();
    }

    public void registrationData()
    {
        InsertBookController insertBookController= new InsertBookController();
        registrationBookBean.setEmail(getSessionEmail());
        registrationBookBean.setAUser(getSessionAccountType());
        insertBookController.insertBook(registrationBookBean);
    }

    public void insertTitle(String title) throws TitleCampRequiredException {
        checkInput(title);
        registrationBookBean.setTitle(title);

    }

    public void insertArgument(String argument) throws WrongArgumentInsertException {
       checkInput(argument);
       registrationBookBean.setArgument(argument);
    }

    public void insertPublisher(String publisher)
    {
        checkInput(publisher);
        registrationBookBean.setPublisher(publisher);
    }


    public void insertAuthor(String author)
    {
       checkInput(author);
       registrationBookBean.setAuthor(author);
    }

    public void insertNPage(int nPage)
    {
        checkInput(String.valueOf(nPage));
        registrationBookBean.setNPage(nPage);

    }

    public void insertTypeOfBook(int typeOfBook)
    {
        checkInput(String.valueOf(typeOfBook));
        registrationBookBean.setTypeOfBook(typeOfBook);
    }

    public void insertComment(String comment)
    {
        checkInput(comment);
        registrationBookBean.setComment(comment);
    }

    public void checkInput(String value)
    {

        try {
            int command = Integer.parseInt(value);
            if (command == -1)
                cliInsertBookView.start();
        } catch (NumberFormatException e) {
            // Non è un comando numerico, prosegui normalmente
        }

    }

    private String getSessionEmail()
    {
        return  Session.getCurrentSession().getUser()==null?Session.getCurrentSession().getBookShop().getEmail():Session.getCurrentSession().getUser().getEmail();
    }

    private int getSessionAccountType()
    {
        return  Session.getCurrentSession().getUser()==null?2:1;
    }

}
