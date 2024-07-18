package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.Main;
import com.ispw.circularbook.controller.appcontroller.InsertBookController;
import com.ispw.circularbook.engineering.bean.BookBean;
import com.ispw.circularbook.engineering.bean.ElementBean;
import com.ispw.circularbook.engineering.enums.Arguments;
import com.ispw.circularbook.engineering.exception.ModifyOperatorNotClosedException;
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
import javafx.scene.text.Text;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GUIModifyBookController extends Subject {
    @FXML
    TextField title;
    @FXML
    TextField author;
    @FXML
    Text argument;
    @FXML
    TextField nPage;
    @FXML
    TextField publisher;
    @FXML
    TextArea comment;
    @FXML
    TextField typeOfDisponibility;
    @FXML
    RadioButton gifted;
    @FXML
    RadioButton lended;
    @FXML
    ImageView titleImageView;
    @FXML
    ImageView authorImageView;
    @FXML
    ImageView publisherImageView;
    @FXML
    ImageView argumentImageView;
    @FXML
    ImageView nPageImageView;
    @FXML
    ImageView commentImageView;
    @FXML
    ChoiceBox<Arguments> argumentChoiceBox;

    private Pane panel;

    private BookBean bookBean;

    private final Boolean[] rwField= {true,true,true,true,true,true};

    private final List<Observer> observers = new ArrayList<>();

    private Scene previusScene;

    private Image checkBoxImage;
    private Image pencilImage;

    public static final String CHECK_BOX_IMAGE_PATH ="img/ConfirmModifyRed.png";

    public static final String PENCIL_IMAGE_PATH ="img/PencilModify.png";

    public static final String ON_STYLE="fx-border-color: black;-fx-background-color:white;  -fx-background-radius: 40,40,40,40; -fx-text-fill: #4D0E0E";

    public static final String OFF_STYLE ="fx-border: none; -fx-background-color:none;";

    public static final String TEXT_AREA_STYLE_ON ="text-area-background: white ;";

    public static final String TEXT_AREA_STYLE_OFF ="text-area-background: #F1C9A0 ;";

    public void setPreviusScene(Scene currentScene) {
        this.previusScene = currentScene;
    }

    public void setElement(ElementBean elementBean){
        bookBean = elementBean.getBookBean();
        panel= elementBean.getPane();
        title.setEditable(false);
        publisher.setEditable(false);
        author.setEditable(false);
        nPage.setEditable(false);
        comment.setEditable(false);
        title.setText(bookBean.getTitle());
        author.setText(bookBean.getAuthor());
        publisher.setText(bookBean.getPublisher());
        argument.setText(bookBean.getArgumentString());
        nPage.setText(bookBean.getNPageString());
        comment.setText(bookBean.getComment());
        typeOfDisponibility.setText(bookBean.getTypeOfDisponibilityString());
        setTypeOfDisponibility(bookBean.getTypeOfBookInt());
        argumentChoiceBox.getItems().addAll(Arguments.values());
        argumentChoiceBox.getItems().removeFirst();
        argumentChoiceBox.getSelectionModel().select(bookBean.getArgument());
        argumentChoiceBox.getItems().removeFirst();
        argumentChoiceBox.setVisible(false);
    }


    public void applyModify(){
        try {
            checkEdit();
            InsertBookController insertBookController = new InsertBookController();
            BookBean bookBeanTemp = new BookBean();
            bookBeanTemp.setId(bookBean.getId());
            bookBeanTemp.setEmail(bookBean.getEmail());
            bookBeanTemp.setTypeOfBook(getTypeOfDisponibility());
            bookBeanTemp.setTitle(title.getText());
            bookBeanTemp.setAuthor(author.getText());
            bookBeanTemp.setPublisher(publisher.getText());
            bookBeanTemp.setArgument(argumentChoiceBox.getSelectionModel().getSelectedItem());
            bookBeanTemp.setNPage(nPage.getText());
            bookBeanTemp.setComment(comment.getText());
            insertBookController.updateBook(bookBeanTemp);
            notifyObserver(bookBeanTemp,panel);
            backButton();
        } catch (ModifyOperatorNotClosedException e) {
            MessageSupport.popUpsExceptionMessage(e.getMessage());
        }
    }

    public int getTypeOfDisponibility(){
        if(this.gifted.isSelected())
        {
            return 2;
        }
        else if(this.lended.isSelected())
        {
            return 1;
        }
        return 0;
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
            case "authorButton":
                editAuthor();
                break;
            case "publisherButton":
                editPublisher();
                break;
            case "argumentButton":
                editArgument();
                break;
            case "nPageButton":
                editNPage();
                break;
            case "commentButton":
                editComment();
                break;

            default:


        }
    }

    public void backButton() {
        Main.getStage().setScene(previusScene);
    }

    private void setTypeOfDisponibility(int typeOfDisponibility){
        if(typeOfDisponibility==1)
        {
            this.lended.setSelected(true);
            this.gifted.setSelected(false);
        }
        else
        {
            this.gifted.setSelected(true);
            this.lended.setSelected(false);
        }
    }

    @Override
    public void register(Observer observer) {
        this.observers.add(observer);
    }

    public void register(List<Observer> observers)
    {
        this.observers.addAll(observers);
    }

    @Override
    public void unregister(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObserver(Object object) {
            for (Observer observer : observers)
                observer.update(object);
    }

    @Override
    public void notifyObserver(Object bookBean, Object element) {
        for(Observer observer : observers)
            observer.update(bookBean,element);
    }

    private void editTitle(){
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

    private void editAuthor(){
        if(getBoolean(1))
        {
            author.setEditable(true);
            author.setStyle(ON_STYLE);
            authorImageView.setImage(checkBoxImage);

            setBoolean(1,false);
        }else
        {
            author.setEditable(false);
            author.setStyle(OFF_STYLE);
            authorImageView.setImage(pencilImage);
            author.setText(author.getText());
            setBoolean(1,true);
        }
    }

    private void editArgument(){
        if(getBoolean(2))
        {
            argumentChoiceBox.setVisible(true);
            argumentImageView.setImage(checkBoxImage);
            setBoolean(2,false);
        }else
        {

            argumentImageView.setImage(pencilImage);
            argument.setText(argumentChoiceBox.getSelectionModel().getSelectedItem().getArgument());
            argumentChoiceBox.setVisible(false);
            setBoolean(2,true);
        }
    }

    private void editPublisher()
    {
        if(getBoolean(3))
        {
            publisher.setEditable(true);
            publisher.setStyle(ON_STYLE);
            publisherImageView.setImage(checkBoxImage);
            setBoolean(3,false);
        }else
        {
            publisher.setEditable(false);
            publisher.setStyle(OFF_STYLE);
            publisherImageView.setImage(pencilImage);
            setBoolean(3,true);
        }
    }

    private void editNPage(){
        if(getBoolean(4))
        {
            nPage.setEditable(true);
            nPage.setStyle(ON_STYLE);
            nPageImageView.setImage(checkBoxImage);
            setBoolean(4,false);
        }else
        {
            nPage.setEditable(false);
            nPage.setStyle(OFF_STYLE);
            nPageImageView.setImage(pencilImage);
            nPage.setText(nPage.getText());
            setBoolean(4,true);
        }
    }

    private void editComment(){
        if(getBoolean(5))
        {
            comment.setEditable(true);
            comment.setStyle(TEXT_AREA_STYLE_ON);
            commentImageView.setImage(checkBoxImage);
            setBoolean(5,false);
        }else
        {
            comment.setEditable(false);
            comment.setStyle(TEXT_AREA_STYLE_OFF);
            commentImageView.setImage(pencilImage);
            comment.setText(comment.getText());
            setBoolean(5,true);
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

    private void checkEdit() throws ModifyOperatorNotClosedException {
        for (Boolean aBoolean : rwField)
            if (Boolean.FALSE.equals(aBoolean))
                throw new ModifyOperatorNotClosedException();
    }
}
