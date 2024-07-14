package com.ispw.circularbook.engineering.dao;


import com.ispw.circularbook.engineering.connection.ConnectionDB;
import com.ispw.circularbook.engineering.exception.NoBookMoreAvailableException;
import com.ispw.circularbook.model.BookModel;

import java.sql.CallableStatement;
import java.sql.SQLException;



public class BookDAO {


    private BookDAO(){}

    public static void insertBook(BookModel bookModel) {
        try {
            CallableStatement callableStatement = ConnectionDB.insertBook();
            callableStatement.setString(1,bookModel.getGenericAccountModelPutter().getEmail());
            callableStatement.setInt(2,bookModel.getTypeOfDisponibility());
            callableStatement.setString(3,bookModel.getPublisher());
            callableStatement.setString(4,bookModel.getAuthor());
            callableStatement.setString(5,bookModel.getArguments());
            callableStatement.setString(6,bookModel.getTitle());
            callableStatement.setInt(7,bookModel.getNPage());
            callableStatement.setString(8,bookModel.getComment());
            callableStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static void insertTakenBook(BookModel bookModel) throws NoBookMoreAvailableException {

        CallableStatement callableStatement;
       try {

            if(bookModel.getTypeOfDisponibility()==1) {
                callableStatement = ConnectionDB.takeLendBook();
                callableStatement.setInt(1, bookModel.getId());
                callableStatement.setString(2, bookModel.getUserModelTaker().getEmail());
                callableStatement.setString(3, bookModel.getGenericAccountModelPutter().getEmail());
                callableStatement.setString(4, bookModel.getDateStart().toString());
                callableStatement.setString(5, bookModel.getDateFinish().toString());
                callableStatement.execute();

            }
            else
            {
                callableStatement = ConnectionDB.takeGiftBook();
                callableStatement.setInt(1, bookModel.getId());
                callableStatement.setString(2, bookModel.getUserModelTaker().getEmail());
                callableStatement.setString(3, bookModel.getGenericAccountModelPutter().getEmail());
                callableStatement.setString(4, bookModel.getDateStart().toString());
                callableStatement.execute();

            }
       } catch (SQLException e) {
           if (e.getSQLState().equals("45012"))
               throw new NoBookMoreAvailableException();
           else
               e.printStackTrace();

               // Gestione del segnale SQLSTATE '45000'
       }

    }

    public static void updateBook(BookModel bookModel){

        try {
            CallableStatement callableStatement = ConnectionDB.updateBook();
            callableStatement.setInt(1,bookModel.getId());
            callableStatement.setInt(2,bookModel.getTypeOfDisponibility());
            callableStatement.setString(3,bookModel.getPublisher());
            callableStatement.setString(4, bookModel.getAuthor());
            callableStatement.setString(5, bookModel.getArguments());
            callableStatement.setString(6, bookModel.getTitle());
            callableStatement.setInt(7,bookModel.getNPage());
            callableStatement.setString(8,bookModel.getComment());
            callableStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void removeBook(int id)
    {
        try {
            CallableStatement callableStatement = ConnectionDB.removeBook();
            callableStatement.setInt(1,id);
            callableStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}