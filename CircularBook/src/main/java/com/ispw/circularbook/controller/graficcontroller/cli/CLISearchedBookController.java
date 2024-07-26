package com.ispw.circularbook.controller.graficcontroller.cli;

import com.ispw.circularbook.controller.appcontroller.InsertBookController;
import com.ispw.circularbook.engineering.bean.BookBean;
import com.ispw.circularbook.engineering.bean.TakenBookBean;
import com.ispw.circularbook.engineering.exception.CommandNotFoundException;
import com.ispw.circularbook.engineering.exception.NoBookFoundException;
import com.ispw.circularbook.engineering.exception.NoBookMoreAvailableException;
import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.engineering.utils.MessageSupport;
import com.ispw.circularbook.view.cli.CLISearchBookTakeView;

import java.time.LocalDate;
import java.util.List;

public class CLISearchedBookController {


    CLIResearchBookController cliResearchBookController;

    String sessionEmail;

    List<BookBean> bookBeanList;

    CLISearchBookTakeView cliSearchBookTakeView;

    private static final String TAKE_BOOK="1";
    private static final String BACK_TO_RESEARCH ="2";

    public CLISearchedBookController(CLIResearchBookController cliResearchBookController, List<BookBean> bookBeanList)
    {
        sessionEmail = Session.getCurrentSession().getUser().getEmail();
        this.cliResearchBookController = cliResearchBookController;
        cliSearchBookTakeView = new CLISearchBookTakeView(this);
        this.bookBeanList=bookBeanList;
    }

    public void start()
    {
        cliSearchBookTakeView.start();
    }

    public void command(String cmn) throws CommandNotFoundException {
        switch (cmn)
        {
            case TAKE_BOOK:
                if(Session.getCurrentSession().getUser().isGuest())
                    MessageSupport.cliDaniedAccesMessage();
                else
                    cliSearchBookTakeView.getIdBook();
                break;
            case BACK_TO_RESEARCH:
                cliResearchBookController.start();
                break;
            default:
                throw new CommandNotFoundException();
        }
    }


    public void takeBook(int id) throws NoBookMoreAvailableException, NoBookFoundException {
        checkInput(id);
        TakenBookBean takenBookBean = getTakeBookBean(bookBeanList,id);
        InsertBookController insertBookController = new InsertBookController();
        insertBookController.registerTakenBook(takenBookBean);
        MessageSupport.cliSuccessMessage("The book is taken successfully");
        cliResearchBookController.start();

    }


    private TakenBookBean getTakeBookBean(List<BookBean> bookBeanList, int i) throws NoBookFoundException {

        for(BookBean bookBean: bookBeanList)
        {
            if(bookBean.getId()==i){
                return new TakenBookBean(bookBean.getId(), bookBean.isUser(), bookBean.getTypeOfBookInt(),bookBean.getEmail(),sessionEmail,LocalDate.now());
            }
        }
        throw new NoBookFoundException();

    }

    private void checkInput(int i)
    {
        if(i<0)
            cliSearchBookTakeView.start();
    }
}
