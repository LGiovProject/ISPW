package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.Main;
import com.ispw.circularbook.controller.appcontroller.SearchOpportunityController;
import com.ispw.circularbook.engineering.bean.ElementBean;
import com.ispw.circularbook.engineering.bean.OpportunityBean;
import com.ispw.circularbook.engineering.bean.SearchOpportunityBean;
import com.ispw.circularbook.engineering.enums.Month;
import com.ispw.circularbook.engineering.enums.TypeOfOpportunity;
import com.ispw.circularbook.engineering.exception.NoOpportunityFoundException;
import com.ispw.circularbook.engineering.utils.MessageSupport;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.NodeOrientation;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;


import java.io.IOException;
import java.util.List;

public class GUIResearchOpportunityController {

    @FXML
    VBox showResult;
    @FXML
    TextField bookShopName;
    @FXML
    ChoiceBox<TypeOfOpportunity> opportunityChoiceBox;
    @FXML
    ChoiceBox<Month> monthChoiceBox;
    @FXML
    ScrollPane scrollPane;

    private Pane currentPane;

    public void setCurrentPane(Pane currentPane){this.currentPane = currentPane;}

    public void startSetOpportunity()
    {

            monthChoiceBox.getItems().addAll(Month.values());
            monthChoiceBox.getSelectionModel().select(0);
            opportunityChoiceBox.getItems().addAll(TypeOfOpportunity.values());
            opportunityChoiceBox.getSelectionModel().select(0);
            scrollPane.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            scrollPane.setHvalue(scrollPane.getHmax());
            showResult.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);


    }
    public void startSearchOpportunity(){
        showResult.getChildren().clear();
        List<OpportunityBean> opportunityBeanList;
        SearchOpportunityBean searchOpportunityBean = new SearchOpportunityBean(bookShopName.getText(), monthChoiceBox.getSelectionModel().getSelectedItem(), opportunityChoiceBox.getSelectionModel().getSelectedItem());
        SearchOpportunityController searchOpportunityController = new SearchOpportunityController();
        try {
            opportunityBeanList = searchOpportunityController.searchOpportunity(searchOpportunityBean);
            this.setShowResult(opportunityBeanList);
        } catch (NoOpportunityFoundException e) {
            MessageSupport.popUpsExceptionMessage(e.getMessage());
        }

    }

    private void setShowResult(List<OpportunityBean> opportunityBeanList){

        for(OpportunityBean opportunityBean : opportunityBeanList)
        {
            ElementBean elementBean = new ElementBean(opportunityBean);
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("SearchedOpportunityItem.fxml"));
            Pane element = null;
            try {
                element = fxmlLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            GUISearchedOpportunityItemController guiSearchedOpportunityItemController = fxmlLoader.getController();
            guiSearchedOpportunityItemController.setOpportunityItem(elementBean);
            guiSearchedOpportunityItemController.setPreviuosPane(currentPane);
            showResult.getChildren().add(element);
        }
    }

    public void clearFieldText()
    {
            bookShopName.setText("");
            opportunityChoiceBox.getSelectionModel().select(0);
            monthChoiceBox.getSelectionModel().select(0);
    }


}
