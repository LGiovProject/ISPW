package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.engineering.bean.BookBean;
import com.ispw.circularbook.engineering.bean.ElementBean;
import com.ispw.circularbook.engineering.utils.MessageSupport;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class GUIMyTakedBookItemController {

    @FXML
    Text title;
    @FXML
    Text author;
    @FXML
    Text usernameGiver;
    @FXML
    Text daysRemaing;
    @FXML
    Button returnBook;

    private BookBean bookBean;

    public void startSetElementTakedBook(ElementBean elementBean)
    {

        bookBean = elementBean.getBookBean();
        returnBook.setVisible(false);
        returnBook.setManaged(false);
        if(bookBean.getTypeOfBookInt()==1)
            this.setLendedBook();
        else
            this.setGiftedBook();

    }


    public void returnBook()
    {
        MessageSupport.popUpsNotDevelopedMessage();
    }

    private void setLendedBook(){

        title.setText(bookBean.getTitle());
        author.setText(bookBean.getAuthor());
        usernameGiver.setText("Taken from "+bookBean.getUsername());
        daysRemaing.setText("Remaining "+bookBean.getDaysRemain()+" days");
        returnBook.setVisible(true);
        returnBook.setManaged(true);
    }

    private void setGiftedBook(){

        title.setText(bookBean.getTitle());
        author.setText(bookBean.getAuthor());
        usernameGiver.setText("Taken from "+bookBean.getUsername());
        daysRemaing.setText("Received as a gift");
    }


}
