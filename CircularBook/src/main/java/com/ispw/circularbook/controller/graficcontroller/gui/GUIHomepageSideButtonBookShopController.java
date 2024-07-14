package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.Main;
import com.ispw.circularbook.engineering.session.Session;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class GUIHomepageSideButtonBookShopController {





    private Scene previuosScene;

    public void setPreviuosScene(Scene previuosScene) {
        this.previuosScene = previuosScene;
    }

    public void insertOpportunity() throws IOException {

        FXMLLoader fxmlLoader= new FXMLLoader(Main.class.getResource("InsertOpportunityForm.fxml"));
        Pane pane= fxmlLoader.load();
        GUIInsertOpportunityController guiInsertOpportunityController = fxmlLoader.getController();
        guiInsertOpportunityController.startSet();
        Session.getCurrentSession().getSceneFacade().loadScene(pane);
    }

    public void insertNewBook() throws IOException {

        FXMLLoader fxmlLoader= new FXMLLoader(Main.class.getResource("InsertBookForm.fxml"));
        Pane pane= fxmlLoader.load();
        GUIInsertNewBookController guiInsertNewBookController = fxmlLoader.getController();
        guiInsertNewBookController.startRegisterBook(Session.getCurrentSession().getBookShop().getEmail(),2);
        Session.getCurrentSession().getSceneFacade().loadScene(pane);


    }

    public void goToLibrary() throws IOException {

        FXMLLoader fxmlLoader= new FXMLLoader(Main.class.getResource("ManageBookShopLibrary.fxml"));
        Pane pane= fxmlLoader.load();
        GUIManageBookShopLibraryController guiManageBookShopLibraryController = fxmlLoader.getController();
        guiManageBookShopLibraryController.setPreviuosScene(previuosScene);
        guiManageBookShopLibraryController.setCurrentPane(pane);
        Session.getCurrentSession().getSceneFacade().loadScene(pane);

    }
}
