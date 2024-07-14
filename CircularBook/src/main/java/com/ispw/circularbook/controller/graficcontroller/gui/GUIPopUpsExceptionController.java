package com.ispw.circularbook.controller.graficcontroller.gui;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.stage.Popup;

public class GUIPopUpsExceptionController {

    private Popup popup;
    @FXML
    private Text textException;

    public void setPopup(Popup popup, String message)
    {
        this.textException.setText(message);
        this.popup=popup;
    }

    public void close()
    {
        this.popup.hide();
    }
}
