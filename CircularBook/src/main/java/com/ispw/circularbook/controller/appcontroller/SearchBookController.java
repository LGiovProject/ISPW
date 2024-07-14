package com.ispw.circularbook.controller.appcontroller;

import com.ispw.circularbook.engineering.bean.*;

import com.ispw.circularbook.engineering.dao.SearchBookDAO;
import com.ispw.circularbook.engineering.enums.Command;
import com.ispw.circularbook.engineering.exception.NoBookFoundException;
import com.ispw.circularbook.engineering.exception.NoBookLendedException;
import com.ispw.circularbook.engineering.exception.NoBookRegisteredException;
import com.ispw.circularbook.model.BookModel;
import com.ispw.circularbook.model.CircularBookInfoModel;


import java.util.ArrayList;
import java.util.List;

public class SearchBookController {

    public List<BookBean> searchAvailableBook(SearchBookBean searchBookBean) throws NoBookFoundException {

        List<BookModel> bookModelList;
        bookModelList=SearchBookDAO.searchAvailableBook(searchBookBean.getAuthor(),searchBookBean.getArgument(),searchBookBean.getTitle(),searchBookBean.getEmail());
        List<BookBean> bookBeanList= new ArrayList<>();
        for(BookModel bookModel: bookModelList)
        {
           bookBeanList.add(getBookBean(Command.AVAILABLE_BOOK,bookModel));
        }
        return bookBeanList;
    }


    public List<BookBean> searchMyAvailableBook(String email) throws NoBookRegisteredException {


        List<BookBean> bookBeanList= new ArrayList<>();
        List<BookModel> bookModelList=SearchBookDAO.searchMyAvailableBook(email);


        for (BookModel bookModel : bookModelList) {

            bookBeanList.add(getBookBean(Command.MY_AVAILABLE_BOOK,bookModel));
        }
        return bookBeanList;

    }


    public List<BookBean> searchMyTakenBook(String email) throws NoBookLendedException {

        List<BookModel> bookModelList=SearchBookDAO.searchTakedBook(email);
        List<BookBean> bookBeanList=new ArrayList<>();
        for (BookModel bookModel : bookModelList) {
            bookBeanList.add(getBookBean(Command.MY_TAKEN_BOOK,bookModel));
        }

        return bookBeanList;
    }


    public List<BookBean> searchMyGivenBook(String email) throws NoBookLendedException {

        List<BookBean> bookBeanList = new ArrayList<>();
        List<BookModel> bookModelList = SearchBookDAO.searchGivenBook(email);
        for(BookModel bookModel: bookModelList)
        {
            bookBeanList.add(getBookBean(Command.MY_GIVED_BOOK,bookModel));
        }
        return bookBeanList;
    }


    public CircularBookInfoBean searchUserCircularBookInfo(String email)
    {
        CircularBookInfoModel circularBookInfoModel = SearchBookDAO.searchBookUserCircularBookInfo(email);

        return new CircularBookInfoBean(circularBookInfoModel.getRegisterBook(), circularBookInfoModel.getLendedBook(), circularBookInfoModel.getGiftedBook(), circularBookInfoModel.getLendedBookTaked(), circularBookInfoModel.getGiftedBooktaked());

    }

    public CircularBookInfoBean searchBookShopCircularBookInfo(String email)
    {

        CircularBookInfoModel circularBookInfoModel =SearchBookDAO.searchBookBookShopCircularBookInfo(email);
        return new CircularBookInfoBean(circularBookInfoModel.getRegisterBook(), circularBookInfoModel.getLendedBook(), circularBookInfoModel.getGiftedBook(), circularBookInfoModel.getOpportunityInsert());

    }

    private BookBean getBookBean(Command command, BookModel bookModel)
    {
        BookBean bookBean = new BookBean();
        switch (command) {
            case MY_GIVED_BOOK:
                bookBean.setId(bookModel.getId());
                bookBean.setUsername(bookModel.getUserModelTaker().getAccountName());
                bookBean.setTypeOfBook(bookModel.getTypeOfDisponibility());
                bookBean.setTitle(bookModel.getTitle());
                bookBean.setAuthor(bookModel.getAuthor());
                bookBean.setArgument(bookModel.getArguments());
                bookBean.setNPage(bookModel.getNPage());
                bookBean.setComment(bookModel.getComment());
                bookBean.setDateStart(bookModel.getDateStart());
                bookBean.setDateFinish(bookModel.getDateFinish());
                bookBean.setDaysRemain(bookModel.getDaysRemains());
                return bookBean;
            case MY_TAKEN_BOOK:
                bookBean.setId(bookModel.getId());
                bookBean.setUsername(bookModel.getGenericAccountModelPutter().getAccountName());
                bookBean.setTypeOfBook(bookModel.getTypeOfDisponibility());
                bookBean.setTitle(bookModel.getTitle());
                bookBean.setAuthor(bookModel.getAuthor());
                bookBean.setArgument(bookModel.getArguments());
                bookBean.setNPage(bookModel.getNPage());
                bookBean.setComment(bookModel.getComment());
                bookBean.setDateStart(bookModel.getDateStart());
                bookBean.setDateFinish(bookModel.getDateFinish());
                bookBean.setDaysRemain(bookModel.getDaysRemains());
                return bookBean;
            case MY_AVAILABLE_BOOK:
                bookBean.setId(bookModel.getId());
                bookBean.setTypeOfBook(bookModel.getTypeOfDisponibility());
                bookBean.setTitle(bookModel.getTitle());
                bookBean.setPublisher(bookModel.getPublisher());
                bookBean.setAuthor(bookModel.getAuthor());
                bookBean.setArgument(bookModel.getArguments());
                bookBean.setNPage(bookModel.getNPage());
                bookBean.setComment(bookModel.getComment());
                return bookBean;
            case AVAILABLE_BOOK:
                bookBean.setId(bookModel.getId());
                bookBean.setAccountType(bookModel.getAccountTypePutter());
                bookBean.setEmail(bookModel.getGenericAccountModelPutter().getEmail());
                bookBean.setUsername(bookModel.getGenericAccountModelPutter().getAccountName());
                bookBean.setTypeOfBook(bookModel.getTypeOfDisponibility());
                bookBean.setPublisher(bookModel.getPublisher());
                bookBean.setTitle(bookModel.getTitle());
                bookBean.setAuthor(bookModel.getAuthor());
                bookBean.setArgument(bookModel.getArguments());
                bookBean.setNPage(bookModel.getNPage());
                bookBean.setComment(bookModel.getComment());
                return bookBean;
            default:
                return bookBean;

        }
    }



}
