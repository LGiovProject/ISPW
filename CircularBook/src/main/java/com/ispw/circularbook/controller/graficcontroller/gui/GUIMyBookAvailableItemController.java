package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.Main;
import com.ispw.circularbook.controller.appcontroller.InsertBookController;
import com.ispw.circularbook.engineering.bean.BookBean;
import com.ispw.circularbook.engineering.bean.ElementBean;
import com.ispw.circularbook.engineering.observer.Observer;
import com.ispw.circularbook.engineering.observer.Subject;
import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.engineering.utils.MessageSupport;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class GUIMyBookAvailableItemController extends Subject {

    @FXML
    private Text author;
    @FXML
    private Text argument;
    @FXML
    private Text title;
    @FXML
    private Text typeOfInsert;

    private Pane element;

    private BookBean bookBean;

    private final List<Observer> observers = new ArrayList<>();

    //La scene serve per modifyBookElement
    private Scene currentScene;

    public void setCurrentScene(Scene currentScene) {
        this.currentScene = currentScene;
    }

    //La pane serve per moreInforSearch
    private Pane previuosPane;

    public void setPreviuosPane(Pane pane)
    {
        this.previuosPane = pane;
    }

    public void setBookElement(ElementBean elementBean) {
        this.bookBean=elementBean.getBookBean();
        this.element = elementBean.getPane();
        this.typeOfInsert.setText("Put in "+bookBean.getTypeOfDisponibilityString());
        this.author.setText(bookBean.getAuthor());
        this.title.setText(bookBean.getTitle());
        this.argument.setText(bookBean.getArgumentString());
    }

    public void moreInfoSearch() throws IOException {
        GUIMoreInfoBookController guiMoreInfoBookController;
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MoreInfoBook.fxml"));
        Pane pane = fxmlLoader.load();
        guiMoreInfoBookController = fxmlLoader.getController();
        ElementBean elementBean = new ElementBean(bookBean);
        guiMoreInfoBookController.setPreviousPane(previuosPane);
        guiMoreInfoBookController.setInfoBook(elementBean);
        Session.getCurrentSession().getSceneFacade().loadScene(pane);
    }


    public void modifyBookElement() throws IOException {
        GUIModifyBookController guiModifyBookController;
        ElementBean elementBean = new ElementBean(element,bookBean);
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ModifyMyBookItem.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        guiModifyBookController =fxmlLoader.getController();
        Main.getStage().setScene(scene);
        guiModifyBookController.setPreviusScene(currentScene);
        guiModifyBookController.register(observers);
        guiModifyBookController.setElement(elementBean);
    }


    public void removeBook(){
        InsertBookController insertBookController= new InsertBookController();
        insertBookController.removeBook(bookBean.getId());
        notifyObserver(element);
        MessageSupport.popUpsSuccessMessage("The book is successfully removed");
    }


    @Override
    public void register(Observer o)
    {
        observers.add(o);
    }

    @Override
    public void register(List<Observer> observers) {
        this.observers.addAll(observers);
    }

    @Override
    public void unregister(Observer o){
        observers.remove(o);
    }
    @Override
    public void notifyObserver(Object element){

        for(Observer observer : observers)
            observer.update(element);
    }
    @Override
    public void notifyObserver(Object bookBean,Object element)
    {
        for(Observer observer : observers)
            observer.update(bookBean,element);
    }






}
