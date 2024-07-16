package junit;

import com.ispw.circularbook.engineering.bean.OpportunityBean;
import com.ispw.circularbook.engineering.exception.WrongDataFormatException;
import com.ispw.circularbook.engineering.exception.WrongDataInsertException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TestOpportunityBeanController {

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
        OpportunityBean opportunityBean = new OpportunityBean();
        int valueTest;
        try{
            opportunityBean.setDateStart(DATE_START);
            opportunityBean.setDateFinish(DATE_START,DATE_FINISH);
            valueTest=1;

        } catch (WrongDataFormatException | WrongDataInsertException e) {
            valueTest=-1;
        }

        assertEquals(1,valueTest);
    }
}
