package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.engineering.bean.BookBean;
import com.ispw.circularbook.engineering.bean.ElementBean;
import com.ispw.circularbook.engineering.session.Session;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;




public class GUIMoreInfoBookController {

    @FXML
    Text author;
    @FXML
    Text title;
    @FXML
    Text argument;
    @FXML
    Text publisher;
    @FXML
    Text nPage;
    @FXML
    TextArea comment;

    private Pane previousPane;

    public void setPreviousPane(Pane previousPane)
    {
        this.previousPane = previousPane;
    }

    public void setInfoBook(ElementBean elementBean)
    {
        BookBean bookBean = elementBean.getBookBean();
        author.setText(bookBean.getAuthor());
        title.setText(bookBean.getTitle());
        publisher.setText(bookBean.getPublisher());
        argument.setText(bookBean.getArgumentString());
        nPage.setText(bookBean.getNPageString());
        comment.setText(bookBean.getComment());
        comment.setEditable(false);
    }

    public void backButton(){

        Session.getCurrentSession().getSceneFacade().loadScene(previousPane);

    }



    
}
