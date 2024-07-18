package junit;

import com.ispw.circularbook.controller.appcontroller.SignInController;
import com.ispw.circularbook.engineering.bean.LoginBean;
import com.ispw.circularbook.engineering.bean.SignInBean;
import com.ispw.circularbook.engineering.connection.ConnectionDB;
import com.ispw.circularbook.engineering.dao.LoginDAO;
import com.ispw.circularbook.engineering.dao.LoginDAOCSV;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class TestSignInUserController {

    private static final String EMAIL="test@gmail.com";
    private static final String PASSWORD ="test";
    /*
    * Il seguente test va a verficare se l'inserimento di un nuovo utente avviene correttamente
    * sia sul Database che sul file Sysyem.
    * Se l'inserimento non va a buon fine restituisce 0
    * Se invece la registrazione va a buon fine restituisce il valore corrispondente al tipo di utente inserito
    * 1 per gli User
    * 2 per i BookShop
    */
    @Test
    void signInUserTest()
    {

        try{
            ConnectionDB.getConnection();
            SignInController signInController = new SignInController();
            SignInBean signInBean = new SignInBean();
            signInBean.setEmail(EMAIL);
            signInBean.setPassword(PASSWORD);
            signInBean.setName("test");
            signInBean.setCitta("Roma");
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

        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
