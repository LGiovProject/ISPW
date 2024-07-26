package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.Main;
import com.ispw.circularbook.controller.appcontroller.InsertBookController;
import com.ispw.circularbook.engineering.bean.BookBean;
import com.ispw.circularbook.engineering.bean.ElementBean;
import com.ispw.circularbook.engineering.bean.TakenBookBean;
import com.ispw.circularbook.engineering.exception.NoBookMoreAvailableException;
import com.ispw.circularbook.engineering.observer.Observer;
import com.ispw.circularbook.engineering.observer.Subject;
import com.ispw.circularbook.engineering.utils.MessageSupport;
import com.ispw.circularbook.engineering.session.Session;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class GUISearchedBookItemController extends Subject {


        @FXML
        private Text author;
        @FXML
        private Text argument;
        @FXML
        private Text title;
        @FXML
        private Text typeOfInsert;
        @FXML
        private Pane panel;

        private BookBean bookBean;

        private final List<Observer> observers = new ArrayList<>();

        private Pane previuosPane;

        public Pane getPreviuosPane() {
            return previuosPane;
        }

        public void setPreviuosPane(Pane currentPane) {
            this.previuosPane = currentPane;
        }




        public void setBookElement(ElementBean elementBean) {

            bookBean=elementBean.getBookBean();
            panel= elementBean.getPane();
            typeOfInsert.setText("Put in "+bookBean.getTypeOfDisponibilityString());
            author.setText(bookBean.getAuthor());
            title.setText(bookBean.getTitle());
            argument.setText(bookBean.getArgumentString());


        }

        public void moreInfoSearch() throws IOException {

            GUIMoreInfoBookController guiMoreInfoBookController;
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MoreInfoBook.fxml"));
            Pane pane = fxmlLoader.load();

            guiMoreInfoBookController = fxmlLoader.getController();
            ElementBean elementBean = new ElementBean(bookBean);
            guiMoreInfoBookController.setInfoBook(elementBean);
            guiMoreInfoBookController.setPreviousPane(this.previuosPane);

            Session.getCurrentSession().getSceneFacade().loadScene(pane);
        }

        public void getBook(){
            if(Session.getCurrentSession().getUser().isGuest())
            {
                MessageSupport.popUpsGuestDeniedMessage();
            }
            else {
                InsertBookController insertBookController = new InsertBookController();
                TakenBookBean takenBookBean = new TakenBookBean(bookBean.getId(), bookBean.isUser(),bookBean.getTypeOfBookInt(), bookBean.getEmail(), Session.getCurrentSession().getUser().getEmail(), LocalDate.now());
                try {
                    insertBookController.registerTakenBook(takenBookBean);
                    notifyObserver(this.panel);
                    MessageSupport.popUpsSuccessMessage("The book is succesfully taken");
                } catch (NoBookMoreAvailableException e) {
                   MessageSupport.popUpsExceptionMessage(e.getMessage());
                }
            }
        }


        @Override
        public void register(Observer observer) {
            observers.add(observer);
        }

        @Override
        public void register(List<Observer> observers) {
            this.observers.addAll(observers);
        }

        @Override
        public void unregister(Observer o) {
            observers.remove(o);
        }

        @Override
        public void notifyObserver(Object element) {
            for(Observer observer : observers)
                observer.update(element);

        }

        @Override
        public void notifyObserver(Object bookBean, Object element) {
            for(Observer observer : observers)
                observer.update(bookBean,element);
        }
}


