package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.Main;
import com.ispw.circularbook.controller.appcontroller.SignInController;
import com.ispw.circularbook.engineering.bean.SignInBean;
import com.ispw.circularbook.engineering.enums.City;
import com.ispw.circularbook.engineering.exception.*;
import com.ispw.circularbook.engineering.utils.MessageSupport;
import com.mysql.cj.util.StringUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class GUISignInBookShopController {

    @FXML
    private TextField emailTField;
    @FXML
    private PasswordField passwordTField;
    @FXML
    private PasswordField repasswordTField;
    @FXML
    private TextField nomeLTField;
    @FXML
    private TextField viaTField;
    @FXML
    private ChoiceBox<City> choiceBoxCity;
    @FXML
    private TextField nTelTField;
    @FXML
    Text showPassword;
    @FXML
    Text showRePassword;

    @FXML
    private ImageView padlock;
    @FXML
    private ImageView padlockR;




    private Scene loginScene;
    private Scene previousScene;

    private static final String PATH_PADLOCK="src/main/resources/com/ispw/circularbook/img/padunlock.png";
    private static final String PATH_PADUNLOCK="src/main/resources/com/ispw/circularbook/img/padlock.png";

    public void startSignIn(Scene loginScene, Scene previousScene)
    {
        choiceBoxCity.getItems().addAll(City.values());
        choiceBoxCity.getSelectionModel().select(0);
        choiceBoxCity.getItems().removeFirst();
        this.setLoginScene(loginScene);
        this.setPreviousScene(previousScene);
    }

    //Creo una istanza di SignInBean
    //E lancio il metodo SignIn di signInController, dopodiche riporto l'utente sulla schermata login
    public void signIn() throws IOException {

        try {
            SignInController signInController = new SignInController();
            checkPassword(this.passwordTField.getText(),this.repasswordTField.getText());
            checkCity(this.choiceBoxCity.getSelectionModel().getSelectedItem());

            SignInBean signInBean = new SignInBean(emailTField.getText(),passwordTField.getText(),nomeLTField.getText(),viaTField.getText(),choiceBoxCity.getSelectionModel().getSelectedItem(),nTelTField.getText());
            signInController.checkMail(emailTField.getText());
            signInController.signInL(signInBean);

            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Login.fxml"));

            Parent root = fxmlLoader.load();

            Scene scene = new Scene(root);

            Main.getStage().setScene(scene);

            MessageSupport.popUpsSuccessMessage("Data entry successful");


        }catch (NoMatchPasswordException | WrongEmailFormattException | WrongNPhoneFormatException |
                PasswordCampRequiredException | CityCampRequiredException | EmailUsedException e)
        {
            MessageSupport.popUpsExceptionMessage(e.getMessage());
        }catch (IOException e)
        {
           e.printStackTrace();
        }

    }

    public void goToLogin(){
        Main.getStage().setScene(loginScene);
    }

    public void goBack()
    {
        Main.getStage().setScene(previousScene);
    }


    public void showPassword() throws FileNotFoundException {
        showPassword.setVisible(true);
        showPassword.setText(passwordTField.getText());
        showPassword.setOpacity(0.5);
        FileInputStream input = new FileInputStream(PATH_PADUNLOCK);
        Image image = new Image(input);
        padlock.setImage(image);
    }
    public void hiddenPassword() throws FileNotFoundException {
        showPassword.setVisible(false);
        showPassword.setText("");
        FileInputStream input = new FileInputStream(PATH_PADLOCK);
        Image image = new Image(input);
        padlock.setImage(image);

    }
    public void showRePassword() throws FileNotFoundException {
        showRePassword.setVisible(true);
        showRePassword.setText(repasswordTField.getText());
        showRePassword.setOpacity(0.5);
        FileInputStream input = new FileInputStream(PATH_PADUNLOCK);
        Image image = new Image(input);
        padlockR.setImage(image);
    }
    public void hiddenRePassword() throws FileNotFoundException {
        showRePassword.setVisible(false);
        showRePassword.setText("");
        FileInputStream input = new FileInputStream(PATH_PADLOCK);
        Image image = new Image(input);
        padlockR.setImage(image);
    }

    public void setLoginScene(Scene loginScene) {
        this.loginScene = loginScene;
    }

    public void setPreviousScene(Scene previousScene){
        this.previousScene = previousScene;
    }


    private void checkPassword(String password,String repassword) throws PasswordCampRequiredException, NoMatchPasswordException {
        if(StringUtils.isEmptyOrWhitespaceOnly(password))
            throw new PasswordCampRequiredException();

        if(!password.equals(repassword))
            throw new NoMatchPasswordException();

    }

    private void checkCity(City city) throws CityCampRequiredException {
        if(city==City.ANY)
            throw new CityCampRequiredException();
    }
}
