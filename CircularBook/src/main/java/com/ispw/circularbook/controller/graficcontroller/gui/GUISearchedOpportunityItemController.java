package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.Main;
import com.ispw.circularbook.engineering.bean.ElementBean;
import com.ispw.circularbook.engineering.bean.OpportunityBean;
import com.ispw.circularbook.engineering.session.Session;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.io.IOException;

public class GUISearchedOpportunityItemController {

    @FXML
    private Text title;
    @FXML
    private Text nameLib;
    @FXML
    private Text typologie;

    private Pane previuosPane;

    public Pane getPreviuosPane() {
        return previuosPane;
    }

    public void setPreviuosPane(Pane currentPane) {
        this.previuosPane = currentPane;
    }

    private OpportunityBean opportunityBean;



    public void setOpportunityItem(ElementBean elementBean)
    {

       opportunityBean = elementBean.getOpportunityBean();
       title.setText(opportunityBean.getTitle());
       nameLib.setText(opportunityBean.getNameBookShop());
       typologie.setText(opportunityBean.getTypeOfOpportunityString());


    }

    public void moreInfo() throws IOException {
        ElementBean elementBean =new  ElementBean(opportunityBean);
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MoreInfoOpportunity.fxml"));
        Pane pane = fxmlLoader.load();
        GUIMoreInfoOpportunityController guiMoreInfoOpportunityController = fxmlLoader.getController();
        guiMoreInfoOpportunityController.setInfoOpportunity(elementBean);
        guiMoreInfoOpportunityController.setPreviousPane(this.previuosPane);
        Session.getCurrentSession().getSceneFacade().loadScene(pane);
    }

}
