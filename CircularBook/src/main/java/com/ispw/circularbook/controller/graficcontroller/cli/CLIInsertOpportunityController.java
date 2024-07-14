package com.ispw.circularbook.controller.graficcontroller.cli;

import com.ispw.circularbook.controller.appcontroller.InsertOpportunityController;
import com.ispw.circularbook.engineering.bean.OpportunityBean;
import com.ispw.circularbook.engineering.exception.CommandNotFoundException;
import com.ispw.circularbook.engineering.exception.TitleCampRequiredException;
import com.ispw.circularbook.engineering.exception.WrongDataFormatException;
import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.engineering.utils.MessageSupport;
import com.ispw.circularbook.view.cli.CLIInsertOpportunityView;

public class CLIInsertOpportunityController {

    CLIInsertOpportunityView cliInsertOpportunityView;
    OpportunityBean opportunityBean;
    CLIHomepageController cliHomepageController;

    private static final String INSERT_DATA ="1";
    private static final String BACK="2";

    private static final String REGISTRATION_DATA ="1";


    public CLIInsertOpportunityController(CLIHomepageController cliHomepageController)
    {
        this.cliHomepageController= cliHomepageController;
        cliInsertOpportunityView = new CLIInsertOpportunityView(this);
        opportunityBean = new OpportunityBean();
    }

    public void start()
    {
        cliInsertOpportunityView.start();
    }

    public void insertAdData()
    {
        cliInsertOpportunityView.insertTitle();
        cliInsertOpportunityView.insertTypeOfOpportunity();
        cliInsertOpportunityView.insertDescription();
        cliInsertOpportunityView.insertDateStart();
        cliInsertOpportunityView.insertDateFinish();
        cliInsertOpportunityView.finish();
    }

    public void command(String i) throws CommandNotFoundException {
        switch (i)
        {
            case INSERT_DATA:
                insertAdData();
                break;
            case BACK:
                cliHomepageController.start();
                break;
            default:
                throw new CommandNotFoundException();


        }
    }


    public void finishCommand(String i) throws CommandNotFoundException {
        switch (i)
        {
            case REGISTRATION_DATA:
                registrationData();
                break;
            case BACK:
                cliHomepageController.start();
                break;
            default:
                throw new CommandNotFoundException();
        }
    }

    public void registrationData()
    {
        InsertOpportunityController insertOpportunityController = new InsertOpportunityController();
        opportunityBean.setEmail(Session.getCurrentSession().getBookShop().getEmail());
        insertOpportunityController.insertOpportunity(opportunityBean);
        MessageSupport.cliSuccessMessage("Data entry Successful");
        start();
    }

    public void insertTitle(String title) throws TitleCampRequiredException {
        checkInput(title);
        opportunityBean.setTitle(title);
    }

    public void insertTypeOfOpportunity(int typeOfOpportunity)
    {
        checkInput(String.valueOf(typeOfOpportunity));
        opportunityBean.setTypeOfOpportunity(typeOfOpportunity);
    }

    public void insertDescription(String description)
    {

        checkInput(description);
        opportunityBean.setDescription(description);
    }

    public void insertDateStart(String dateStart) throws WrongDataFormatException {

        checkInput(dateStart);
        opportunityBean.setDateStart(dateStart);

    }

    public void insertDateFinish(String dateFinish)
    {
        checkInput(dateFinish);
        opportunityBean.setDateFinish(dateFinish);
    }

    private void checkInput(String value)
    {
        try {
            int command = Integer.parseInt(value);
            if (command == -1)
                cliInsertOpportunityView.start();
        } catch (NumberFormatException e) {
            // Non è un comando numerico, prosegui normalmente
        }
    }

}
