package com.ispw.circularbook.engineering.dao;

import com.ispw.circularbook.engineering.connection.ConnectionDB;
import com.ispw.circularbook.engineering.dao.queries.Queries;
import com.ispw.circularbook.engineering.exception.*;
import com.ispw.circularbook.model.*;


import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SearchBookDAO {

    private SearchBookDAO(){}

    public static List<BookModel> searchAvailableBook( String author,String argument, String title, String email) throws NoBookFoundException {
        Statement stmt;
        ResultSet resultSet;
        List<BookModel> bookModelList= new ArrayList<>();

        try{
            stmt= ConnectionDB.getConnection();
            resultSet=Queries.searchAvailableBook(stmt,author,argument,title,email);

            if(!resultSet.first())
            {
                throw new NoBookFoundException();
            }

                resultSet.next();
                // Riposiziono il cursore sul primo record del result set
                resultSet.first();

                do {
                    BookModel bookModel = new BookModel();
                    bookModel.setId(resultSet.getInt(1));
                    String emailTemp=resultSet.getString(2);
                    String usernameTemp =resultSet.getString(3);
                    bookModel.setTypeOfDisponibility(resultSet.getInt(4));
                    bookModel.setPublisher(resultSet.getString(5));
                    bookModel.setAuthor(resultSet.getString(6));
                    bookModel.setArguments(resultSet.getString(7));
                    bookModel.setTitle(resultSet.getString(8));
                    bookModel.setNPage(resultSet.getInt(9));
                    bookModel.setComment(resultSet.getString(10));
                    bookModel.setAccountTypePutter(resultSet.getInt(11));
                    if(bookModel.getAccountTypePutter()==1) {
                        UserModel userModel = new UserModel(emailTemp);
                        userModel.setAccountName(usernameTemp);
                        bookModel.setGenericAccountModelPutter(userModel);
                    }
                    else
                    {
                        BookShopModel bookShopModel = new BookShopModel(emailTemp);
                        bookShopModel.setAccountName(usernameTemp);
                        bookModel.setGenericAccountModelPutter(bookShopModel);
                    }

                    bookModelList.add(bookModel);
                } while (resultSet.next());







            resultSet.close();

        } catch (ErrorConnectionDbException |SQLException e) {
            e.printStackTrace();
        }
        return bookModelList;
    }

    public static List<BookModel> searchMyAvailableBook(String email) throws NoBookRegisteredException {
        Statement stmt;
        ResultSet resultSet;
        List<BookModel> bookModelList= new ArrayList<>();
        try{
            stmt= ConnectionDB.getConnection();
            resultSet=Queries.searchMyAvailableBook(stmt,email);

            if(!resultSet.first())
            {
                throw new NoBookRegisteredException();

            }



            resultSet.next();
            // Riposiziono il cursore sul primo record del result set
            resultSet.first();

            do {
                BookModel bookModel = new BookModel();
                bookModel.setId(resultSet.getInt(1));
                bookModel.setTypeOfDisponibility(resultSet.getInt(2));
                bookModel.setPublisher(resultSet.getString(3));
                bookModel.setAuthor(resultSet.getString(4));
                bookModel.setArguments(resultSet.getString(5));
                bookModel.setTitle(resultSet.getString(6));
                bookModel.setNPage(resultSet.getInt(7));
                bookModel.setComment(resultSet.getString(8));
                bookModelList.add(bookModel);
            } while (resultSet.next());

                resultSet.close();

        } catch (SQLException | ErrorConnectionDbException e) {
            e.printStackTrace();
        }

        return bookModelList;
    }

    public static List<BookModel> searchTakedBook (String email) throws NoBookLendedException {

            Statement stmt;
            ResultSet resultSet;
            List<BookModel> bookModelList= new ArrayList<>();
            try{
                stmt= ConnectionDB.getConnection();
                resultSet=Queries.searchTakedBook(stmt,email);

                if(!resultSet.first())
                {
                    throw new NoBookLendedException();
                }

                resultSet.next();
                // Riposiziono il cursore sul primo record del result set
                resultSet.first();

                do {
                    BookModel bookModel = new BookModel();
                    bookModel.setId(resultSet.getInt(1));
                    bookModel.setAccountTypePutter(resultSet.getInt(2));
                    if(bookModel.getAccountTypePutter()==1){
                        UserModel userModel = new UserModel();
                        userModel.setAccountName(resultSet.getString(3));
                        bookModel.setGenericAccountModelPutter(userModel);
                    }
                    else
                    {
                        BookShopModel bookShopModel = new BookShopModel();
                        bookShopModel.setAccountName(resultSet.getString(3));
                        bookModel.setGenericAccountModelPutter(bookShopModel);
                    }
                    bookModel.setPublisher(resultSet.getString(4));
                    bookModel.setAuthor(resultSet.getString(5));
                    bookModel.setArguments(resultSet.getString(6));
                    bookModel.setTitle(resultSet.getString(7));
                    bookModel.setNPage(resultSet.getInt(8));
                    bookModel.setComment(resultSet.getString(9));
                    bookModel.setTypeOfDisponibility(resultSet.getInt(10));
                    bookModel.setDateStart(resultSet.getString(11));
                    if(bookModel.getTypeOfDisponibility()==1) {
                        String buffer = resultSet.getString(12);
                        bookModel.setDateFinish(buffer);
                        bookModel.setDaysRemaing(buffer);
                    }
                    bookModelList.add(bookModel);

                } while (resultSet.next());

                resultSet.close();

            } catch (ErrorConnectionDbException  |SQLException e) {
                e.printStackTrace();
            }
            return bookModelList;

    }

    public static List<BookModel> searchGivenBook(String email) throws NoBookLendedException {
        Statement stmt;
        ResultSet resultSet;
        List<BookModel> bookModelList= new ArrayList<>();
        try{
            stmt= ConnectionDB.getConnection();
            resultSet=Queries.searchGivenBook(stmt,email);

            if(!resultSet.first())
            {
                throw new NoBookLendedException();

            }

            resultSet.next();
            // Riposiziono il cursore sul primo record del result set
            resultSet.first();

            do {
                UserModel userModel = new UserModel();
                BookModel bookModel = new BookModel();

                bookModel.setId(resultSet.getInt(1));
                userModel.setAccountName(resultSet.getString(2));
                bookModel.setPublisher(resultSet.getString(3));
                bookModel.setAuthor(resultSet.getString(4));
                bookModel.setArguments(resultSet.getString(5));
                bookModel.setTitle(resultSet.getString(6));
                bookModel.setNPage(resultSet.getInt(7));
                bookModel.setComment(resultSet.getString(8));
                bookModel.setTypeOfDisponibility(resultSet.getInt(9));
                bookModel.setDateStart(resultSet.getString(10));
                if(bookModel.getTypeOfDisponibility()==1) {
                    String buffer = resultSet.getString(11);
                    bookModel.setDateFinish(buffer);
                    bookModel.setDaysRemaing(buffer);

                }
                bookModel.setUserModelTaker(userModel);
                bookModelList.add(bookModel);
            } while (resultSet.next());

            resultSet.close();

        } catch (ErrorConnectionDbException  |SQLException e) {
            e.printStackTrace();
        }
        return bookModelList;
    }

    public static CircularBookInfoModel searchBookUserCircularBookInfo(String email)  {

        CircularBookInfoModel circularBookInfoModel = new CircularBookInfoModel();
        try {
            CallableStatement callableStatement = ConnectionDB.userCircularBookInfo();
            callableStatement.setString(1,email);
            callableStatement.executeQuery();

            ResultSet resultSet= callableStatement.getResultSet();
            if(!resultSet.next())
            {
                throw new NoBookInfoException();

            }
            circularBookInfoModel.setRegisterBook( resultSet.getInt(1));
            circularBookInfoModel.setLendedBook(resultSet.getInt(2));
            circularBookInfoModel.setGiftedBook(resultSet.getInt(3));
            circularBookInfoModel.setLendedBookTaked(resultSet.getInt(4));
            circularBookInfoModel.setGiftedBooktaked(resultSet.getInt(5));

        } catch (SQLException | NoBookInfoException e) {
            e.printStackTrace();
        }


        return circularBookInfoModel;
    }

    public static CircularBookInfoModel searchBookBookShopCircularBookInfo(String email)    {

            CircularBookInfoModel circularBookInfoModel = new CircularBookInfoModel();
        try (CallableStatement callableStatement = ConnectionDB.bookShopCircularBookInfo();){

            callableStatement.setString(1,email);
            callableStatement.executeQuery();

            ResultSet resultSet = callableStatement.getResultSet();
            if(!resultSet.next())
                throw new NoBookInfoException();

            circularBookInfoModel.setRegisterBook(resultSet.getInt(1));
            circularBookInfoModel.setOpportunityInsert(resultSet.getInt(2));
            circularBookInfoModel.setLendedBook(resultSet.getInt(3));
            circularBookInfoModel.setGiftedBook(resultSet.getInt(4));

        } catch (SQLException | NoBookInfoException e) {
            e.printStackTrace();
        }
        return circularBookInfoModel;
    }
}


