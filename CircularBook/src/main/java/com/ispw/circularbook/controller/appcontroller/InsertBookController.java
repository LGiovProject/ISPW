package com.ispw.circularbook.controller.appcontroller;

import com.ispw.circularbook.engineering.bean.BookBean;
import com.ispw.circularbook.engineering.bean.TakenBookBean;
import com.ispw.circularbook.engineering.bean.RegistrationBookBean;
import com.ispw.circularbook.engineering.dao.BookDAO;
import com.ispw.circularbook.engineering.exception.NoBookMoreAvailableException;
import com.ispw.circularbook.model.BookModel;
import com.ispw.circularbook.model.BookShopModel;
import com.ispw.circularbook.model.UserModel;

public class InsertBookController {

    public void insertBook(RegistrationBookBean registrationBookBean){

        BookModel bookModel = new BookModel();
        bookModel.setTypeOfDisponibility(registrationBookBean.getTypeOfBookInt());
        bookModel.setPublisher(registrationBookBean.getPublisher());
        bookModel.setArguments(registrationBookBean.getArgument());
        bookModel.setAuthor(registrationBookBean.getAuthor());
        bookModel.setTitle(registrationBookBean.getTitle());
        bookModel.setNPage(registrationBookBean.getNPageInt());
        bookModel.setComment(registrationBookBean.getComment());


        if(registrationBookBean.isUser()) {
            UserModel userModel = new UserModel(registrationBookBean.getEmail());
            bookModel.setGenericAccountModelPutter(userModel);
        } else{
            BookShopModel bookShopModel = new BookShopModel(registrationBookBean.getEmail());
            bookModel.setGenericAccountModelPutter(bookShopModel);
        }
        BookDAO.insertBook(bookModel);
    }

    public void registerTakenBook(TakenBookBean takenBookBean) throws NoBookMoreAvailableException {

        BookModel bookModel = new BookModel();
        UserModel userModelTaker = new UserModel(takenBookBean.getEmailTaker());
        bookModel.setId(takenBookBean.getId());
        bookModel.setUserModelTaker(userModelTaker);
        bookModel.setTypeOfDisponibility(takenBookBean.getTypeOfDisponibility());
        if(bookModel.getTypeOfDisponibility()==1) {
            bookModel.setDateStart(takenBookBean.getDateStart());
            bookModel.setDateFinish(takenBookBean.getDateFinish());
        }else
            bookModel.setDateStart(takenBookBean.getDateStart());

        if (takenBookBean.isUser()) {
            UserModel userModelPutter = new UserModel(takenBookBean.getEmailGiver());
            bookModel.setGenericAccountModelPutter(userModelPutter);
        } else
        {
            BookShopModel bookShopModel = new BookShopModel(takenBookBean.getEmailGiver());
            bookModel.setGenericAccountModelPutter(bookShopModel);
        }
        BookDAO.insertTakenBook(bookModel);
    }

    public void updateBook(BookBean bookBean){

        BookModel bookModel = new BookModel();
        bookModel.setId(bookBean.getId());
        bookModel.setTypeOfDisponibility(bookBean.getTypeOfBookInt());
        bookModel.setTitle(bookBean.getTitle());
        bookModel.setAuthor(bookBean.getAuthor());
        bookModel.setArguments(bookBean.getArgumentString());
        bookModel.setPublisher(bookBean.getPublisher());
        bookModel.setNPage(bookBean.getNPage());
        bookModel.setComment(bookModel.getComment());
        BookDAO.updateBook(bookModel);

    }

    public void removeBook(int id){BookDAO.removeBook(id);}
}
