package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.Main;
import com.ispw.circularbook.controller.appcontroller.BookShopController;
import com.ispw.circularbook.controller.appcontroller.SearchBookController;

import com.ispw.circularbook.engineering.bean.CircularBookInfoBean;
import com.ispw.circularbook.engineering.bean.BookShopBean;
import com.ispw.circularbook.engineering.bean.UpdateUserInfoBean;
import com.ispw.circularbook.engineering.enums.City;
import com.ispw.circularbook.engineering.exception.ModifyOperatorNotClosedException;
import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.engineering.utils.MessageSupport;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;


public class GUISettingBookShopController {

    @FXML
    private TextField email;
    @FXML
    private TextField nameBookShop;
    @FXML
    private TextField address;
    @FXML
    private TextField nPhone;
    @FXML
    private TextField city;

    @FXML
    private Text bookRegistered;
    @FXML
    private Text bookLended;
    @FXML
    private Text bookGifted;
    @FXML
    private Text opportunityInsert;

    @FXML
    private Text welcomeText;
    @FXML
    private ImageView nameImageView;
    @FXML
    private ImageView addressImageView;
    @FXML
    private ImageView cityImageView;
    @FXML
    private ImageView nPhoneImageView;
    @FXML
    private ChoiceBox<City> cityChoicheBox;

    private BookShopBean bookShopBean;


    private Scene previousScene;

    private Image checkBoxImage;
    private Image pencilImage;

    private final Boolean[] rwField= {true,true,true,true};

    private static final String CHECK_BOX_IMAGE_PATH ="img/ConfirmModify.png";

    private static final String PENCIL_IMAGE_PATH ="img/Pencil.png";

    private static final String ON_STYLE="fx-border-color: black;-fx-background-color:white;  -fx-background-radius: 40,40,40,40; -fx-text-fill: #4D0E0E";

    private static final String OFF_STYLE ="fx-border: none; -fx-background-color:none;";





    public void setPreviousScene(Scene scene)
    {
        previousScene=scene;
    }



    public void startSetting()
    {
        bookShopBean = Session.getCurrentSession().getBookShop();

        email.setText(bookShopBean.getEmail());
        nameBookShop.setText(bookShopBean.getBookShopName());
        address.setText(bookShopBean.getAddress());
        city.setText(bookShopBean.getCityString());
        nPhone.setText(String.valueOf(bookShopBean.getPhoneNumber()));
        setCirculaBookInfo();
        welcomeText.setText(welcomeText.getText()+" "+Session.getCurrentSession().getBookShop().getBookShopName());

        cityChoicheBox.getItems().addAll(City.values());
        cityChoicheBox.getSelectionModel().select(bookShopBean.getCity());
        cityChoicheBox.setVisible(false);
        email.setEditable(false);
    }

    public void setCirculaBookInfo()
    {
        try {
            checkEdit();
            SearchBookController searchBookController = new SearchBookController();
            CircularBookInfoBean circularBookInfoBean = searchBookController.searchBookShopCircularBookInfo(bookShopBean.getEmail());
            bookRegistered.setText(bookStringGenerator(circularBookInfoBean.getRegisterBook()) +" registered");
            bookLended.setText(bookStringGenerator(circularBookInfoBean.getLendedBook())+"  give on lend");
            bookGifted.setText(bookStringGenerator(circularBookInfoBean.getGiftedBook())+" give on gift");
            opportunityInsert.setText(opportunityStringGenerator(circularBookInfoBean.getOpportunityInsert()));
        } catch (ModifyOperatorNotClosedException e) {
            MessageSupport.popUpsExceptionMessage(e.getMessage());
        }
    }

    public void backToHomepage()  {

        Main.getStage().setScene(this.previousScene);
    }

    private String bookStringGenerator(int i) {

        String duplicate="You have ";
        return i == 1 ? duplicate+ i + " book" : duplicate + i + " books";
    }

    private String opportunityStringGenerator(int i) {
        String duplicate="You have ";
        return i == 1 ? duplicate + i + " opportunity inserted" : duplicate + i + " opportunities inserted";
    }

    public void rewriteField(ActionEvent event) throws IOException {
        checkBoxImage= new Image(Objects.requireNonNull(Main.class.getResource(CHECK_BOX_IMAGE_PATH)).openStream());
        pencilImage = new Image(Objects.requireNonNull(Main.class.getResource(PENCIL_IMAGE_PATH)).openStream());
        Button btn= (Button)event.getSource();
        String string=btn.getId();

        switch (string) {
            case "nameButton":
                editName();
                break;
            case "addressButton":
                editStreet();
                break;
            case "phoneButton":
                editNPhone();
                break;
            case "cityButton":
                editCity();
                break;
            default:
        }
    }



    public void applyChange()
    {

        BookShopController bookShopController = new BookShopController();
        UpdateUserInfoBean updateUserInfoBean = new UpdateUserInfoBean(bookShopBean.getEmail(), bookShopBean.getCity());
        updateUserInfoBean.setNameBookShop(bookShopBean.getBookShopName());
        updateUserInfoBean.setAddress(bookShopBean.getAddress());
        updateUserInfoBean.setNumberPhone(bookShopBean.getPhoneNumber());
        bookShopController.updateBookShop(updateUserInfoBean);
        MessageSupport.popUpsSuccessMessage("Change apply");
    }

    private void setBoolean(int i, boolean value)
    {
        rwField[i]=value;
    }
    private boolean getBoolean(int i)
    {
        return rwField[i];
    }

    private void editName()
    {
        if (getBoolean(0)) {
            nameBookShop.setEditable(true);
            nameBookShop.setStyle(ON_STYLE);
            nameImageView.setImage(checkBoxImage);
            setBoolean(0,false);

        }else
        {
            nameBookShop.setEditable(false);
            nameBookShop.setStyle(OFF_STYLE);
            nameImageView.setImage(pencilImage);
            bookShopBean.setBookShopName(nameBookShop.getText());
            nameBookShop.setText(nameBookShop.getText());
            setBoolean(0,true);
        }
    }

    private void editStreet()
    {
        if(getBoolean(1))
        {
            address.setEditable(true);
            address.setStyle(ON_STYLE);
            addressImageView.setImage(checkBoxImage);
            setBoolean(1,false);
        }else
        {
            address.setEditable(false);
            address.setStyle(OFF_STYLE);
            addressImageView.setImage(pencilImage);
            bookShopBean.setAddress(address.getText());
            address.setText(address.getText());
            setBoolean(1,true);
        }
    }

    private void editCity()
    {
        if(getBoolean(2))
        {
            cityImageView.setImage(checkBoxImage);
            cityChoicheBox.setStyle(ON_STYLE);
            cityChoicheBox.setVisible(true);
            setBoolean(2,false);
        }else
        {
            cityImageView.setImage(pencilImage);
            cityChoicheBox.setVisible(false);
            cityChoicheBox.setStyle(OFF_STYLE);
            bookShopBean.setCity(cityChoicheBox.getSelectionModel().getSelectedItem());
            city.setText(cityChoicheBox.getSelectionModel().getSelectedItem().getNameCity());
            setBoolean(2,true);
        }
    }

    private void editNPhone()
    {
        if(getBoolean(3))
        {
            nPhone.setEditable(true);
            nPhone.setStyle(ON_STYLE);
            nPhoneImageView.setImage(checkBoxImage);
            setBoolean(3,false);
        }
        else
        {
            nPhone.setEditable(false);
            nPhone.setStyle(OFF_STYLE);
            nPhoneImageView.setImage(pencilImage);
            bookShopBean.setPhoneNumber(Integer.parseInt(nPhone.getText()));
            nPhone.setText(nPhone.getText());
            setBoolean(3,true);
        }
    }

    private void checkEdit() throws ModifyOperatorNotClosedException {
        if(Arrays.stream(rwField).anyMatch(element-> !element))
            throw new ModifyOperatorNotClosedException();
    }

}
