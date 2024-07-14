package com.ispw.circularbook.engineering.dao;


import com.ispw.circularbook.engineering.bean.SignInBean;
import com.ispw.circularbook.engineering.connection.ConnectionDB;
import com.ispw.circularbook.engineering.dao.queries.Queries;
import com.ispw.circularbook.engineering.enums.MediatorEvent;
import com.ispw.circularbook.engineering.exception.ErrorConnectionDbException;
import com.ispw.circularbook.engineering.exception.EmailUsedException;
import com.ispw.circularbook.engineering.mediator.Component;



import java.sql.*;

public class SignInDAOJDBC extends Component {

    public  void signInB(SignInBean signInBean){

        try {
            CallableStatement callableStatement = ConnectionDB.insertBookShop();
            callableStatement.setString(1,signInBean.getEmail());
            callableStatement.setString(2,signInBean.getPassword());
            callableStatement.setString(3,signInBean.getNameBookShop());
            callableStatement.setString(4,signInBean.getCittaString());
            callableStatement.setString(5,signInBean.getAddress());
            callableStatement.setString(6,signInBean.getPhoneNumber());
            callableStatement.execute();
            super.mediator.notify(this, MediatorEvent.SIGN_IN_BOOK_SHOP,signInBean);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public  void signInU(SignInBean signInBean)
    {
        try {
            CallableStatement callableStatement = ConnectionDB.insertUser();
            callableStatement.setString(1,signInBean.getEmail());
            callableStatement.setString(2,signInBean.getPassword());
            callableStatement.setString(3,signInBean.getUsername());
            callableStatement.setString(4,signInBean.getName());
            callableStatement.setString(5,signInBean.getSurname());
            callableStatement.setString(6,signInBean.getCittaString());
            callableStatement.execute();
            super.mediator.notify(this,MediatorEvent.SIGN_IN_USER,signInBean);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //E' un controllo preliminare per verificare se la mail è già stata usata
    public static void checkEmail(String email) throws EmailUsedException
    {
        Statement stmt;
        ResultSet resultSet;
        try {
            stmt = ConnectionDB.getConnection();

             resultSet = Queries.checkEmailU(stmt,email);
             resultSet.first();

             if(resultSet.getInt(1)==1) {
                 throw new EmailUsedException();
             }

        } catch (ErrorConnectionDbException | SQLException e) {
            e.printStackTrace();
        }
    }


}

