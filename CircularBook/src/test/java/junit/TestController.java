package junit;

import com.ispw.circularbook.controller.appcontroller.InsertBookController;
import com.ispw.circularbook.controller.appcontroller.SearchBookController;
import com.ispw.circularbook.controller.appcontroller.SignInController;
import com.ispw.circularbook.engineering.bean.BookBean;
import com.ispw.circularbook.engineering.bean.RegistrationBookBean;
import com.ispw.circularbook.engineering.bean.SignInBean;
import com.ispw.circularbook.engineering.connection.ConnectionDB;
import com.ispw.circularbook.engineering.enums.Arguments;
import com.ispw.circularbook.engineering.enums.TypeOfBook;
import com.ispw.circularbook.engineering.exception.*;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TestController {

private final String EMAIL="test@gmail.com";
    /*
    * Questo test verifica che effettivamente l'inserimento del libro vada a buon fine
    * per farlo effettua la registrazione di un nuovo utente in modo da evitare che ci siano libri
    * inseriti in precedenza.
    *
    * Dopodiche effettua l'inserimento del libro ed effettua una ricerca sui libri appartenti all'utente
    * Se la dimensione della lista è 1 il test è passato
    *
    * */

    @Test
    void test()
    {
        int valueTest=0;
        try {
            ConnectionDB.getConnection();
            SignInController signInController = new SignInController();
            SignInBean signInBean = new SignInBean();
            signInBean.setEmail(EMAIL);
            signInBean.setPassword("password");
            signInBean.setName("test");
            signInBean.setCitta("Roma");
            signInBean.setSurname("tester");
            signInBean.setUsername("Testator");
            signInController.signInU(signInBean);


            InsertBookController insertBookController = new InsertBookController();
            SearchBookController searchBookController = new SearchBookController();
            RegistrationBookBean registrationBookBean = new RegistrationBookBean();
            registrationBookBean.setEmail(EMAIL);

            registrationBookBean.setTitle("title");


            registrationBookBean.setTypeOfBook(TypeOfBook.LEND);
            registrationBookBean.setAccountType(1);
            registrationBookBean.setAuthor("author");
            registrationBookBean.setArgument(Arguments.ADVENTURE);
            registrationBookBean.setPublisher("publisher");
            registrationBookBean.setNPage(0);
            registrationBookBean.setComment("comment");
            insertBookController.insertBook(registrationBookBean);

            List<BookBean> bookBeanList=searchBookController.searchMyAvailableBook(EMAIL);
            valueTest =bookBeanList.size();


        }catch (NoBookRegisteredException | TitleCampRequiredException | WrongEmailFormattException |
                ErrorConnectionDbException | WrongCityInsertException e)
        {
            e.printStackTrace();
        }
        assertEquals(1,valueTest);
    }
}
