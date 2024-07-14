package com.ispw.circularbook.controller.appcontroller;

import com.ispw.circularbook.engineering.bean.OpportunityBean;
import com.ispw.circularbook.engineering.dao.OpportunityDAO;
import com.ispw.circularbook.model.BookShopModel;
import com.ispw.circularbook.model.OpportunityModel;

public class InsertOpportunityController {
    public void insertOpportunity(OpportunityBean opportunityBean){


        OpportunityModel opportunityModel = new OpportunityModel();
        BookShopModel bookShopModel = new BookShopModel(opportunityBean.getEmail());
        opportunityModel.setBookShopModel(bookShopModel);
        opportunityModel.setTitle(opportunityBean.getTitle());
        opportunityModel.setTypeOfOpportunity(opportunityBean.getTypeOfOpportunityInt());
        opportunityModel.setDescription(opportunityBean.getDescription());
        opportunityModel.setDateStart(opportunityBean.getDateStartString());
        opportunityModel.setDateFinish(opportunityBean.getDateFinishString());
        OpportunityDAO.insertOpportunity(opportunityModel);
    }

    public void updateOpportunity(OpportunityBean opportunityBean){
        OpportunityModel opportunityModel = new OpportunityModel();
        opportunityModel.setId(opportunityBean.getId());
        opportunityModel.setTitle(opportunityBean.getTitle());
        opportunityModel.setTypeOfOpportunity(opportunityBean.getTypeOfOpportunityInt());
        opportunityModel.setDescription(opportunityBean.getDescription());
        opportunityModel.setDateStart(opportunityBean.getDateStartString());
        opportunityModel.setDateFinish(opportunityBean.getDateFinishString());
        OpportunityDAO.updateOpportunity(opportunityModel);}

    public void removeOpportunity(int id){
        OpportunityDAO.removeOpportunity(id);
    }

}
