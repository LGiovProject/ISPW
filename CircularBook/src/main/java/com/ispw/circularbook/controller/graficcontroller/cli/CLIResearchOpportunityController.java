package com.ispw.circularbook.controller.graficcontroller.cli;

import com.ispw.circularbook.controller.appcontroller.SearchOpportunityController;
import com.ispw.circularbook.engineering.bean.OpportunityBean;
import com.ispw.circularbook.engineering.bean.SearchOpportunityBean;
import com.ispw.circularbook.engineering.enums.Month;
import com.ispw.circularbook.engineering.enums.TypeOfOpportunity;
import com.ispw.circularbook.engineering.exception.CommandNotFoundException;
import com.ispw.circularbook.engineering.exception.NoOpportunityFoundException;
import com.ispw.circularbook.engineering.utils.CLIPrintOpportunitySupport;
import com.ispw.circularbook.engineering.utils.MessageSupport;

import com.ispw.circularbook.view.cli.CLISearchOpportunityView;


import java.util.List;

public class CLIResearchOpportunityController {

    private final CLIHomepageController cliHomepageController;
    private final SearchOpportunityBean searchOpportunityBean;
    private final CLISearchOpportunityView cliSearchOpportunityView;

    private static final String INSERT_BOOKSHOP_NAME ="1";
    private static final String INSERT_MONTH="2";
    private static final String INSERT_TYPE="3";
    private static final String SEARCH_OPPORTUNITY ="4";
    private static final String CLEAN_PARAMETERS="5";
    private static final String SHOW_PARAMETERS="6";
    private static final String BACK="7";

    public CLIResearchOpportunityController(CLIHomepageController cliHomepageController) {
        this.cliHomepageController = cliHomepageController;
        cliSearchOpportunityView = new CLISearchOpportunityView(this);
        searchOpportunityBean = new SearchOpportunityBean("", Month.CERCA_IN_TUTTI_I_MESI, TypeOfOpportunity.ANY);
    }

    public void start()
    {
        cliSearchOpportunityView.start();
    }

    public void command(String i) throws CommandNotFoundException {
        switch (i)
        {
            case INSERT_BOOKSHOP_NAME:
                cliSearchOpportunityView.insertBookShopName();
                break;
            case INSERT_MONTH:
                cliSearchOpportunityView.insertMonth();
                break;
            case INSERT_TYPE:
                cliSearchOpportunityView.insertTypologyInsertion();
                break;
            case SEARCH_OPPORTUNITY:
                searchOpportunity();
                break;
            case CLEAN_PARAMETERS:
                cleanParameters();
                break;
            case SHOW_PARAMETERS:
                cliSearchOpportunityView.searchParameters(searchOpportunityBean);
                cliSearchOpportunityView.start();
                break;
            case BACK:
                goBack();
                break;
            default:
                throw new CommandNotFoundException();
        }
    }

    public void insertBookShopName(String name)
    {

        searchOpportunityBean.setNameLib(name);
        start();
    }

    public void insertMonth(String month)
    {

        searchOpportunityBean.setMonth(month);
        start();
    }

    public void insertTypologyInsertion(String type)
    {
        searchOpportunityBean.setTypeOfOpportunity(type);
        start();
    }

    public void searchOpportunity()
    {
        List<OpportunityBean> opportunityBeanList;
        SearchOpportunityController searchOpportunityController = new SearchOpportunityController();
        try {
            opportunityBeanList = searchOpportunityController.searchOpportunity(searchOpportunityBean);
            CLIPrintOpportunitySupport.showOpportunity(opportunityBeanList);
            start();
        } catch (NoOpportunityFoundException e) {
            MessageSupport.cliExceptionSMessage(e.getMessage());
            start();
        }

    }

    private void cleanParameters()
    {
        searchOpportunityBean.setNameLib("");
        searchOpportunityBean.setMonth(Month.CERCA_IN_TUTTI_I_MESI);
        searchOpportunityBean.setTypeOfOpportunity(TypeOfOpportunity.ANY);
        start();
    }


    private void goBack()
    {
        cliHomepageController.start();
    }




}
