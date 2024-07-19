package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.Main;
import com.ispw.circularbook.controller.appcontroller.InsertOpportunityController;
import com.ispw.circularbook.engineering.bean.ElementBean;
import com.ispw.circularbook.engineering.bean.OpportunityBean;
import com.ispw.circularbook.engineering.bean.RegistrationOpportunityBean;
import com.ispw.circularbook.engineering.enums.TypeOfOpportunity;
import com.ispw.circularbook.engineering.exception.ModifyOperatorNotClosedException;
import com.ispw.circularbook.engineering.exception.TitleCampRequiredException;
import com.ispw.circularbook.engineering.exception.WrongDataFormatException;
import com.ispw.circularbook.engineering.exception.WrongDataInsertException;
import com.ispw.circularbook.engineering.observer.Observer;
import com.ispw.circularbook.engineering.observer.Subject;
import com.ispw.circularbook.engineering.utils.MessageSupport;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GUIModifyOpportunityController extends Subject {

    @FXML
    TextField title;
    @FXML
    DatePicker dateStart;
    @FXML
    DatePicker dateFinish;
    @FXML
    TextArea description;
    @FXML
    RadioButton promotion;
    @FXML
    RadioButton event;
    @FXML
    ImageView titleImageView;
    @FXML
    ImageView descriptionImageView;

    private List<Observer> observers = new ArrayList<>();

    private Pane panel;

    private Scene previusScene;

    private final Boolean[] rwField= {true,true};

    private OpportunityBean opportunityBean;

    private Image checkBoxImage;
    private Image pencilImage;
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static final String CHECK_BOX_IMAGE_PATH ="img/ConfirmModifyRed.png";

    public static final String PENCIL_IMAGE_PATH ="img/PencilModify.png";

    public static final String ON_STYLE="fx-border-color: black;-fx-background-color:white;  -fx-background-radius: 40,40,40,40; -fx-text-fill: #4D0E0E";

    public static final String OFF_STYLE ="fx-border: none; -fx-background-color:none;";

    public static final String TEXT_AREA_STYLE_ON ="text-area-background: white ;";

    public static final String TEXT_AREA_STYLE_OFF ="text-area-background: #F1C9A0 ;";


    public void setPreviusScene(Scene scene){previusScene=scene;}

    public void setElement(ElementBean elementBean)
    {
        opportunityBean =elementBean.getOpportunityBean();
        panel=elementBean.getPane();
        title.setEditable(false);
        description.setEditable(false);
        title.setText(opportunityBean.getTitle());
        description.setText(opportunityBean.getDescription());
        setTypeOfDisponibility(opportunityBean.getTypeOfOpportunityInt());
        dateStart.setValue(opportunityBean.getDateStart());
        dateFinish.setValue(opportunityBean.getDateFinish());
    }

    public TypeOfOpportunity getTypeOfOpportunity() {
        if(this.event.isSelected())
        {
            return TypeOfOpportunity.EVENT;
        }
        else if(this.promotion.isSelected())
        {
            return TypeOfOpportunity.PROMOTION;
        }
        return null;
    }

    public void applyModify(){
        try {
            checkEdit();
            InsertOpportunityController insertOpportunityController = new InsertOpportunityController();
            RegistrationOpportunityBean registrationOpportunityBeanTemp = new RegistrationOpportunityBean();
            registrationOpportunityBeanTemp.setId(opportunityBean.getId());
            registrationOpportunityBeanTemp.setTitle(title.getText());
            registrationOpportunityBeanTemp.setDescription(description.getText());
            registrationOpportunityBeanTemp.setTypeOfOpportunity(getTypeOfOpportunity());
            registrationOpportunityBeanTemp.setDateStart(dateStart.getValue().format(dateTimeFormatter));
            registrationOpportunityBeanTemp.setDateFinish(dateStart.getValue().format(dateTimeFormatter),dateFinish.getValue().format(dateTimeFormatter));
            insertOpportunityController.updateOpportunity(registrationOpportunityBeanTemp);

            opportunityBean.setTitle(title.getText());
            opportunityBean.setDescription(description.getText());
            opportunityBean.setTypeOfOpportunity(getTypeOfOpportunity());
            opportunityBean.setDateStart(dateStart.getValue());
            opportunityBean.setDateFinish(dateFinish.getValue());

            notifyObserver(opportunityBean,panel);
            backButton();
        } catch (WrongDataFormatException | ModifyOperatorNotClosedException | TitleCampRequiredException |
                 WrongDataInsertException e) {
            MessageSupport.popUpsExceptionMessage(e.getMessage());
        }

    }

    public void rewriteField(ActionEvent event) throws IOException {

        checkBoxImage= new Image(Objects.requireNonNull(Main.class.getResource(CHECK_BOX_IMAGE_PATH)).openStream());
        pencilImage = new Image(Objects.requireNonNull(Main.class.getResource(PENCIL_IMAGE_PATH)).openStream());
        Button btn= (Button)event.getSource();
        String string=btn.getId();

        switch (string) {

            case "titleButton":
                editTitle();
                break;

            case "descriptionButton":
                editComment();
                break;

            default:
        }
    }

    public void backButton() {
        Main.getStage().setScene(this.previusScene);
    }



    private void setTypeOfDisponibility(int typeOfDisponibility) {
        if(typeOfDisponibility==2)
        {
            this.promotion.setSelected(true);
            this.event.setSelected(false);
        }
        else
        {
            this.event.setSelected(true);
            this.promotion.setSelected(false);
        }
    }


    private void setBoolean(int i, boolean value)
    {
        rwField[i]=value;
    }
    private boolean getBoolean(int i)
    {
        return rwField[i];
    }

    private void editTitle() {
        if (getBoolean(0)) {
            title.setEditable(true);
            title.setStyle(ON_STYLE);
            titleImageView.setImage(checkBoxImage);
            setBoolean(0,false);

        }else
        {
            title.setEditable(false);
            title.setStyle(OFF_STYLE);
            titleImageView.setImage(pencilImage);
            title.setText(title.getText());
            setBoolean(0,true);
        }
    }

    private void editComment() {
        if(getBoolean(1))
        {
            description.setEditable(true);
            description.setStyle(TEXT_AREA_STYLE_ON);
            descriptionImageView.setImage(checkBoxImage);
            setBoolean(1,false);
        }else
        {
            description.setEditable(false);
            description.setStyle(TEXT_AREA_STYLE_OFF);
            descriptionImageView.setImage(pencilImage);
            description.setText(description.getText());
            setBoolean(1,true);
        }
    }

    private void checkEdit() throws ModifyOperatorNotClosedException {
        for (Boolean aBoolean : rwField)
            if (Boolean.FALSE.equals(aBoolean))
                throw new ModifyOperatorNotClosedException();
    }

    @Override
    public void register(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void register(List<Observer> observers) {
        this.observers.addAll(observers);
    }

    @Override
    public void unregister(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObserver(Object element) {
        for(Observer observer : observers)
            observer.update(element);
    }

    @Override
    public void notifyObserver(Object opportunityBean, Object element) {
        for(Observer observer : observers)
            observer.update(opportunityBean,element);
    }

}
