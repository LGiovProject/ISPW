package com.ispw.circularbook.engineering.dao;

import com.ispw.circularbook.engineering.bean.LoginBean;
import com.ispw.circularbook.engineering.connection.ConnectionDB;
import com.ispw.circularbook.engineering.dao.queries.Queries;

import com.ispw.circularbook.engineering.exception.ErrorConnectionDbException;
import com.ispw.circularbook.engineering.exception.NoAccountFoundException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDAO {


    private LoginDAO(){}

    public static int checkLogin(LoginBean loginBean) {

        Statement stmt;
        int type =0;
        try {
            stmt = ConnectionDB.getConnection();

            ResultSet resultSet = Queries.checkLogin(stmt, loginBean.getEmail(), loginBean.getPassword());
            // Verifico se il result set è vuoto e nel caso lancio un’eccezione
            if (!resultSet.first()) {
                throw new NoAccountFoundException();
            }
            else {
                resultSet.next();
                // Riposiziono il cursore sul primo record del result set
                resultSet.first();

                type=resultSet.getInt(1);


                resultSet.close();
            }

        }catch (SQLException| ErrorConnectionDbException | NoAccountFoundException e)
        {
            e.printStackTrace();
        }
        loginBean.setType(type);
        return type;

    }



}
