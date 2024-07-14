package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.controller.appcontroller.InsertBookController;
import com.ispw.circularbook.engineering.bean.RegistrationBookBean;
import com.ispw.circularbook.engineering.enums.Arguments;
import com.ispw.circularbook.engineering.enums.TypeOfBook;
import com.ispw.circularbook.engineering.exception.TitleCampRequiredException;
import com.ispw.circularbook.engineering.utils.MessageSupport;
import com.ispw.circularbook.engineering.exception.WrongNpageFormatException;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class GUIInsertNewBookController {
    @FXML
    private TextField titleTField;
    @FXML
    private ChoiceBox<Arguments> argumentChBox;
    @FXML
    private TextField nPageTField;
    @FXML
    private TextField authorTField;
    @FXML
    private TextField publisherTField;
    @FXML
    private TextArea commentTArea;
    @FXML
    private RadioButton lendRadioButton;
    @FXML
    private RadioButton giftRadioButton;

    private String emailCurrentSession;
    private RegistrationBookBean registrationBookBean;
    private int accountType;


    public void startRegisterBook(String emailCurrentSession,int accountType)
    {
        registrationBookBean = new RegistrationBookBean();
        argumentChBox.getItems().addAll(Arguments.values());
        argumentChBox.getSelectionModel().select(1);
        argumentChBox.getItems().removeFirst();
        lendRadioButton.setSelected(true);
        this.emailCurrentSession=emailCurrentSession;
        this.accountType=accountType;
    }

    public void insertBook() {

        try {
            setRegistrationBookBean();
            InsertBookController insertBookController = new InsertBookController();
            insertBookController.insertBook(registrationBookBean);
            clearTextField();
            MessageSupport.popUpsSuccessMessage("Data entry successful");
        } catch (WrongNpageFormatException | TitleCampRequiredException e) {
            MessageSupport.popUpsExceptionMessage(e.getMessage());
        }


    }

    public TypeOfBook typeOfBook()
    {
        if(lendRadioButton.isSelected())
            return TypeOfBook.LEND;
        if(giftRadioButton.isSelected())
            return TypeOfBook.GIFT;
        return null;
    }

    private void clearTextField()
    {
        titleTField.setText("");
        argumentChBox.getSelectionModel().select(0);
        nPageTField.setText("");
        authorTField.setText("");
        commentTArea.setText("");
        publisherTField.setText("");
    }

    private void setRegistrationBookBean() throws WrongNpageFormatException, TitleCampRequiredException {
        registrationBookBean.setEmail(emailCurrentSession);
        registrationBookBean.setAccountType(accountType);
        registrationBookBean.setTypeOfBook(typeOfBook());
        registrationBookBean.setTitle(titleTField.getText());
        registrationBookBean.setAuthor(authorTField.getText());
        registrationBookBean.setArgument(argumentChBox.getSelectionModel().getSelectedItem());
        registrationBookBean.setPublisher(publisherTField.getText());
        registrationBookBean.setNPage(nPageTField.getText());
        registrationBookBean.setComment(commentTArea.getText());


    }


}
