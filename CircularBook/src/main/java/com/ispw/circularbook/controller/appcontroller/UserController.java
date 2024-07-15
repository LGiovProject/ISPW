package com.ispw.circularbook.controller.appcontroller;

import com.ispw.circularbook.engineering.bean.UpdateUserInfoBean;
import com.ispw.circularbook.engineering.dao.UserDAO;
import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.model.UserModel;

public class UserController {
    public void updateUser(UpdateUserInfoBean updateUserInfoBean)
    {
        UserModel userModel =new UserModel();
        userModel.setEmail(updateUserInfoBean.getEmail());
        userModel.setName(updateUserInfoBean.getNameUser());
        userModel.setSurname(updateUserInfoBean.getSurname());
        userModel.setAccountName(updateUserInfoBean.getUsername());
        userModel.setCity(updateUserInfoBean.getCity());
        updateSession(updateUserInfoBean);
        UserDAO.updateUser(userModel);


    }

    private void updateSession(UpdateUserInfoBean updateUserInfoBean)
    {
        Session.getCurrentSession().getUser().setName(updateUserInfoBean.getNameUser());
        Session.getCurrentSession().getUser().setSurname(updateUserInfoBean.getSurname());
        Session.getCurrentSession().getUser().setUsername(updateUserInfoBean.getUsername());
        Session.getCurrentSession().getUser().setCity(updateUserInfoBean.getCity());
    }
}
