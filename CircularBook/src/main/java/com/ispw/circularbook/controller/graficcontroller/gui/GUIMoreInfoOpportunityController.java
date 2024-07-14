package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.engineering.bean.ElementBean;
import com.ispw.circularbook.engineering.bean.OpportunityBean;
import com.ispw.circularbook.engineering.session.Session;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;



public class GUIMoreInfoOpportunityController {
    @FXML
    Text title;
    @FXML
    Text bookShop;
    @FXML
    Text typology;
    @FXML
    Text dateStart;
    @FXML
    Text dateFinish;
    @FXML
    TextArea description;

    OpportunityBean opportunityBean;

    private Pane previousPane;

    public void setPreviousPane(Pane previousPane)
    {
        this.previousPane = previousPane;
    }

    public void setInfoOpportunity(ElementBean elementBean)
    {
        opportunityBean = elementBean.getOpportunityBean();
        title.setText(opportunityBean.getTitle());
        bookShop.setText(opportunityBean.getNameBookShop());
        typology.setText(opportunityBean.getTypeOfOpportunityString());
        dateStart.setText(opportunityBean.getDateStartString());
        dateFinish.setText(opportunityBean.getDateFinishString());
        description.setText(opportunityBean.getDescription());
    }

    public void backButton(){

        Session.getCurrentSession().getSceneFacade().loadScene(previousPane);

    }

}
