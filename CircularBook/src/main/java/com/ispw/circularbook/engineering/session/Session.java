package com.ispw.circularbook.engineering.session;

import com.ispw.circularbook.engineering.bean.BookShopBean;
import com.ispw.circularbook.engineering.bean.UserBean;
import com.ispw.circularbook.engineering.facade.SceneFacade;

public class Session {

    private static Session session;

    private UserBean userBean = null;
    private BookShopBean bookShopBean = null;
    private SceneFacade sceneFacade;

    private Session(Object ob) {
        if(ob instanceof UserBean userBeanTemp) {
            this.userBean = userBeanTemp;
        }
        else if(ob instanceof BookShopBean bookShopBeanTemp) {
            this.bookShopBean = bookShopBeanTemp;
        }
    }


    public static synchronized void setSessionInstance(Object ob) {
        if(session == null)
            session = new Session(ob);
    }

    public static void closeSession() {
        session = null;
    }

    public static Session getCurrentSession() {
        return session;
    }

    public UserBean getUser() {
        return userBean;
    }

    public BookShopBean getBookShop() {
        return bookShopBean;
    }

    public SceneFacade getSceneFacade() {
        return sceneFacade;
    }

    public void setSceneFacade(SceneFacade sceneFacade) {
        this.sceneFacade = sceneFacade;
    }
}
