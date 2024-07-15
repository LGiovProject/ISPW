package com.ispw.circularbook.controller.graficcontroller.cli;

import com.ispw.circularbook.controller.appcontroller.InsertOpportunityController;
import com.ispw.circularbook.controller.appcontroller.SearchOpportunityController;
import com.ispw.circularbook.engineering.bean.OpportunityBean;
import com.ispw.circularbook.engineering.exception.CommandNotFoundException;
import com.ispw.circularbook.engineering.exception.NoOpportunityFoundException;
import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.engineering.utils.CLIPrintOpportunitySupport;
import com.ispw.circularbook.engineering.utils.MessageSupport;
import com.ispw.circularbook.view.cli.CLIManageMyOpportunityView;

import java.util.List;

public class CLIManageMyOpportunityController {

    private final CLIManageMyOpportunityView cliManageMyopportunityView;
    private final CLIManageController cliManageController;
    private List<OpportunityBean> opportunityBeanList;
    private final SearchOpportunityController searchOpportunityController;


    private static final String MODIFY_OPPORTUNITY_INFO ="1";
    private static final String DELETE_OPPORTUNITY ="2";
    private static final String BACK="3";

    public CLIManageMyOpportunityController(CLIManageController cliManageController)
    {
        cliManageMyopportunityView = new CLIManageMyOpportunityView(this);
        this.cliManageController= cliManageController;
        this.searchOpportunityController =new SearchOpportunityController();
    }

    public void start()
    {
            try {
                opportunityBeanList = searchOpportunityController.searchOpportunity(Session.getCurrentSession().getBookShop().getEmail());
                CLIPrintOpportunitySupport.showOpportunity(opportunityBeanList);
                cliManageMyopportunityView.start();
            } catch (NoOpportunityFoundException e) {
                MessageSupport.cliExceptionSMessage(e.getMessage());
                cliManageController.start();
            }
    }


    public void command(String i) throws CommandNotFoundException {
        switch (i)
        {
            case MODIFY_OPPORTUNITY_INFO:
                cliManageMyopportunityView.modifyOpportunity();
                break;
            case DELETE_OPPORTUNITY:
                cliManageMyopportunityView.deleteOpportunity();
                break;
            case BACK:
                goBack();
                break;
            default:
                throw new CommandNotFoundException();
        }
    }


    public void modifyOpportunity(int id)
    {
        checkInput(id);
        CLIModifyOpportunityController cliModifyOpportunityController = new CLIModifyOpportunityController(this, opportunityBeanList);
        cliModifyOpportunityController.start(id);
    }

    public void deleteOpportunity(int id)
    {
        checkInput(id);
        InsertOpportunityController insertOpportunityController =new InsertOpportunityController();
        insertOpportunityController.removeOpportunity(id);
    }

    private void goBack()
    {
        cliManageController.start();
    }

    private void checkInput(int command)
    {
        if (command == -1)
            cliManageMyopportunityView.start();

    }
}
