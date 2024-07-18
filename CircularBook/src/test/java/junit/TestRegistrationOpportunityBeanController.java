package junit;

import com.ispw.circularbook.engineering.bean.registrationOpportunityBean;
import com.ispw.circularbook.engineering.exception.WrongDataFormatException;
import com.ispw.circularbook.engineering.exception.WrongDataInsertException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TestRegistrationOpportunityBeanController {

    /*
    * Questo test verifica se opportunityBean fa i controlli necessari affinchè non vanga inserita una data di fine evento/promozione
    * che sia precedente alla data dell'inizio dello stesso.
    *
    */

    private static final String DATE_START="2024-07-20";
    private static final String DATE_FINISH="2024-07-21";



    @Test
    void opportunityBeanTest()
    {
        registrationOpportunityBean registrationOpportunityBean = new registrationOpportunityBean();
        int valueTest;
        try{
            registrationOpportunityBean.setDateStart(DATE_START);
            registrationOpportunityBean.setDateFinish(DATE_START,DATE_FINISH);
            valueTest=1;

        } catch (WrongDataFormatException | WrongDataInsertException e) {
            valueTest=-1;
        }

        assertEquals(1,valueTest);
    }
}
