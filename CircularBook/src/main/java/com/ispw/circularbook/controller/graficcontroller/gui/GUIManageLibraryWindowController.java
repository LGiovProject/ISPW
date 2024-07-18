package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.Main;
import com.ispw.circularbook.engineering.bean.BookBean;
import com.ispw.circularbook.engineering.bean.ElementBean;
import com.ispw.circularbook.engineering.bean.OpportunityBean;
import com.ispw.circularbook.engineering.observer.Observer;
import com.ispw.circularbook.engineering.session.Session;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.NodeOrientation;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import java.io.IOException;
import java.util.List;

public class GUIManageLibraryWindowController implements Observer{
    @FXML
    VBox viewMyBook;
    @FXML
    ScrollPane scrollPane;

    private Pane currentPane;

    private Pane previuosPane;

    public void setCurrentPane(Pane currentPane)
    {
        this.currentPane= currentPane;
    }
    public void setPreviuosPane(Pane previuosPane){this.previuosPane=previuosPane;}

    private Scene previuosScene;

    public void setPreviuosScene(Scene previuosScene) {
        this.previuosScene = previuosScene;
    }

    public void viewBook(List<BookBean> bookBeanList) throws IOException {
        this.viewInitialization();
        for (BookBean bookBean : bookBeanList) {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MyBookItem.fxml"));
            Pane element = fxmlLoader.load();
            GUIMyBookAvailableItemController guiMyBookAvailableItemController = fxmlLoader.getController();
            ElementBean elementBean = new ElementBean(element,bookBean);
            guiMyBookAvailableItemController.setBookElement(elementBean);
            guiMyBookAvailableItemController.setPreviuosPane(currentPane);
            guiMyBookAvailableItemController.register(this);
            guiMyBookAvailableItemController.setCurrentScene(previuosScene);
            viewMyBook.getChildren().add(element);
        }
    }

    public void viewOpportunity(List<OpportunityBean> opportunityBeans) throws IOException{

        this.viewInitialization();

        for(OpportunityBean opportunityBean : opportunityBeans){
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MyOpportunityItem.fxml"));
            Pane element = fxmlLoader.load();
            GUIMyOpportunityItemController guiMyOpportunityItemController = fxmlLoader.getController();
            ElementBean elementBean = new ElementBean(element, opportunityBean);
            guiMyOpportunityItemController.setPreviousScene(previuosScene);
            guiMyOpportunityItemController.setPreviuosPane(currentPane);
            guiMyOpportunityItemController.setElementPersonal(elementBean);
            guiMyOpportunityItemController.register(this);
            viewMyBook.getChildren().add(element);
        }

    }

    public void viewMyLendedBook(List<BookBean> bookBeanList) throws IOException {

        this.viewInitialization();


        for (BookBean bookBean : bookBeanList) {
            ElementBean elementBean = new ElementBean(bookBean);

            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MyBookTakedItem.fxml"));
            Pane element = fxmlLoader.load();
            GUIMyTakedBookItemController guiMyTakedBookItemController = fxmlLoader.getController();
            guiMyTakedBookItemController.startSetElementTakedBook(elementBean);
            viewMyBook.getChildren().add(element);
        }


    }

    public void viewMyGivenBook(List<BookBean> bookBeanList) throws IOException {
        this.viewInitialization();

        for (BookBean bookBean : bookBeanList) {
            ElementBean elementBean = new ElementBean(bookBean);
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MyBookGivenItem.fxml"));
            Pane element = fxmlLoader.load();
            GUIMyGivenBookItemController guiMyGivenBookItemController = fxmlLoader.getController();
            guiMyGivenBookItemController.startSetElementGivenBook(elementBean);
            viewMyBook.getChildren().add(element);
        }
    }

    public void backButton() {
        Session.getCurrentSession().getSceneFacade().loadScene(previuosPane);
    }

    @Override
    public void update(Object object) {
        viewMyBook.getChildren().remove(viewMyBook.getChildren().indexOf(object));
    }

    public void update(Object bean, Object object)
    {
        int index=viewMyBook.getChildren().indexOf(object);
        viewMyBook.getChildren().remove(index);
        ElementBean elementBean;
        Pane element=null;
        try {
            if(bean instanceof OpportunityBean opportunityBean) {
                FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MyOpportunityItem.fxml"));
                element = fxmlLoader.load();
                GUIMyOpportunityItemController guiMyOpportunityItemController = fxmlLoader.getController();
                elementBean = new ElementBean(element, opportunityBean);
                guiMyOpportunityItemController.setElementPersonal(elementBean);
                guiMyOpportunityItemController.setPreviousScene(previuosScene);
                guiMyOpportunityItemController.setPreviuosPane(currentPane);
                guiMyOpportunityItemController.register(this);
            }

            else{
                FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MyBookItem.fxml"));
                element = fxmlLoader.load();
                GUIMyBookAvailableItemController guiMyBookAvailableItemController = fxmlLoader.getController();
                BookBean bookBean = (BookBean)bean;
                elementBean = new ElementBean(element, bookBean);
                guiMyBookAvailableItemController.setBookElement(elementBean);
                guiMyBookAvailableItemController.setCurrentScene(previuosScene);
                guiMyBookAvailableItemController.setPreviuosPane(currentPane);
                guiMyBookAvailableItemController.register(this);
            }
        }catch (IOException e)
        {
            e.printStackTrace();
        }
        viewMyBook.getChildren().add(index,element);
    }


    private void viewInitialization(){
        viewMyBook.getChildren().clear();
        scrollPane.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        scrollPane.setHvalue(scrollPane.getHmax());
        viewMyBook.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
    }
}


