package junit;

import com.ispw.circularbook.engineering.bean.RegistrationOpportunityBean;
import com.ispw.circularbook.engineering.exception.WrongDataFormatException;
import com.ispw.circularbook.engineering.exception.WrongDataInsertException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TestRegistrationOpportunityBeanController {

    /*
    * Questo test verifica se opportunityBean fa i controlli necessari affinchè non vanga inserita una data di fine evento/promozione
    * che sia precedente alla data dell'inizio dello stesso.
    * Il test viene passato se l'errore della data viene catturato e valueTest viene posto =-1
    */

    private static final String DATE_START="2024-07-20";
    private static final String DATE_FINISH="2024-07-19";



    @Test
    void opportunityBeanTest()
    {
        RegistrationOpportunityBean registrationOpportunityBean = new RegistrationOpportunityBean();
        int valueTest;
        try{
            registrationOpportunityBean.setDateStart(DATE_START);
            registrationOpportunityBean.setDateFinish(DATE_START,DATE_FINISH);
            valueTest=1;

        } catch (WrongDataFormatException | WrongDataInsertException e) {
            valueTest=-1;
        }

        assertEquals(-1,valueTest);
    }
}
