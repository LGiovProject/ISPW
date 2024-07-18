package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.Main;
import com.ispw.circularbook.controller.appcontroller.InsertOpportunityController;
import com.ispw.circularbook.engineering.bean.ElementBean;
import com.ispw.circularbook.engineering.bean.OpportunityBean;
import com.ispw.circularbook.engineering.observer.Observer;
import com.ispw.circularbook.engineering.observer.Subject;
import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.engineering.utils.MessageSupport;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GUIMyOpportunityItemController extends Subject {

    @FXML
    private Text title;
    @FXML
    private Text typeOfOpportunity;

    private OpportunityBean opportunityBean;

    private Pane element;

    private List<Observer> observers = new ArrayList<>();

    //La pane serve per moreInforSearch
    private Pane previuosPane;

    public void setPreviuosPane(Pane currentPane) {
        this.previuosPane = currentPane;
    }

    private Scene previousScene;

    public void setPreviousScene(Scene previousScene) {
        this.previousScene = previousScene;
    }


    public void setElementPersonal(ElementBean elementBean){
        this.opportunityBean =elementBean.getOpportunityBean();
        this.element= elementBean.getPane();
        this.title.setText(opportunityBean.getTitle());
        this.typeOfOpportunity.setText(opportunityBean.getTypeOfOpportunityString());
    }

    public void moreInfoSearch() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MoreInfoOpportunity.fxml"));
        Pane pane = fxmlLoader.load();
        ElementBean elementBean = new ElementBean(opportunityBean);
        GUIMoreInfoOpportunityController guiMoreInfoOpportunityController = fxmlLoader.getController();
        guiMoreInfoOpportunityController.setInfoOpportunity(elementBean);
        guiMoreInfoOpportunityController.setPreviousPane(this.previuosPane);
        Session.getCurrentSession().getSceneFacade().loadScene(pane);
    }

    public void modifyOpportunity() throws IOException {
        GUIModifyOpportunityController guiModifyopportunityController;
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ModifyMyOpportunityItem.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);
        Main.getStage().setScene(scene);
        guiModifyopportunityController =fxmlLoader.getController();

        ElementBean elementBean = new ElementBean(element, opportunityBean);
        guiModifyopportunityController.setPreviusScene(previousScene);
        guiModifyopportunityController.register(observers);
        guiModifyopportunityController.setElement(elementBean);



    }

    public void removeOpportunity(){
        InsertOpportunityController insertOpportunityController = new InsertOpportunityController();
        insertOpportunityController.removeOpportunity(opportunityBean.getId());
        notifyObserver(this.element);
        MessageSupport.popUpsSuccessMessage("The Opportunity is successfully removed");

    }


    @Override
    public void register(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void register(List<Observer> observers) {
        this.observers.addAll(observers);
    }

    @Override
    public void unregister(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObserver(Object element) {
        for(Observer observer : observers)
            observer.update(element);
    }

    @Override
    public void notifyObserver(Object opportunityBean, Object element) {
        for(Observer observer : observers)
            observer.update(opportunityBean,element);
    }
}
