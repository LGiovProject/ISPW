package com.ispw.circularbook.controller.appcontroller;

import com.ispw.circularbook.engineering.bean.RegistrationOpportunityBean;
import com.ispw.circularbook.engineering.dao.OpportunityDAO;
import com.ispw.circularbook.model.BookShopModel;
import com.ispw.circularbook.model.OpportunityModel;

public class InsertOpportunityController {
    public void insertOpportunity(RegistrationOpportunityBean registrationOpportunityBean){


        OpportunityModel opportunityModel = new OpportunityModel();
        BookShopModel bookShopModel = new BookShopModel(registrationOpportunityBean.getEmail());
        opportunityModel.setBookShopModel(bookShopModel);
        opportunityModel.setTitle(registrationOpportunityBean.getTitle());
        opportunityModel.setTypeOfOpportunity(registrationOpportunityBean.getTypeOfOpportunityInt());
        opportunityModel.setDescription(registrationOpportunityBean.getDescription());
        opportunityModel.setDateStart(registrationOpportunityBean.getDateStartString());
        opportunityModel.setDateFinish(registrationOpportunityBean.getDateFinishString());
        OpportunityDAO.insertOpportunity(opportunityModel);
    }

    public void updateOpportunity(RegistrationOpportunityBean registrationOpportunityBean){
        OpportunityModel opportunityModel = new OpportunityModel();
        opportunityModel.setId(registrationOpportunityBean.getId());
        opportunityModel.setTitle(registrationOpportunityBean.getTitle());
        opportunityModel.setTypeOfOpportunity(registrationOpportunityBean.getTypeOfOpportunityInt());
        opportunityModel.setDescription(registrationOpportunityBean.getDescription());
        opportunityModel.setDateStart(registrationOpportunityBean.getDateStartString());
        opportunityModel.setDateFinish(registrationOpportunityBean.getDateFinishString());
        OpportunityDAO.updateOpportunity(opportunityModel);}

    public void removeOpportunity(int id){
        OpportunityDAO.removeOpportunity(id);
    }

}
