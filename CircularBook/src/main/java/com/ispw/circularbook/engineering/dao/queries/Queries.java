/*
 *    Copyright (C) 2022 Guglielmo De Angelis (a.k.a. Gulyx)
 *
 *    This file is part of the contents developed for the course
 * 	  ISPW (A.Y. 2022-2023) at Università di Tor Vergata in Rome.
 *
 *    This is free software: you can redistribute it and/or modify
 *    it under the terms of the GNU Lesser General Public License as
 *    published by the Free Software Foundation, either version 3 of the
 *    License, or (at your option) any later version.
 *
 *    This software is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU Lesser General Public License for more details.
 *
 *    You should have received a copy of the GNU Lesser General Public License
 *    along with this source.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package com.ispw.circularbook.engineering.dao.queries;



import java.sql.*;

public class Queries {
        //costruttore privato
        private Queries() {}

        public static ResultSet checkLogin(Statement stmt, String email, String password) throws SQLException {
            String sql = "SELECT CASE WHEN EXISTS (SELECT email FROM users WHERE email IN (SELECT email FROM login WHERE email = '" + email + "' AND password='" + password + "')) THEN 1 WHEN EXISTS (SELECT email FROM book_shop WHERE email IN (SELECT email FROM login WHERE email = '" + email + "' AND password='" + password + "')) THEN 2 END" ;

            return stmt.executeQuery(sql);

        }

        public static ResultSet checkEmailU(Statement stmt, String email) throws SQLException {
            String sql="SELECT COUNT(*) FROM users WHERE email='"+email+"';";
            return stmt.executeQuery(sql);
        }

        public static ResultSet searchUserByMail(Statement stmt,String email) throws SQLException {
            String sql="SELECT email ,username, name ,surname, city FROM users WHERE email= '"+email+"'";
            return stmt.executeQuery(sql);
        }

        public static ResultSet searchBookShopByEmail(Statement stmt, String email) throws SQLException
        {
            String sql="SELECT email , book_shop_name ,city, address, phone_number FROM book_shop WHERE email= '"+email+"'";
            return stmt.executeQuery(sql);
        }

        public static ResultSet searchAvailableBook(Statement stmt, String author, String argument, String title, String eamil ) throws SQLException {
            String sql="SELECT * FROM book_available_info WHERE (author = COALESCE("+author+", author) AND argument = COALESCE("+argument+", argument) AND title= COALESCE("+title+",title)) and (email!="+eamil+");";
            return stmt.executeQuery(sql);
        }

        public static ResultSet searchMyAvailableBook(Statement stmt, String email) throws SQLException {
            String sql="SELECT id,type_of_disponibility,publisher,author,argument,title,npage,comment FROM book_available_info WHERE email = '"+email+"';";
            return stmt.executeQuery(sql);
        }

        public static ResultSet searchTakedBook(Statement stmt,String email) throws SQLException {

            String sql="SELECT id,account_type_putter,username_putter,publisher,author,argument,title,npage,comment,type,date_taked,date_finish from book_taked where email_take='"+email+"';";
            return stmt.executeQuery(sql);
        }

        public static ResultSet searchGivenBook(Statement stmt,String email) throws SQLException{
            String sql="SELECT id,username_take,publisher,author,argument,title,npage,comment,type,date_taked,date_finish from book_taked where email_putter='"+email+"';";
            return stmt.executeQuery(sql);
        }

        public static ResultSet searchOpportunity(Statement stmt, String bookShopName,String typeOfOpportunity,String month) throws SQLException {
            String sql="SELECT * FROM opportunity_info WHERE (book_shop_name = COALESCE("+ bookShopName+", book_shop_name)AND type_of_opportunity = COALESCE("+ typeOfOpportunity+" , type_of_opportunity) AND month(date_start) <= COALESCE("+ month+",month(date_start)) and month(date_finish)>=coalesce("+ month+",month(date_finish))) ;";
            return stmt.executeQuery(sql);
        }

        public static ResultSet searchOpportunity(Statement stmt, String email) throws SQLException {

            String sql="SELECT * FROM opportunity WHERE email='"+email+"' ;";
            return stmt.executeQuery(sql);
        }




}
