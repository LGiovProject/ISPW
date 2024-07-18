package com.ispw.circularbook.engineering.utils;

import com.ispw.circularbook.engineering.bean.OpportunityBean;

import java.util.List;

public class CLIPrintOpportunitySupport {

    private CLIPrintOpportunitySupport(){}

    public static void showOpportunity(List<OpportunityBean> opportunityBeans)
    {
        for(OpportunityBean opportunityBean : opportunityBeans) {
            CLIMessageSupport.delimiterMessage();
            CLIMessageSupport.simpleMessage("Id :"+ opportunityBean.getId());
            CLIMessageSupport.simpleMessage("Title :" + opportunityBean.getTitle());
            CLIMessageSupport.simpleMessage("Type :" + opportunityBean.getTypeOfOpportunityString());
            CLIMessageSupport.simpleMessage("Date Start: " + opportunityBean.getDateStart());
            CLIMessageSupport.simpleMessage("Date finish: " + opportunityBean.getDateFinish());
            CLIMessageSupport.simpleMessage("Description :" + opportunityBean.getDescription());
            CLIMessageSupport.delimiterMessage();
        }
    }
}
