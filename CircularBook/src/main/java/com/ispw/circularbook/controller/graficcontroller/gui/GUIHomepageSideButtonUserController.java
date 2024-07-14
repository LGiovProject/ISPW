package com.ispw.circularbook.controller.graficcontroller.gui;


import com.ispw.circularbook.engineering.exception.AccountRequiredException;
import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.engineering.utils.MessageSupport;
import javafx.fxml.FXMLLoader;
import com.ispw.circularbook.Main;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import java.io.IOException;


public class GUIHomepageSideButtonUserController {


    private Scene previuosScene;

    public void setPreviuosScene(Scene previuosScene) {
        this.previuosScene = previuosScene;
    }

    public void insertNewBook() throws IOException {
        try {

            if(Session.getCurrentSession().getUser().isGuest())
                throw new AccountRequiredException();

            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("InsertBookForm.fxml"));
            Pane pane = fxmlLoader.load();
            GUIInsertNewBookController guiInsertNewBookController = fxmlLoader.getController();
            guiInsertNewBookController.startRegisterBook(Session.getCurrentSession().getUser().getEmail(),1);
            Session.getCurrentSession().getSceneFacade().loadScene(pane);

        } catch (AccountRequiredException e) {
            MessageSupport.popUpsGuestDeniedMessage();
        }

    }

    public void searchOpportunity() throws IOException {
        FXMLLoader fxmlLoader= new FXMLLoader(Main.class.getResource("ResearchOpportunity.fxml"));
        Pane pane= fxmlLoader.load();
        GUIResearchOpportunityController guiResearchOpportunityController = fxmlLoader.getController();
        guiResearchOpportunityController.startSetOpportunity();
        guiResearchOpportunityController.setCurrentPane(pane);
        Session.getCurrentSession().getSceneFacade().loadScene(pane);
    }

    public void searchBook() throws IOException {
        FXMLLoader fxmlLoader= new FXMLLoader(Main.class.getResource("ResearchBook.fxml"));
        Pane pane= fxmlLoader.load();
        GUIResearchBookController guiResearchBookController = fxmlLoader.getController();
        guiResearchBookController.setSearch();
        guiResearchBookController.setCurrentPane(pane);
        Session.getCurrentSession().getSceneFacade().loadScene(pane);

    }

    public void goToLibrary() throws IOException{
       try {
           if (Session.getCurrentSession().getUser().isGuest())
               throw new AccountRequiredException();
           FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ManageUserLibrary.fxml"));
           Pane pane = fxmlLoader.load();
           GUIManageUserLibraryController guiManageUserLibraryController = fxmlLoader.getController();
           guiManageUserLibraryController.setPreviuosScene(previuosScene);
           guiManageUserLibraryController.setCurrentPane(pane);
           Session.getCurrentSession().getSceneFacade().loadScene(pane);
       }catch (AccountRequiredException e)
       {
           MessageSupport.popUpsGuestDeniedMessage();
       }

    }




}
