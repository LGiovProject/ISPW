package junit;

import com.ispw.circularbook.controller.appcontroller.InsertBookController;
import com.ispw.circularbook.controller.appcontroller.SearchBookController;
import com.ispw.circularbook.engineering.bean.BookBean;
import com.ispw.circularbook.engineering.bean.RegistrationBookBean;
import com.ispw.circularbook.engineering.enums.Arguments;
import com.ispw.circularbook.engineering.enums.TypeOfBook;
import com.ispw.circularbook.engineering.exception.*;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TestInsertBookController {

private final String email ="testInsertBook@gmail.com";
    /*
    * Faccio prima un controllo su quanto è lunga la lista attuale di libri con l'utente scelto
    * dopodiche faccio l'inserimento del nuovo libro
    * il valore atteso è la lunghezza della lista prima dell'inserimento +1
    * Il test è passato se la lunghezza della lista dopo l'inserimento è uguale al valore atteso
    * */

    @Test
    void testInsertBookController()
    {
        try {

            InsertBookController insertBookController = new InsertBookController();
            SearchBookController searchBookController = new SearchBookController();
            RegistrationBookBean registrationBookBean = new RegistrationBookBean();

            List<BookBean> bookBeanListBefore=searchBookController.searchMyAvailableBook(email);
            int valueTest =bookBeanListBefore.size();





            registrationBookBean.setEmail(email);
            registrationBookBean.setTitle("title");
            registrationBookBean.setTypeOfBook(TypeOfBook.LEND);
            registrationBookBean.setAccountType(1);
            registrationBookBean.setAuthor("author");
            registrationBookBean.setArgument(Arguments.ADVENTURE);
            registrationBookBean.setPublisher("publisher");
            registrationBookBean.setNPage(0);
            registrationBookBean.setComment("comment");
            insertBookController.insertBook(registrationBookBean);

            List<BookBean> bookBeanList=searchBookController.searchMyAvailableBook(email);
            valueTest ++;
            assertEquals(valueTest,bookBeanList.size());

        }catch (NoBookRegisteredException | TitleCampRequiredException e)
        {
            e.printStackTrace();
        }

    }
}
