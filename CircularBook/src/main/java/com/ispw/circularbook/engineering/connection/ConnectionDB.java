package com.ispw.circularbook.engineering.connection;



import com.ispw.circularbook.Main;
import com.ispw.circularbook.engineering.exception.ErrorConnectionDbException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

// uso il pattern Singleton
public class ConnectionDB {

    private ConnectionDB() {
        // definisco il costruttore privato anche se vuoto perché in questo modo non viene preso il costruttore pubblico di default
        // così da vietare alle altre classi di fare la new di ConnectionDB
    }

    private static Connection connection;

    // se fosse stata un'applicazione multi thread avrei dovuto mettere "synchronized"
    public static Statement getConnection() throws ErrorConnectionDbException {
        Statement stmt ;
        try {
            conn();
            stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException e) {
            throw new ErrorConnectionDbException();
        }
        return stmt;
    }

    private static void conn() {
        String username;
        String password;
        String url;
        String driverClassName;

        if (connection == null) {
            try{
                Properties properties=loadProperties();
                username=properties.getProperty("USER");
                password=properties.getProperty("PASS");
                url=properties.getProperty("DB_URL");
                driverClassName=properties.getProperty("DRIVER_CLASS_NAME");

                Class.forName(driverClassName);

                connection=DriverManager.getConnection(url,username,password);

            } catch (SQLException | IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private static Properties loadProperties() throws IOException {
        Properties properties = new Properties();
        try{
            InputStream inputStream = Main.class.getResourceAsStream("connection/connection.properties");
            properties.load(inputStream);
        }catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }


        return properties;
    }

    public static void closeConnection() throws SQLException {
        connection.close();
    }

    public static CallableStatement insertBook() throws SQLException {
        String procedureCall="call insert_book(?,?,?,?,?,?,?,?)";
        return connection.prepareCall(procedureCall);
    }

    public static CallableStatement insertUser() throws SQLException {
        String procedureCall ="call insert_user(?,?,?,?,?,?)";
        return connection.prepareCall(procedureCall);
    }

    public static CallableStatement insertBookShop() throws SQLException {
        String procedureCall ="call insert_book_shop(?,?,?,?,?,?)";
        return connection.prepareCall(procedureCall);
    }

    public static CallableStatement takeLendBook() throws SQLException {
        String procedureCall = "call  take_book_on_lend(?,?,?,?,?)";
        return connection.prepareCall(procedureCall);
    }

    public static CallableStatement takeGiftBook() throws SQLException {
        String procedureCall = "call  take_book_as_gift(?,?,?,?)";
        return connection.prepareCall(procedureCall);
    }

    public static CallableStatement removeBook() throws SQLException {
        String procedureCall="call remove_book(?)";
        return connection.prepareCall(procedureCall);
    }

    public static CallableStatement updateBook() throws SQLException {
        String procedureCall="call update_book(?,?,?,?,?,?,?,?)";
        return connection.prepareCall(procedureCall);
    }

    public static CallableStatement userCircularBookInfo() throws SQLException {
        String procedureCall="call view_user_circularbook_info(?)";
        return connection.prepareCall(procedureCall);
    }

    public static CallableStatement bookShopCircularBookInfo() throws SQLException {
        String procedureCall="call view_book_shop_circularbook_info(?)";
        return connection.prepareCall(procedureCall);
    }

}