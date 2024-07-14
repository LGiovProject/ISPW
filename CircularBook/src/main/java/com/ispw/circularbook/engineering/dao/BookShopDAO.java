package com.ispw.circularbook.engineering.dao;


import com.ispw.circularbook.engineering.connection.ConnectionDB;
import com.ispw.circularbook.engineering.dao.queries.CRUDQueries;
import com.ispw.circularbook.engineering.dao.queries.Queries;
import com.ispw.circularbook.engineering.exception.ErrorConnectionDbException;
import com.ispw.circularbook.model.BookShopModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BookShopDAO {

    private BookShopDAO(){}

    public static BookShopModel searchBookShopByEmail(String email)
    {
        Statement stmt;
        BookShopModel bookShopModel =new BookShopModel();
        try
        {
            stmt= ConnectionDB.getConnection();
            ResultSet resultSet = Queries.searchBookShopByEmail(stmt,email);
            if(!resultSet.first()) {
                throw new SQLException();
            }
            resultSet.first();
            bookShopModel.setEmail(resultSet.getString(1));
            bookShopModel.setAccountName(resultSet.getString(2));
            bookShopModel.setCity(resultSet.getString(3));
            bookShopModel.setAddress(resultSet.getString(4));
            bookShopModel.setPhoneNumber(resultSet.getInt(5));

            resultSet.close();
        } catch (SQLException| ErrorConnectionDbException e) {
            e.printStackTrace();
        }

        return bookShopModel;
    }


    public static void updateBookShop(BookShopModel bookShopModel)
    {
        Statement stmt;
        try
        {
            stmt=ConnectionDB.getConnection();
            CRUDQueries.updateBookShop(stmt, bookShopModel.getEmail(), bookShopModel.getAccountName(), bookShopModel.getAddress(), bookShopModel.getPhoneNumberString(), bookShopModel.getCityString());
        } catch (ErrorConnectionDbException | SQLException e) {
            e.printStackTrace();
        }
    }
}
