package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.controller.appcontroller.InsertOpportunityController;
import com.ispw.circularbook.engineering.bean.RegistrationOpportunityBean;
import com.ispw.circularbook.engineering.enums.TypeOfOpportunity;
import com.ispw.circularbook.engineering.exception.TitleCampRequiredException;
import com.ispw.circularbook.engineering.exception.WrongDataFormatException;
import com.ispw.circularbook.engineering.exception.WrongDataInsertException;
import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.engineering.utils.MessageSupport;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.time.format.DateTimeFormatter;

public class GUIInsertOpportunityController {


    @FXML
    TextField title;
    @FXML
    TextArea description;
    @FXML
    DatePicker dateStart;
    @FXML
    DatePicker dateFinish;
    @FXML
    RadioButton promotionsRadioButton;
    @FXML
    RadioButton eventsRadioButton;

    private RegistrationOpportunityBean registrationOpportunityBean;

    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public void startSet()
    {
        registrationOpportunityBean = new RegistrationOpportunityBean();
        promotionsRadioButton.setSelected(true);
        eventsRadioButton.setSelected(false);

    }

    public void insertOpportunity()
    {
        try {
            setOpportunityBean();
            InsertOpportunityController insertOpportunityController = new InsertOpportunityController();
            MessageSupport.popUpsSuccessMessage("Data entry successful");
            insertOpportunityController.insertOpportunity(registrationOpportunityBean);
            clearCamp();
        } catch (WrongDataInsertException | TitleCampRequiredException | WrongDataFormatException e) {
            MessageSupport.popUpsExceptionMessage(e.getMessage());
        }
    }

    public TypeOfOpportunity typeOfOpportunity()
    {
        if(promotionsRadioButton.isSelected())
            return TypeOfOpportunity.PROMOTION;
        else if(eventsRadioButton.isSelected())
            return TypeOfOpportunity.EVENT;
        else
            return null;
    }

    private void clearCamp()
    {
        title.setText("");
        description.setText("");
        promotionsRadioButton.setSelected(true);
        eventsRadioButton.setSelected(false);
        dateStart.setValue(null);
        dateFinish.setValue(null);
    }

    private void setOpportunityBean() throws TitleCampRequiredException, WrongDataFormatException, WrongDataInsertException {

        registrationOpportunityBean.setEmail(Session.getCurrentSession().getBookShop().getEmail());
        registrationOpportunityBean.setTitle(title.getText());
        registrationOpportunityBean.setTypeOfOpportunity(typeOfOpportunity());
        registrationOpportunityBean.setDescription(description.getText());
        registrationOpportunityBean.setDateStart(dateStart.getValue());
        registrationOpportunityBean.setDateFinish(dateStart.getValue(),dateFinish.getValue());


    }

}
