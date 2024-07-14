package com.ispw.circularbook.engineering.state.gui;

import com.ispw.circularbook.Main;
import com.ispw.circularbook.controller.graficcontroller.gui.GUIHomepageController;
import com.ispw.circularbook.controller.graficcontroller.gui.GUIHomepageSideButtonUserController;
import com.ispw.circularbook.controller.graficcontroller.gui.GUISettingUserController;
import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.engineering.utils.MessageSupport;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class GUIHomepageUserState implements GUIHomepageState {
    @Override
    public void startHomepage(GUIHomepageController context) throws IOException {
        FXMLLoader fxmlLoaderA = new FXMLLoader(Main.class.getResource("HomepageSideButtonUser.fxml"));
        Pane screenA = fxmlLoaderA.load();
        GUIHomepageSideButtonUserController guiHomepageSideButtonUserController = fxmlLoaderA.getController();
        FXMLLoader fxmlLoaderB = new FXMLLoader(Main.class.getResource("HomepageSideWindow.fxml"));
        Pane screenB = fxmlLoaderB.load();

        context.setSideButton(screenA);
        context.setSideWindow(screenB);
        guiHomepageSideButtonUserController.setPreviuosScene(context.getCurrentScene());
    }

    @Override
    public void setting(GUIHomepageController context) throws IOException {
            if(Session.getCurrentSession().getUser().isGuest())
                MessageSupport.popUpsGuestDeniedMessage();
            else {
                FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("SettingUser.fxml"));
                GUISettingUserController guiSettingUserController;
                Parent root = fxmlLoader.load();
                guiSettingUserController = fxmlLoader.getController();
                guiSettingUserController.startSetting();
                guiSettingUserController.setPreviousScene(context.getCurrentScene());
                Scene scene = new Scene(root);
                Main.getStage().setScene(scene);
            }
    }
}
