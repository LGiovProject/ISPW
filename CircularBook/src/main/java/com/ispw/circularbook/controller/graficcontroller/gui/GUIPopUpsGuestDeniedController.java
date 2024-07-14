package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.Main;
import com.ispw.circularbook.engineering.session.Session;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Popup;

import java.io.IOException;

public class GUIPopUpsGuestDeniedController {

    private Popup popup;

    public void setPopup(Popup popup)
    {
        this.popup=popup;
    }

    public void close()
    {
        this.popup.hide();
    }

    public void goLogin() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Login.fxml"));
        Parent root = fxmlLoader.load();
        GUILoginController guiLoginController = fxmlLoader.getController();
        Scene scene = new Scene(root);
        guiLoginController.setCurrentScene(scene);
        Session.closeSession();
        this.popup.hide();
        Main.getStage().setScene(scene);
    }
}
