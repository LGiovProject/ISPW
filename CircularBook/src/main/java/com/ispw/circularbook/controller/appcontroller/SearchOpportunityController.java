package com.ispw.circularbook.controller.appcontroller;

import com.ispw.circularbook.engineering.bean.OpportunityBean;
import com.ispw.circularbook.engineering.bean.SearchOpportunityBean;
import com.ispw.circularbook.engineering.dao.OpportunityDAO;
import com.ispw.circularbook.engineering.exception.NoOpportunityFoundException;
import com.ispw.circularbook.model.OpportunityModel;


import java.util.ArrayList;
import java.util.List;

    public class SearchOpportunityController {

    public List<OpportunityBean> searchOpportunity(SearchOpportunityBean searchOpportunityBean) throws NoOpportunityFoundException {

        List<OpportunityModel> opportunityModelList = OpportunityDAO.searchOpportunity(searchOpportunityBean.getNameLib(),searchOpportunityBean.getMonthString(),searchOpportunityBean.getTypeOfOpportunityString());

        List<OpportunityBean> opportunityBeans = new ArrayList<>();

        for(OpportunityModel opportunityModel : opportunityModelList)
        {
            opportunityBeans.add(getOpportunityBean(opportunityModel));
        }
        return opportunityBeans;
    }

    public List<OpportunityBean> searchOpportunity(String email) throws NoOpportunityFoundException {

        List<OpportunityBean> opportunityBeans = new ArrayList<>();

            List<OpportunityModel> opportunityModelList = OpportunityDAO.searchOpportunity(email);
            for(OpportunityModel opportunityModel : opportunityModelList)
            {
               opportunityBeans.add(getOpportunityBean(opportunityModel));
            }
            return opportunityBeans;
    }

    private OpportunityBean getOpportunityBean(OpportunityModel opportunityModel)
    {
        OpportunityBean opportunityBean = new OpportunityBean();

        opportunityBean.setId(opportunityModel.getId());
        opportunityBean.setTitle(opportunityModel.getTitle());
        opportunityBean.setEmail(opportunityModel.getBookShopModel().getEmail());
        opportunityBean.setNameBookShop(opportunityModel.getBookShopName());
        opportunityBean.setTypeOfOpportunity(opportunityModel.getTypeOfOpportunity());
        opportunityBean.setDescription(opportunityModel.getDescription());
        opportunityBean.setDateStart(opportunityModel.getDateStart());
        opportunityBean.setDateFinish(opportunityModel.getDateFinish());
        return opportunityBean;
    }
}
