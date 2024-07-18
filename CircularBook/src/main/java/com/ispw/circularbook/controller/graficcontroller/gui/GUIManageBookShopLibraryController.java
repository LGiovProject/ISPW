package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.Main;
import com.ispw.circularbook.controller.appcontroller.SearchBookController;
import com.ispw.circularbook.controller.appcontroller.SearchOpportunityController;
import com.ispw.circularbook.engineering.bean.BookBean;
import com.ispw.circularbook.engineering.bean.OpportunityBean;
import com.ispw.circularbook.engineering.exception.*;
import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.engineering.utils.MessageSupport;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.List;

public class GUIManageBookShopLibraryController {


    GUIManageLibraryWindowController guiManageLibraryWindowController;

    private Scene previuosScene;
    private Pane currentPane;

    public void setPreviuosScene(Scene previuosScene) {
        this.previuosScene = previuosScene;
    }
    public void setCurrentPane(Pane currentPane){this.currentPane=currentPane;}
    public void searchMyBook() throws IOException{
        List<BookBean> bookBeanList;
        SearchBookController searchBookController = new SearchBookController();
        try {
            bookBeanList = searchBookController.searchMyAvailableBook(Session.getCurrentSession().getBookShop().getEmail());
            FXMLLoader fxmlLoader = getWindowElement();
            Pane pane = fxmlLoader.load();
            Session.getCurrentSession().getSceneFacade().loadScene(pane);
            guiManageLibraryWindowController = fxmlLoader.getController();
            guiManageLibraryWindowController.setCurrentPane(pane);
            guiManageLibraryWindowController.setPreviuosScene(previuosScene);
            guiManageLibraryWindowController.setPreviuosPane(currentPane);
            guiManageLibraryWindowController.viewBook(bookBeanList);

        } catch (NoBookRegisteredException e) {
            MessageSupport.popUpsExceptionMessage(e.getMessage());
        }

    }

    public void searchMyOpportunity(){
        List<OpportunityBean> opportunityBeans;
        SearchOpportunityController searchOpportunityController = new SearchOpportunityController();
        try {
            opportunityBeans = searchOpportunityController.searchOpportunity(Session.getCurrentSession().getBookShop().getEmail());
            FXMLLoader fxmlLoader = getWindowElement();
            Pane pane = fxmlLoader.load();
            Session.getCurrentSession().getSceneFacade().loadScene(pane);
            guiManageLibraryWindowController = fxmlLoader.getController();
            guiManageLibraryWindowController.setCurrentPane(pane);
            guiManageLibraryWindowController.setPreviuosScene(previuosScene);
            guiManageLibraryWindowController.setPreviuosPane(currentPane);
            guiManageLibraryWindowController.viewOpportunity(opportunityBeans);

        } catch (NoOpportunityFoundException e) {
            MessageSupport.popUpsExceptionMessage(e.getMessage());
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }


    public void searchBookGiven() throws IOException {
        List<BookBean> bookBeanList;
        SearchBookController searchBookController = new SearchBookController();
        try {
            bookBeanList = searchBookController.searchMyGivenBook(Session.getCurrentSession().getBookShop().getEmail());
            FXMLLoader fxmlLoader = getWindowElement();
            Pane pane = fxmlLoader.load();
            Session.getCurrentSession().getSceneFacade().loadScene(pane);
            guiManageLibraryWindowController = fxmlLoader.getController();
            guiManageLibraryWindowController.setPreviuosScene(previuosScene);
            guiManageLibraryWindowController.setPreviuosPane(currentPane);
            guiManageLibraryWindowController.setCurrentPane(pane);
            guiManageLibraryWindowController.viewMyGivenBook(bookBeanList);
        }catch (NoBookLendedException e){
            MessageSupport.popUpsExceptionMessage(e.getMessage());
        }
    }

    private FXMLLoader getWindowElement()
    {
            return new FXMLLoader(Main.class.getResource("MangeLibraryWindow.fxml"));
    }


}
