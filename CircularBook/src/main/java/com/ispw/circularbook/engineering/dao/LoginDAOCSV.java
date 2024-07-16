package com.ispw.circularbook.engineering.dao;

import com.ispw.circularbook.Main;
import com.ispw.circularbook.engineering.bean.LoginBean;

import java.io.*;
import java.net.URISyntaxException;

public class LoginDAOCSV {

    private static final int EMAIL_POSITION=0;
    private static final int PASSWORD_POSITION=1;
    private static final String CSV_LOGIN_NAME = "res/Login.csv";
    private static final String CSV_USER_NAME = "res/User.csv";
    private static final String CSV_BOOK_SHOP_NAME = "res/BookShop.csv";

    private LoginDAOCSV(){}


    public static int checkLogin(LoginBean loginBean)
    {

         int x=0;
         boolean flag=false;
         File file = findFile(CSV_LOGIN_NAME);
         try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file));){

             String row;
             String[] data;

             while ((row = bufferedReader.readLine()) != null) {
                 data = row.split(",");
                 if (data[EMAIL_POSITION].equals(loginBean.getEmail()) && data[PASSWORD_POSITION].equals(loginBean.getPassword()) ) {
                     flag = true;
                     break;

                 }
             }
         } catch (IOException e) {
             e.printStackTrace();
         }

         if(flag) {
             x=Math.max(foundUserType(loginBean), foundBookShopType(loginBean));
         }
         loginBean.setType(x);
         return x;
    }

    private static int foundUserType(LoginBean loginBean)
    {
        File file = findFile(CSV_USER_NAME);
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

            String row;
            String[] data;

            while ((row = bufferedReader.readLine()) != null) {
                data = row.split(",");
                if (data[EMAIL_POSITION].equals(loginBean.getEmail()))
                        return 1;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private static int foundBookShopType(LoginBean loginBean)
    {
        File file = findFile(CSV_BOOK_SHOP_NAME);

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file));) {

            String row;
            String[] data;

            while ((row = bufferedReader.readLine()) != null) {
                data = row.split(",");
                if (data[EMAIL_POSITION].equals(loginBean.getEmail()))
                    return 2;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private static File findFile(String path)
    {
        try {
            return new File(Main.class.getResource(path).toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return null;
        }
    }


}
