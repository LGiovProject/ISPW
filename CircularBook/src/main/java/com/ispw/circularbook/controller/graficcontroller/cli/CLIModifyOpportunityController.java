package com.ispw.circularbook.controller.graficcontroller.cli;

import com.ispw.circularbook.controller.appcontroller.InsertOpportunityController;
import com.ispw.circularbook.engineering.bean.OpportunityBean;
import com.ispw.circularbook.engineering.exception.*;
import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.engineering.utils.MessageSupport;
import com.ispw.circularbook.view.cli.CLIModifyMyOpportunityView;

import java.util.List;

public class CLIModifyOpportunityController {

    private final CLIManageMyOpportunityController cliManageMyOpportunityController;
    private final CLIModifyMyOpportunityView cliModifyMyOpportunityView;
    private final List<OpportunityBean> opportunityBeanList;
    private OpportunityBean opportunityBean;


    private static final String INSERT_TITLE ="1";
    private static final String INSERT_TYPE="2";
    private static final String INSERT_DATE_START="3";
    private static final String INSERT_DATE_FINISH="4";
    private static final String INSERT_DESCRIPTION="5";
    private static final String SAVE_UPDATE="6";
    private static final String ACTUALLY_VALUE="7";
    private static final String BACK="8";


    public CLIModifyOpportunityController(CLIManageMyOpportunityController cliManageMyOpportunityController, List<OpportunityBean> opportunityBeanList)
    {
        this.cliManageMyOpportunityController = cliManageMyOpportunityController;
        this.cliModifyMyOpportunityView = new CLIModifyMyOpportunityView(this);
        this.opportunityBeanList = opportunityBeanList;

    }

    public void start(int id)
    {
        try {
            opportunityBean = getOpportunityBean(opportunityBeanList, id);
            cliModifyMyOpportunityView.start();
            cliModifyMyOpportunityView.actuallyValue(opportunityBean);
        } catch (NoOpportunityFoundException e) {
            MessageSupport.cliExceptionSMessage(e.getMessage());
            cliManageMyOpportunityController.start();
        }
    }

    private void continueModify()
    {
        cliModifyMyOpportunityView.start();
    }

    public void command(String i) throws CommandNotFoundException {
        switch (i) {
            case INSERT_TITLE:
                cliModifyMyOpportunityView.insertTitle();
                break;
            case INSERT_TYPE:
                cliModifyMyOpportunityView.insertTypeOfOpportunity();
                break;
            case INSERT_DATE_START:
                cliModifyMyOpportunityView.insertDateStart();
                break;
            case INSERT_DATE_FINISH:
                cliModifyMyOpportunityView.insertDateFinish();
                break;
            case INSERT_DESCRIPTION:
                cliModifyMyOpportunityView.insertDescription();
                break;
            case SAVE_UPDATE:
                saveUpdate();
                break;
            case ACTUALLY_VALUE:
                cliModifyMyOpportunityView.actuallyValue(opportunityBean);
                continueModify();
                break;
            case BACK:
                goBack();
                break;
            default:
                throw new CommandNotFoundException();
        }
    }


    public void insertTitle(String title) throws TitleCampRequiredException {

        checkInput(title);
        opportunityBean.setTitle(title);
        continueModify();
    }

    public void insertType(int type)
    {

        checkInput(String.valueOf(type));
        opportunityBean.setTypeOfOpportunity(type);
        continueModify();
    }

    public void insertDescription(String description)
    {

        checkInput(description);
        opportunityBean.setDescription(description);
        continueModify();
    }

    public void insertDateStart(String dateStart) throws WrongDataFormatException {
        checkInput(dateStart);
        opportunityBean.setDateStart(dateStart);
        continueModify();
    }

    public void insertDateFinish(String dateFinish) throws WrongDataInsertException {

        checkInput(dateFinish);
        opportunityBean.setDateFinish(opportunityBean.getDateStartString(),dateFinish);
        continueModify();
    }

    public void saveUpdate()
    {
        opportunityBean.setEmail(Session.getCurrentSession().getBookShop().getEmail());
        InsertOpportunityController insertOpportunityController = new InsertOpportunityController();
        insertOpportunityController.updateOpportunity(opportunityBean);
    }

    private void checkInput(String i)
    {
        try {
            int command = Integer.parseInt(i);
            if (command == -1)
                continueModify();
        } catch (NumberFormatException e) {
            // Non è un comando numerico, prosegui normalmente
        }
    }

    private void goBack()
    {
        cliManageMyOpportunityController.start();
    }

    private OpportunityBean getOpportunityBean(List <OpportunityBean> opportunityBeanList, int id) throws NoOpportunityFoundException {

        for(OpportunityBean opportunity: opportunityBeanList)
        {
            if(opportunity.getId()==id)
                return opportunity;

        }
        throw new NoOpportunityFoundException();
    }
}
