package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.Main;
import com.ispw.circularbook.engineering.bean.LoginBean;
import com.ispw.circularbook.engineering.utils.MessageSupport;
import com.ispw.circularbook.engineering.exception.WrongEmailFormattException;
import com.ispw.circularbook.controller.appcontroller.LoginController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import java.io.IOException;
import java.util.Objects;


public class GUILoginController {

    @FXML
    private TextField textFieldEmail;
    @FXML
    private PasswordField textFieldPassword;
    @FXML
    private Text showPassword;
    @FXML
    private ImageView padlock;

    private Scene currentScene;


    public void login() throws IOException {
        try {
            LoginBean loginBean = new LoginBean(this.textFieldPassword.getText(), this.textFieldEmail.getText());
            LoginController loginController = new LoginController();
            loginController.checkLogin(loginBean);
            if (loginBean.getType() == 1) {

                loginController.setUserSession(loginBean);
                this.lunchHomepage(loginBean);

            } else if (loginBean.getType() == 2) {

                loginController.setBookShopSession(loginBean);
                this.lunchHomepage(loginBean);

            } else {
                MessageSupport.popUpsExceptionMessage("Email or password are incorrect");
            }

        } catch (WrongEmailFormattException e) {
            MessageSupport.popUpsExceptionMessage(e.getMessage());
        }
    }


    public void signIn() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("SignIn.fxml"));
        Parent root = fxmlLoader.load();
        GUISignInController guiSignInController = fxmlLoader.getController();
        Scene scene = new Scene(root);
        guiSignInController.setCurrentScene(scene);
        guiSignInController.setPreviuosScene(currentScene);
        Main.getStage().setScene(scene);
    }

    //Metodo che carica l'homepage e lancia il metodo per l'avvio del suo controller
    public void lunchHomepage(LoginBean loginBean) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Homepage.fxml"));


        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);

        GUIHomepageController guiHomepageController = fxmlLoader.getController();
        guiHomepageController.setCurrentScene(scene);
        guiHomepageController.homePageStart(loginBean);

        Main.getStage().setScene(scene);
    }

    public void accessGuest() throws IOException {
        LoginController loginController = new LoginController();
        this.lunchHomepage(loginController.setGuestSession());


    }

    public void googleAccess()
    {
        MessageSupport.popUpsNotDevelopedMessage();
    }

    public void showPassword() throws IOException {
        showPassword.setVisible(true);
        showPassword.setText(textFieldPassword.getText());
        showPassword.setOpacity(0.5);
        Image image = new Image(Objects.requireNonNull(Main.class.getResource("img/padunlock.png")).openStream());
        padlock.setImage(image);
    }
    public void hiddenPassword() throws IOException {
        Image image = new Image(Objects.requireNonNull(Main.class.getResource("img/padlock.png")).openStream());
        padlock.setImage(image);
        showPassword.setVisible(false);
        showPassword.setText("");
    }

    public void setCurrentScene(Scene currentScene) {
        this.currentScene = currentScene;
    }

}
