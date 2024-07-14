package com.ispw.circularbook.engineering.state.gui;

import com.ispw.circularbook.Main;
import com.ispw.circularbook.controller.graficcontroller.gui.GUIHomepageController;
import com.ispw.circularbook.controller.graficcontroller.gui.GUIHomepageSideButtonBookShopController;
import com.ispw.circularbook.controller.graficcontroller.gui.GUISettingBookShopController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class GUIHomepageBookShopState implements GUIHomepageState {
    @Override
    public void startHomepage(GUIHomepageController context) throws IOException {
        FXMLLoader fxmlLoaderA = new FXMLLoader(Main.class.getResource("HomepageSideButtonBookShop.fxml"));
        Pane screenA = fxmlLoaderA.load();
        GUIHomepageSideButtonBookShopController guiHomepageSideButtonBookShopController = fxmlLoaderA.getController();
        FXMLLoader fxmlLoaderB = new FXMLLoader(Main.class.getResource("HomepageSideWindow.fxml"));
        Pane screenB = fxmlLoaderB.load();

        context.setSideButton(screenA);
        context.setSideWindow(screenB);

        guiHomepageSideButtonBookShopController.setPreviuosScene(context.getCurrentScene());
    }

    @Override
    public void setting(GUIHomepageController context) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("SettingBookShop.fxml"));
        Parent root =fxmlLoader.load();
        GUISettingBookShopController guiSettingBookShopController;
        guiSettingBookShopController =fxmlLoader.getController();
        guiSettingBookShopController.startSetting();
        guiSettingBookShopController.setPreviousScene(context.getCurrentScene());
        Scene scene = new Scene(root);
        Main.getStage().setScene(scene);
    }
}
