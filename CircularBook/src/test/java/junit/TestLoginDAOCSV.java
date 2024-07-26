package junit;

import com.ispw.circularbook.engineering.bean.LoginBean;
import com.ispw.circularbook.engineering.dao.LoginDAOCSV;
import com.ispw.circularbook.engineering.exception.WrongEmailFormattException;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

class TestLoginDAOCSV {

    private static final String EMAIL="luca@gmail.com";
    private static final String PASSWORD ="utente1";

    @Test
    void testCheckLoginSuccessful()
    {
        try {
            LoginBean loginBeanCSV = new LoginBean();
            loginBeanCSV.setEmail(EMAIL);
            loginBeanCSV.setPassword(PASSWORD);

            LoginDAOCSV.checkLogin(loginBeanCSV);

            assertEquals(1,loginBeanCSV.getType());

        }catch (WrongEmailFormattException e) {
            throw new RuntimeException(e);
        }
    }
}
