package com.ispw.circularbook.engineering.utils;

import com.ispw.circularbook.Main;
import com.ispw.circularbook.controller.graficcontroller.gui.GUIPopUpsExceptionController;
import com.ispw.circularbook.controller.graficcontroller.gui.GUIPopUpsGuestDeniedController;
import javafx.fxml.FXMLLoader;

import javafx.scene.control.Label;

import javafx.stage.Popup;

import java.io.IOException;


public class MessageSupport {


    private static final String POP_UPS_MESSAGE="PopUpsMessage.fxml";


    private MessageSupport(){}

    public static void popUpsExceptionMessage(String message){
         try {
             FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(POP_UPS_MESSAGE));
             Popup popup = new Popup();
             Label label = fxmlLoader.load();
             GUIPopUpsExceptionController guiPopUpsExceptionController = fxmlLoader.getController();
             guiPopUpsExceptionController.setPopup(popup,message);
             popup.getContent().add(label);
             popup.setAutoHide(true);
             popup.show(Main.getStage());

         }catch (IOException e){
             e.printStackTrace();
         }
     }

    public static void popUpsNotDevelopedMessage()
    {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(POP_UPS_MESSAGE));
            Popup popup = new Popup();
            Label label = fxmlLoader.load();
            GUIPopUpsExceptionController guiPopUpsExceptionController = fxmlLoader.getController();
            guiPopUpsExceptionController.setPopup(popup,"Not developed yet");
            popup.getContent().add(label);
            popup.setAutoHide(true);
            popup.show(Main.getStage());

        }catch (IOException e){
            e.printStackTrace();
        }
    }

     public static void popUpsSuccessMessage(String message){
         try {
             FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(POP_UPS_MESSAGE));
             Popup popup = new Popup();
             Label label = fxmlLoader.load();
             GUIPopUpsExceptionController guiPopUpsExceptionController = fxmlLoader.getController();
             guiPopUpsExceptionController.setPopup(popup,message);
             popup.getContent().add(label);
             popup.setAutoHide(true);
             popup.show(Main.getStage());

         }catch (IOException e){
             e.printStackTrace();
         }
     }

     public static void popUpsGuestDeniedMessage(){
         try {
             FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("PopUpsGuestDenied.fxml"));
             Popup popup = new Popup();
             Label label = fxmlLoader.load();
             GUIPopUpsGuestDeniedController guiPopUpsGuestDeniedController = fxmlLoader.getController();
             guiPopUpsGuestDeniedController.setPopup(popup);
             popup.getContent().add(label);
             popup.setAutoHide(true);
             popup.show(Main.getStage());

         }catch (IOException e){
             e.printStackTrace();
         }
     }


     public static void cliExceptionSMessage(String exception){
         cliDelimiterException();
         CLIMessageSupport.simpleMessage(exception);
         cliDelimiterException();
     }

     public static void cliDaniedAccesMessage()
     {
         CLIMessageSupport.delimiterMessage();
         CLIMessageSupport.simpleMessage("Serve aver fatto il login per eseguire questa operazione!");
         CLIMessageSupport.delimiterMessage();
     }

     public static void cliSuccessMessage(String success){
         CLIMessageSupport.delimiterMessage();
         CLIMessageSupport.simpleMessage(success);
         CLIMessageSupport.delimiterMessage();

     }

     private static void cliDelimiterException()
     {
         CLIMessageSupport.simpleMessage("\n*********************Exception*********************\n");
     }





}
