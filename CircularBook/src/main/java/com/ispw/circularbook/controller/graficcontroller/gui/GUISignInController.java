package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;



import java.io.IOException;

public class GUISignInController {

    private Scene currentScene;
    private Scene previuosScene;

    public void setCurrentScene(Scene currentScene) {
        this.currentScene = currentScene;
    }

    public void setPreviuosScene(Scene previuosScene) {
        this.previuosScene = previuosScene;
    }

    public void goSignInUser() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("SignInUserForm.fxml"));
        Parent root = fxmlLoader.load();
        GUISignInUserController guiSignInUserController= fxmlLoader.getController();
        Scene scene = new Scene(root);
        guiSignInUserController.startSignIn(previuosScene,currentScene);
        Main.getStage().setScene(scene);
    }

    public void goSignInBookShop() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("SignInBookShopForm.fxml"));
        Parent root = fxmlLoader.load();
        GUISignInBookShopController guiSignInBookShopController = fxmlLoader.getController();
        Scene scene = new Scene(root);
        guiSignInBookShopController.startSignIn(previuosScene,currentScene);
        Main.getStage().setScene(scene);
    }

    public void goBack(){
        Main.getStage().setScene(previuosScene);
    }


}
