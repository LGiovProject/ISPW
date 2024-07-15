package com.ispw.circularbook.controller.appcontroller;

import com.ispw.circularbook.engineering.bean.UpdateUserInfoBean;
import com.ispw.circularbook.engineering.dao.BookShopDAO;
import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.model.BookShopModel;

public class BookShopController {

    public void updateBookShop(UpdateUserInfoBean updateUserInfoBean)
    {
        updateSession(updateUserInfoBean);
        BookShopModel bookShopModel = new BookShopModel();
        bookShopModel.setEmail(updateUserInfoBean.getEmail());
        bookShopModel.setCity(updateUserInfoBean.getCity());
        bookShopModel.setAccountName(updateUserInfoBean.getNameBookShop());
        bookShopModel.setAddress(updateUserInfoBean.getAddress());
        bookShopModel.setPhoneNumber(updateUserInfoBean.getNumberPhone());
        BookShopDAO.updateBookShop(bookShopModel);
    }

    private void updateSession(UpdateUserInfoBean updateUserInfoBean)
    {
        Session.getCurrentSession().getBookShop().setBookShopName(updateUserInfoBean.getNameBookShop());
        Session.getCurrentSession().getBookShop().setAddress(updateUserInfoBean.getAddress());
        Session.getCurrentSession().getBookShop().setPhoneNumber(updateUserInfoBean.getNumberPhone());
        Session.getCurrentSession().getBookShop().setCity(updateUserInfoBean.getCity());
    }

}
