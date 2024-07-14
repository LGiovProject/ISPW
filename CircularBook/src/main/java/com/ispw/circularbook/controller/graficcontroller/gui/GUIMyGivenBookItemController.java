package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.engineering.bean.BookBean;
import com.ispw.circularbook.engineering.bean.ElementBean;
import javafx.fxml.FXML;
import javafx.scene.text.Text;



public class GUIMyGivenBookItemController {

    @FXML
    Text title;
    @FXML
    Text author;
    @FXML
    Text usernameGiver;
    @FXML
    Text daysRemains;


    public void startSetElementGivenBook(ElementBean elementBean)
    {

        BookBean bookBean = elementBean.getBookBean();
        title.setText(bookBean.getTitle());
        author.setText(bookBean.getAuthor());
        usernameGiver.setText("Given to "+ bookBean.getUsername());
        String daysRemainsString= bookBean.getTypeOfBookInt()==1?"Remaining \n"+ bookBean.getDaysRemain()+" days ":"Received as a gift";
        this.daysRemains.setText(daysRemainsString);

    }


}
