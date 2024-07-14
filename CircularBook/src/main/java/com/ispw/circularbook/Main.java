package com.ispw.circularbook;

import com.ispw.circularbook.controller.graficcontroller.cli.CLILoginController;
import com.ispw.circularbook.controller.graficcontroller.gui.GUILoginController;
import com.ispw.circularbook.engineering.utils.CLIMessageSupport;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.ispw.circularbook.engineering.connection.ConnectionDB;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main extends Application {

    private static Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        setStage(stage);
        stage.setResizable(false);
        stage.setTitle("Circular Book");
        stage.setScene(scene);
        GUILoginController guiLoginController = fxmlLoader.getController();
        guiLoginController.setCurrentScene(scene);
        stage.show();


    }
    @Override
    public void stop() throws SQLException {
        ConnectionDB.closeConnection();
    }

    public static void main(String[] args) throws Exception {
        ConnectionDB.getConnection();
        Scanner reader = new Scanner(System.in);
        int selection;
        CLIMessageSupport.titleMessage("Which type of view do you want to use?");
        CLIMessageSupport.simpleMessage("1) Graphic interface");
        CLIMessageSupport.simpleMessage("2) Command Line interface");
        CLIMessageSupport.simpleMessage("Insert the number:");

        boolean flag = true;
        while (flag) {
            selection = reader.nextInt();
            switch (selection) {
                case 1:
                    launch();
                    flag=false;
                    break;
                case 2:
                    CLILoginController cliLoginController = new CLILoginController();
                    cliLoginController.start();
                    flag=false;
                    break;
                default:
                    CLIMessageSupport.simpleMessage("Number not valid, please insert 1 or 2");

            }
        }
    }

    public static void setStage(Stage stage){Main.stage=stage;}

    public static Stage getStage(){ return stage;}
}



