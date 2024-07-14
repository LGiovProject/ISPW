package com.ispw.circularbook.engineering.utils;

import com.ispw.circularbook.engineering.bean.OpportunityBean;

import java.util.List;

public class CLIPrintOpportunitySupport {

    private CLIPrintOpportunitySupport(){}

    public static void showOpportunity(List<OpportunityBean> opportunityBeanList)
    {
        for(OpportunityBean opportunityBean : opportunityBeanList) {
            CLIMessageSupport.delimiterMessage();
            CLIMessageSupport.simpleMessage("Titolo :" + opportunityBean.getTitle());
            CLIMessageSupport.simpleMessage("Tipologia :" + opportunityBean.getTypeOfOpportunityString());
            CLIMessageSupport.simpleMessage("Libreria: " + opportunityBean.getNameBookShop());
            CLIMessageSupport.simpleMessage("Data inizio: " + opportunityBean.getDateStart());
            CLIMessageSupport.simpleMessage("Data fine: " + opportunityBean.getDateFinish());
            CLIMessageSupport.simpleMessage("Descrizione :" + opportunityBean.getDescription());
            CLIMessageSupport.delimiterMessage();
        }
    }
}
