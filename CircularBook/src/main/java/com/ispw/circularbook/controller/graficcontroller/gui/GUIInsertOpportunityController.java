package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.controller.appcontroller.InsertOpportunityController;
import com.ispw.circularbook.engineering.bean.OpportunityBean;
import com.ispw.circularbook.engineering.enums.TypeOfOpportunity;

import com.ispw.circularbook.engineering.exception.TitleCampRequiredException;
import com.ispw.circularbook.engineering.exception.WrongDataFormatException;
import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.engineering.utils.MessageSupport;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Callback;
import java.time.LocalDate;
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

    private OpportunityBean opportunityBean;

    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public void startSet()
    {
        opportunityBean = new OpportunityBean();
        dateStart.setDayCellFactory(getDayCellFactory(LocalDate.now()));
        dateStart.valueProperty().addListener((observable, oldValue, newValue) -> handleDateChange(newValue));

    }

    public void insertOpportunity()
    {
            setOpportunityBean();
            InsertOpportunityController insertOpportunityController = new InsertOpportunityController();
            insertOpportunityController.insertOpportunity(opportunityBean);
            clearCamp();

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
        promotionsRadioButton.setSelected(false);
        eventsRadioButton.setSelected(false);
        dateStart.setValue(null);
        dateFinish.setValue(null);
    }

    private Callback<DatePicker, DateCell> getDayCellFactory(LocalDate minDate) {
        return datePicker -> new DateCell() {
            @Override
            public void updateItem(LocalDate item, boolean empty) {
                super.updateItem(item, empty);

                if (item.isBefore(minDate)) {
                    setDisable(true);
                    setStyle("-fx-background-color: #ffc0cb;"); // Colore di sfondo per le date disabilitate
                }
            }
        };
    }

    private void handleDateChange(LocalDate newDate) {
        dateFinish.setDayCellFactory(getDayCellFactory(newDate));
    }

    private void setOpportunityBean()
    {
        try{
        opportunityBean.setEmail(Session.getCurrentSession().getBookShop().getEmail());
        opportunityBean.setTitle(title.getText());
        opportunityBean.setTypeOfOpportunity(typeOfOpportunity());
        opportunityBean.setDescription(description.getText());
        opportunityBean.setDateStart(dateStart.getValue().format(dateTimeFormatter));
        opportunityBean.setDateFinish(dateFinish.getValue().format(dateTimeFormatter));
        } catch (WrongDataFormatException | TitleCampRequiredException e) {
            MessageSupport.popUpsExceptionMessage(e.getMessage());
        }

    }

}
