package com.ispw.circularbook.controller.appcontroller;


import com.ispw.circularbook.engineering.bean.BookShopBean;
import com.ispw.circularbook.engineering.bean.LoginBean;
import com.ispw.circularbook.engineering.bean.UserBean;
import com.ispw.circularbook.engineering.dao.*;
import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.model.BookShopModel;
import com.ispw.circularbook.model.UserModel;
import java.time.LocalTime;


public class LoginController {


    public void checkLogin(LoginBean loginBean) {

        if (LocalTime.now().getMinute() % 2 == 0) {
            loginBean.setType(LoginDAO.checkLogin(loginBean));
        } else {
            loginBean.setType(LoginDAOCSV.checkLogin(loginBean));
        }

    }

    public void setUserSession(LoginBean loginBean)
    {
        UserModel userModel=UserDAO.searchUserByEmail(loginBean.getEmail());
        UserBean userBean = getUserBean(userModel);
        userBean.setGuest(false);
        Session.setSessionInstance(userBean);
    }


    public void setBookShopSession(LoginBean loginBean){

        BookShopModel bookShopModel = BookShopDAO.searchBookShopByEmail(loginBean.getEmail());
        BookShopBean bookShopBean = getBookShopBean(bookShopModel);
        Session.setSessionInstance(bookShopBean);

    }

    public LoginBean setGuestSession()
    {
        UserBean userBean = new UserBean(null,null,null,null,null,null);
        userBean.setGuest(true);
        Session.setSessionInstance(userBean);
        LoginBean loginBean = new LoginBean();
        loginBean.setType(1);
        return loginBean;

    }

    private UserBean getUserBean(UserModel userModel)
    {
        UserBean userBean = new UserBean();
        userBean.setEmail(userModel.getEmail());
        userBean.setName(userModel.getName());
        userBean.setSurname(userModel.getSurname());
        userBean.setUsername(userModel.getAccountName());
        userBean.setCity(userModel.getCity());
        return userBean;
    }

    private BookShopBean getBookShopBean(BookShopModel bookShopModel)
    {
        BookShopBean bookShopBean = new BookShopBean();
        bookShopBean.setEmail(bookShopModel.getEmail());
        bookShopBean.setBookShopName(bookShopModel.getAccountName());
        bookShopBean.setAddress(bookShopModel.getAddress());
        bookShopBean.setPhoneNumber(bookShopModel.getPhoneNumber());
        bookShopBean.setCity(bookShopModel.getCity());
        return bookShopBean;
    }


}