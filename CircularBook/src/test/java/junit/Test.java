package junit;

import com.ispw.circularbook.controller.appcontroller.SignInController;
import com.ispw.circularbook.engineering.bean.LoginBean;
import com.ispw.circularbook.engineering.bean.SignInBean;
import com.ispw.circularbook.engineering.connection.ConnectionDB;
import com.ispw.circularbook.engineering.dao.LoginDAO;
import com.ispw.circularbook.engineering.dao.LoginDAOCSV;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class TestPersonal {

    private static final String EMAIL="test4@gmail.com";
    private static final String PASSWORD ="testpass4";
    private static final String CITY ="Roma";

    @Test
    void signInTest()
    {

        try{
            ConnectionDB.getConnection();
            SignInController signInController = new SignInController();
            SignInBean signInBean = new SignInBean();
            signInBean.setEmail(EMAIL);
            signInBean.setPassword(PASSWORD);
            signInBean.setName("test");
            signInBean.setCitta(CITY);
            signInBean.setSurname("tester");
            signInBean.setUsername("Testator");
            signInController.signInU(signInBean);


            LoginBean loginBeanJDBC = new LoginBean();
            loginBeanJDBC.setEmail(EMAIL);
            loginBeanJDBC.setPassword(PASSWORD);

            LoginBean loginBeanCSV = new LoginBean();
            loginBeanCSV.setEmail(EMAIL);
            loginBeanCSV.setPassword(PASSWORD);

            LoginDAO.checkLogin(loginBeanJDBC);
            LoginDAOCSV.checkLogin(loginBeanCSV);

            assertEquals(1,loginBeanCSV.getType());
            assertEquals(1,loginBeanJDBC.getType());

        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
