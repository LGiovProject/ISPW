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


public class GUISignInUserController {

    @FXML
    private TextField emailTField;
    @FXML
    private PasswordField passwordTField;
    @FXML
    private PasswordField rePasswordTField;
    @FXML
    private TextField nameTField;
    @FXML
    private TextField surnameTField;
    @FXML
    private TextField usernameTField;
    @FXML
    private ChoiceBox<City> choiceBoxCity;

    @FXML
    private ImageView padlock;
    @FXML
    private ImageView padlockR;

    @FXML
    Text showPassword;
    @FXML
    Text showRePassword;



    private Scene loginScene;
    private Scene previousScene;

    private static final String PATH_PADLOCK="src/main/resources/com/ispw/circularbook/img/padunlock.png";
    private static final String PATH_PADUNLOCK="src/main/resources/com/ispw/circularbook/img/padlock.png";

    public void startSignIn(Scene currentScene, Scene previousScene)
    {
        choiceBoxCity.getItems().addAll(City.values());
        choiceBoxCity.getSelectionModel().select(0);
        this.setLoginScene(currentScene);
        this.setPreviousScene(previousScene);
    }



    public void signIn(){

        try{
            SignInController signInController = new SignInController();
            checkPassword(this.passwordTField.getText(),this.rePasswordTField.getText());
            checkCity(this.choiceBoxCity.getSelectionModel().getSelectedItem());

            SignInBean signInBean = new SignInBean(emailTField.getText(),usernameTField.getText(),passwordTField.getText(), nameTField.getText(), this.surnameTField.getText(), this.choiceBoxCity.getSelectionModel().getSelectedItem());
            signInController.checkMail(emailTField.getText());

            signInController.signInU(signInBean);

            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Login.fxml"));

            Parent root = fxmlLoader.load();

            Scene scene = new Scene(root);

            Main.getStage().setScene(scene);

            MessageSupport.popUpsSuccessMessage("Data entry successful");

        }catch (NoMatchPasswordException | WrongEmailFormattException | PasswordCampRequiredException |
                CityCampRequiredException | EmailUsedException e )
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
        showRePassword.setText(rePasswordTField.getText());
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
