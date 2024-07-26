package junit;

import com.ispw.circularbook.engineering.bean.LoginBean;
import com.ispw.circularbook.engineering.dao.LoginDAO;
import com.ispw.circularbook.engineering.exception.WrongEmailFormattException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestLoginDAOJDBC {

    private static final String EMAIL="luca@gmail.com";
    private static final String PASSWORD ="utente1";

    @Test
    void testCheckLoginSuccessful()
    {
        try {
            LoginBean loginBeanJDBC = new LoginBean();
            loginBeanJDBC.setEmail(EMAIL);
            loginBeanJDBC.setPassword(PASSWORD);

            LoginDAO.checkLogin(loginBeanJDBC);

            assertEquals(1,loginBeanJDBC.getType());

        }catch (WrongEmailFormattException e) {
            throw new RuntimeException(e);
        }

    }
}
