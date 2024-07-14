package com.ispw.circularbook.engineering.dao.queries;

import java.sql.SQLException;
import java.sql.Statement;

public class CRUDQueries {

    private CRUDQueries(){}

    public static void updateUser(Statement stmt, String email, String name, String cognome,String username,String city) throws SQLException {
        String sql="UPDATE users SET name='"+name+"', surname='"+cognome+"', username='"+username+"', city='"+city+"' WHERE email='"+email+"';";
        stmt.executeUpdate(sql);
    }

    public static void updateBookShop(Statement stmt, String email, String name, String via, String ntel, String city) throws SQLException {
        String sql="UPDATE book_shop SET book_shop_name='"+name+"',address='"+via+"', phone_number="+ntel+",city='"+city+"' WHERE email='"+email+"';";
        stmt.executeUpdate(sql);
    }


    public static void updateOpportunity(Statement stmt, int id, String title,int type ,String description, String dateStart, String dateFinish) throws SQLException {
        String sql="UPDATE opportunity SET title='"+title+"',type="+type+" ,description='"+description+"',date_start='"+dateStart+"',date_finish='"+dateFinish+"' WHERE id="+id+";";
        stmt.executeUpdate(sql);
    }

    public static void insertOpportunity(Statement stmt, String email, String title, int typeOfOpportunity, String description, String dateStart, String dateFinish) throws SQLException {
        String sql="INSERT INTO opportunity (email,title,type,description,date_start,date_finish) VALUES('"+email+"',\""+title+"\","+typeOfOpportunity+",\""+description+"\",'"+dateStart+"','"+dateFinish+"');";
        stmt.executeUpdate(sql);
    }

    public static void removeOpportunity(Statement stmt, int id) throws SQLException {
        String sql="DELETE FROM opportunity WHERE id='"+id+"';";
        stmt.executeUpdate(sql);
    }
}
