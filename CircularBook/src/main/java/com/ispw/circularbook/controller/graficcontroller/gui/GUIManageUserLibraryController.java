package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.Main;
import com.ispw.circularbook.controller.appcontroller.SearchBookController;
import com.ispw.circularbook.engineering.bean.BookBean;
import com.ispw.circularbook.engineering.exception.NoBookRegisteredException;
import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.engineering.exception.NoBookLendedException;
import com.ispw.circularbook.engineering.utils.MessageSupport;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.io.IOException;

import java.util.List;

public class GUIManageUserLibraryController {


    GUIManageLibraryWindowController guiManageLibraryWindowController;

    private Scene previuosScene;
    private  Pane currentPane;

    private String email;

    public GUIManageUserLibraryController()
    {
        email = Session.getCurrentSession().getUser().getEmail();
    }

    public void setCurrentPane(Pane currentPane) {
        this.currentPane = currentPane;
    }

    public void setPreviuosScene(Scene previuosScene) {
        this.previuosScene = previuosScene;
    }

    public void searchMyBook() throws IOException {
        List<BookBean> bookBeanList;
        SearchBookController searchBookController = new SearchBookController();
        try {
            bookBeanList = searchBookController.searchMyAvailableBook(email);
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

    public void researchMyTokenBook() throws IOException {
        List<BookBean> bookBeanList;
        SearchBookController searchBookController = new SearchBookController();
        try {
            bookBeanList = searchBookController.searchMyTakenBook(email);
            FXMLLoader fxmlLoader = getWindowElement();
            Pane pane = fxmlLoader.load();

            Session.getCurrentSession().getSceneFacade().loadScene(pane);
            guiManageLibraryWindowController = fxmlLoader.getController();
            guiManageLibraryWindowController.setCurrentPane(pane);
            guiManageLibraryWindowController.setPreviuosScene(previuosScene);
            guiManageLibraryWindowController.setPreviuosPane(currentPane);
            guiManageLibraryWindowController.viewMyLendedBook(bookBeanList);
        } catch (NoBookLendedException e) {
            MessageSupport.popUpsExceptionMessage(e.getMessage());
        }





    }

    public void researchMyGivenBook() throws IOException {
        List<BookBean> bookBeanList;
        SearchBookController searchBookController = new SearchBookController();
        try {
            bookBeanList = searchBookController.searchMyGivenBook(email);
            FXMLLoader fxmlLoader = getWindowElement();
            Pane pane = fxmlLoader.load();
            Session.getCurrentSession().getSceneFacade().loadScene(pane);
            guiManageLibraryWindowController = fxmlLoader.getController();
            guiManageLibraryWindowController.setCurrentPane(pane);
            guiManageLibraryWindowController.setPreviuosScene(previuosScene);
            guiManageLibraryWindowController.setPreviuosPane(currentPane);
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
