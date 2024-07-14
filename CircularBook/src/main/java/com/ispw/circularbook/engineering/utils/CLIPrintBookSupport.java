package com.ispw.circularbook.engineering.utils;

import com.ispw.circularbook.engineering.bean.BookBean;

import java.util.List;

public class CLIPrintBookSupport {

    private static final String TITLE ="Titolo :";
    private static final String USERNAME="Username :";
    private static final String TYPOLOGY="Tipologia :";
    private static final String PUBLISHER="Publisher :";
    private static final String AUTHOR= "Autore :";
    private static final String ARGUMENT ="Argomento :";
    private static final String NUMBER_OF_PAGE="Numero di pagine :";
    private static final String COMMENT="Commento :";

    private CLIPrintBookSupport(){}

    public static void showBookAvailable(List<BookBean> bookBeanList)
    {
        for(BookBean bookBean: bookBeanList) {
            CLIMessageSupport.delimiterMessage();
            CLIMessageSupport.simpleMessage("L'id del libro è :" + bookBean.getId());
            CLIMessageSupport.simpleMessage(TITLE + bookBean.getTitle());
            CLIMessageSupport.simpleMessage(USERNAME + bookBean.getUsername());
            CLIMessageSupport.simpleMessage(TYPOLOGY + bookBean.getTypeOfDisponibilityString());
            CLIMessageSupport.simpleMessage(PUBLISHER + bookBean.getPublisher());
            CLIMessageSupport.simpleMessage(AUTHOR + bookBean.getAuthor());
            CLIMessageSupport.simpleMessage(ARGUMENT + bookBean.getArgument());
            CLIMessageSupport.simpleMessage(NUMBER_OF_PAGE + bookBean.getNPageString());
            CLIMessageSupport.simpleMessage(COMMENT + bookBean.getComment());
            CLIMessageSupport.delimiterMessage();
        }
    }

    public static void showMyBookAvailable(List<BookBean> bookBeanList)
    {
        for(BookBean bookBean: bookBeanList) {
            CLIMessageSupport.delimiterMessage();
            CLIMessageSupport.simpleMessage("L'id del libro è :" + bookBean.getId());
            CLIMessageSupport.simpleMessage(TITLE + bookBean.getTitle());
            CLIMessageSupport.simpleMessage(TYPOLOGY + bookBean.getTypeOfDisponibilityString());
            CLIMessageSupport.simpleMessage(PUBLISHER + bookBean.getPublisher());
            CLIMessageSupport.simpleMessage(AUTHOR + bookBean.getAuthor());
            CLIMessageSupport.simpleMessage(ARGUMENT + bookBean.getArgument());
            CLIMessageSupport.simpleMessage(NUMBER_OF_PAGE + bookBean.getNPageString());
            CLIMessageSupport.simpleMessage(COMMENT + bookBean.getComment());
            CLIMessageSupport.delimiterMessage();
        }
    }

    public static void showBookITaked(List<BookBean> bookBeanList)
    {
        for(BookBean bookBean: bookBeanList) {
            CLIMessageSupport.delimiterMessage();
            CLIMessageSupport.simpleMessage(TITLE + bookBean.getTitle());
            CLIMessageSupport.simpleMessage("Took from :" + bookBean.getUsername());
            CLIMessageSupport.simpleMessage(TYPOLOGY + bookBean.getTypeOfDisponibilityString());
            CLIMessageSupport.simpleMessage(PUBLISHER+ bookBean.getPublisher());
            CLIMessageSupport.simpleMessage(AUTHOR + bookBean.getAuthor());
            CLIMessageSupport.simpleMessage(ARGUMENT + bookBean.getArgument());
            CLIMessageSupport.simpleMessage(NUMBER_OF_PAGE + bookBean.getNPageString());
            CLIMessageSupport.simpleMessage(COMMENT + bookBean.getComment());
            CLIMessageSupport.simpleMessage(bookBean.getTypeOfBookInt() == 1 ? "Remaining days :" + bookBean.getDaysRemain() : "preso in regalo");
            CLIMessageSupport.delimiterMessage();
        }
    }

    public static void showBookGived(List<BookBean> bookBeanList)
    {
        for(BookBean bookBean: bookBeanList) {
            CLIMessageSupport.delimiterMessage();
            CLIMessageSupport.simpleMessage(TITLE+bookBean.getTitle());
            CLIMessageSupport.simpleMessage("Took from :"+bookBean.getUsername());
            CLIMessageSupport.simpleMessage(TYPOLOGY+bookBean.getTypeOfDisponibilityString());
            CLIMessageSupport.simpleMessage(PUBLISHER + bookBean.getPublisher());
            CLIMessageSupport.simpleMessage(AUTHOR+bookBean.getAuthor());
            CLIMessageSupport.simpleMessage(ARGUMENT+bookBean.getArgument());
            CLIMessageSupport.simpleMessage(NUMBER_OF_PAGE+bookBean.getNPageString());
            CLIMessageSupport.simpleMessage(COMMENT+bookBean.getComment());
            CLIMessageSupport.simpleMessage(bookBean.getTypeOfBookInt()==1?"Remaining days :"+bookBean.getDaysRemain():"E' stato regalato");
            CLIMessageSupport.delimiterMessage();
        }
    }
}
