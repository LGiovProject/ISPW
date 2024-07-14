package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.Main;
import com.ispw.circularbook.controller.appcontroller.SearchBookController;
import com.ispw.circularbook.engineering.bean.BookBean;
import com.ispw.circularbook.engineering.bean.ElementBean;
import com.ispw.circularbook.engineering.bean.SearchBookBean;
import com.ispw.circularbook.engineering.enums.Arguments;
import com.ispw.circularbook.engineering.exception.NoBookFoundException;
import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.engineering.observer.Observer;
import com.ispw.circularbook.engineering.utils.MessageSupport;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.NodeOrientation;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;




import java.io.IOException;
import java.util.List;

public class GUIResearchBookController implements Observer {
    @FXML
    TextField textFieldAuthor;
    @FXML
    ChoiceBox<Arguments> argumentsChoiceBox;
    @FXML
    TextField textFieldTitle;
    @FXML
    VBox showResult;
    @FXML
    ScrollPane scrollPane;

    private Pane currentPane;

    private SearchBookBean searchBookBean;

    public void setCurrentPane(Pane currentPane){this.currentPane = currentPane;}

    public void setSearch(){
        argumentsChoiceBox.getItems().addAll(Arguments.values());
        argumentsChoiceBox.getItems().remove(1);
        argumentsChoiceBox.getSelectionModel().select(0);
        scrollPane.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        scrollPane.setHvalue(scrollPane.getHmax());
        showResult.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
        searchBookBean =new SearchBookBean(Session.getCurrentSession().getUser().isGuest()?"null":Session.getCurrentSession().getUser().getEmail());

    }

    public void startToSearchBook() throws IOException {

        showResult.getChildren().clear();
        List<BookBean> bookBeanList;
        searchBookBean.setAuthor(textFieldAuthor.getText());
        searchBookBean.setArgument(argumentsChoiceBox.getSelectionModel().getSelectedItem());
        searchBookBean.setTitle(textFieldTitle.getText());
        clearFieldText();
        SearchBookController searchBookController = new SearchBookController();
        try {
            bookBeanList = searchBookController.searchAvailableBook(searchBookBean);
            this.setShowResult(bookBeanList);
        } catch (NoBookFoundException e) {
            MessageSupport.popUpsExceptionMessage(e.getMessage());
        }
    }

    public void clearFieldText(){
        argumentsChoiceBox.getSelectionModel().select(0);
        textFieldAuthor.setText("");
        textFieldTitle.setText("");
    }

    private void setShowResult(List<BookBean> bookBeanList) throws IOException {
        for (BookBean bookBean : bookBeanList) {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("SearchedBooksItem.fxml"));
            Pane element = fxmlLoader.load();
            GUISearchedBookItemController guiSearchedBookItemController = fxmlLoader.getController();
            ElementBean elementBean = new ElementBean(element,bookBean);
            guiSearchedBookItemController.setBookElement(elementBean);
            guiSearchedBookItemController.register(this);
            guiSearchedBookItemController.setPreviuosPane(currentPane);
            showResult.getChildren().add(element);
        }
    }

    @Override
    public void update(Object object) {
        showResult.getChildren().remove(showResult.getChildren().indexOf(object));
    }

    @Override
    public void update(Object bean, Object element) {
        //E' usato solo quando si deve aggiornare
    }


}


