package com.ispw.circularbook.controller.graficcontroller.gui;


import com.ispw.circularbook.engineering.bean.LoginBean;
import com.ispw.circularbook.engineering.facade.SceneFacade;
import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.engineering.state.gui.GUIHomepageState;
import com.ispw.circularbook.engineering.state.gui.GUIHomepageBookShopState;
import com.ispw.circularbook.engineering.state.gui.GUIHomepageUserState;
import com.ispw.circularbook.engineering.utils.MessageSupport;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import com.ispw.circularbook.Main;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.image.ImageView;
import javafx.scene.layout.*;


import java.io.IOException;




public class GUIHomepageController {

    @FXML
    private AnchorPane sideButton;
    @FXML
    private AnchorPane sideWindow;
    @FXML
    private ImageView bellNotify;

    private GUIHomepageState currentState;

    private Scene currentScene;

    public Scene getCurrentScene() {
        return currentScene;
    }

    public void setCurrentScene(Scene currentScene) {
        this.currentScene = currentScene;
    }

    //Metodo di lancio per l'homepage sia user che library, base al tipo di utente che effettua il login
    //carica la rispettiva homepage.

    public void setState(GUIHomepageState state)
    {
        this.currentState=state;
    }

    public void homePageStart(LoginBean loginBean) throws IOException {

        SceneFacade sceneFacade = new SceneFacade(sideWindow);
        Session.getCurrentSession().setSceneFacade(sceneFacade);


        if(loginBean.getType()==1)
            this.setState(new GUIHomepageUserState());
        else if (loginBean.getType()==2)
            this.setState(new GUIHomepageBookShopState());

        currentState.startHomepage(this);
    }

    public void setSideButton(Pane pane) {
        sideButton.getChildren().add(pane);
    }

    public void setSideWindow(Pane pane) {
        clearSideWindow();
        sideWindow.getChildren().add(pane);
    }

    public void clearSideWindow() {
        sideWindow.getChildren().clear();
    }

    public void logOut() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Login.fxml"));

        Parent root =fxmlLoader.load();
        GUILoginController guiLoginController = fxmlLoader.getController();
        Scene scene = new Scene(root);
        guiLoginController.setCurrentScene(scene);
        Main.getStage().setScene(scene);

        Session.closeSession();
    }

    public void setting() throws IOException {
        currentState.setting(this);
    }


    public void seeNotify(){

        MessageSupport.popUpsNotDevelopedMessage();

    }



}