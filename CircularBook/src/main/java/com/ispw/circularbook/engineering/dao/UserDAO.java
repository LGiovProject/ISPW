package com.ispw.circularbook.engineering.dao;

import com.ispw.circularbook.engineering.connection.ConnectionDB;
import com.ispw.circularbook.engineering.dao.queries.CRUDQueries;
import com.ispw.circularbook.engineering.dao.queries.Queries;
import com.ispw.circularbook.engineering.exception.ErrorConnectionDbException;
import com.ispw.circularbook.model.UserModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAO {

    private UserDAO(){}

    public static UserModel searchUserByEmail(String email)
    {
        Statement stmt;
        UserModel userModel = new UserModel();

        try {
            stmt = ConnectionDB.getConnection();

            ResultSet resultSet =Queries.searchUserByMail(stmt,email);
            if(!resultSet.first()) {
                throw new SQLException("errore");
            }
             resultSet.first();
             userModel.setEmail(resultSet.getString(1));
             userModel.setAccountName(resultSet.getString(2));
             userModel.setName(resultSet.getString(3));
             userModel.setSurname(resultSet.getString(4));
             userModel.setCity(resultSet.getString(5));
             
             resultSet.close();

        }catch (SQLException | ErrorConnectionDbException e) {
            e.printStackTrace();
        }
        return userModel;
    }

    public static void updateUser(UserModel userModel)
    {
        Statement stmt;
        try
        {
            stmt=ConnectionDB.getConnection();

            CRUDQueries.updateUser(stmt, userModel.getEmail(), userModel.getName(), userModel.getSurname(), userModel.getAccountName(), userModel.getCityString());
        } catch (ErrorConnectionDbException | SQLException e) {
            e.printStackTrace();
        }


    }



}
