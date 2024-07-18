package com.ispw.circularbook.controller.graficcontroller.gui;

import com.ispw.circularbook.Main;
import com.ispw.circularbook.controller.appcontroller.SearchBookController;
import com.ispw.circularbook.controller.appcontroller.UserController;
import com.ispw.circularbook.engineering.bean.CircularBookInfoBean;
import com.ispw.circularbook.engineering.bean.UpdateUserInfoBean;
import com.ispw.circularbook.engineering.bean.UserBean;
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
import java.util.Objects;


public class GUISettingUserController {

    @FXML
    private TextField email;
    @FXML
    private TextField username;
    @FXML
    private TextField name;
    @FXML
    private TextField surname;
    @FXML
    private TextField city;

    @FXML
    private Text bookRegistered;
    @FXML
    private Text bookLended;
    @FXML
    private Text bookGived;
    @FXML
    private Text bookTakedInLend;
    @FXML
    private Text bookTakeInGift;
    @FXML
    private Text welcomeText;
    @FXML
    private ImageView usernameImageView;
    @FXML
    private ImageView nameImageView;
    @FXML
    private ImageView surnameImageView;
    @FXML
    private ImageView cityImageView;
    @FXML
    private ChoiceBox<City> cityChoicheBox;



    private UserBean userBean;

    private Scene previousScene;

    private final Boolean[] rwField= {true,true,true,true};


    private static final String CHECK_BOX_IMAGE_PATH ="img/ConfirmModify.png";

    private static final String PENCIL_IMAGE_PATH ="img/Pencil.png";


    private static final String ON_STYLE ="fx-border-color: black;-fx-background-color:white;  -fx-background-radius: 40,40,40,40; -fx-text-fill: #4D0E0E";

    private static final String OFF_STYLE ="fx-border: none; -fx-background-color:none;";


    private Image checkBoxImage;
    private Image pencilImage;

    public void setPreviousScene(Scene scene)
    {
        previousScene=scene;
    }



    public void startSetting()
    {

        userBean = Session.getCurrentSession().getUser();

        email.setText(userBean.getEmail());
        email.setEditable(false);
        username.setText(userBean.getUsername());
        name.setText(userBean.getName());
        surname.setText(userBean.getSurname());
        city.setText(userBean.getCityString());
        city.setEditable(false);
        setCircularBookInfo();
        String buffer;
        buffer=welcomeText.getText()+" "+Session.getCurrentSession().getUser().getName();
        welcomeText.setText(buffer);
        cityChoicheBox.getItems().addAll(City.values());
        cityChoicheBox.getSelectionModel().select(userBean.getCity());
        cityChoicheBox.setVisible(false);
    }

    public void setCircularBookInfo()
    {
        SearchBookController searchBookController = new SearchBookController();
        CircularBookInfoBean circularBookInfoBean = searchBookController.searchUserCircularBookInfo(userBean.getEmail());
        bookRegistered.setText(stringGenerator(circularBookInfoBean.getRegisterBook()) +" inserted");
        bookLended.setText(stringGenerator(circularBookInfoBean.getLendedBook())+"your book give on lend");
        bookGived.setText(stringGenerator(circularBookInfoBean.getGiftedBook())+" your book give as a gift");
        bookTakeInGift.setText(stringGenerator(circularBookInfoBean.getLendedBookTaked())+" taken on gift");
        bookTakedInLend.setText(stringGenerator(circularBookInfoBean.getGiftedBookTaked())+" taken on lend");
    }

    public void backToHomepage()  {

        Main.getStage().setScene(this.previousScene);
    }

    private String stringGenerator(int i) {
        return i == 1 ? "You have " + i + " book" : "You have " + i + " books";
    }

    public void rewriteField(ActionEvent event) throws IOException {


        checkBoxImage= new Image(Objects.requireNonNull(Main.class.getResource(CHECK_BOX_IMAGE_PATH)).openStream());
        pencilImage = new Image(Objects.requireNonNull(Main.class.getResource(PENCIL_IMAGE_PATH)).openStream());
        Button btn= (Button)event.getSource();
        String string=btn.getId();

        switch (string) {
            case "usernameButton":
                    editUsername();
                    break;
            case "nameButton":
                    editName();
                    break;

            case "surnameButton":
                    editSurname();
                    break;
            case "cityButton":
                    editCity();
                    break;
            default:


        }
    }

    public void applyChange()
    {
        try {
            checkEdit();
            UserController userController = new UserController();
            UpdateUserInfoBean updateUserInfoBean = new UpdateUserInfoBean(userBean.getEmail(),userBean.getCity());
            updateUserInfoBean.setNameUser(userBean.getName());
            updateUserInfoBean.setSurname(userBean.getSurname());
            updateUserInfoBean.setUsername(userBean.getUsername());
            userController.updateUser(updateUserInfoBean);
            MessageSupport.popUpsSuccessMessage("Modify apply successful");
        } catch (ModifyOperatorNotClosedException e) {
            MessageSupport.popUpsExceptionMessage(e.getMessage());
        }
    }

    private void editUsername() {
        if(getBoolean(0)){
            this.username.setEditable(true);
            this.username.setStyle(ON_STYLE);
            this.usernameImageView.setImage(checkBoxImage);
            setBoolean(0,false);
        }else
        {
            this.username.setEditable(false);
            this.username.setStyle(OFF_STYLE);
            this.usernameImageView.setImage(pencilImage);
            this.userBean.setUsername(this.username.getText());
            this.username.setText(this.username.getText());
            setBoolean(0,true);
        }
    }

    private void editName() {
        if (getBoolean(1)) {
            name.setEditable(true);
            name.setStyle(ON_STYLE);
            nameImageView.setImage(checkBoxImage);
            setBoolean(1,false);

        }else
        {
            this.name.setEditable(false);
            this.name.setStyle(OFF_STYLE);
            this.nameImageView.setImage(pencilImage);
            this.userBean.setName(this.name.getText());
            this.name.setText(this.name.getText());
            setBoolean(1,true);
        }
    }

    private void editSurname(){
        if(getBoolean(2))
        {
            surname.setEditable(true);
            surname.setStyle(ON_STYLE);
            surnameImageView.setImage(checkBoxImage);

            setBoolean(2,false);
        }else
        {
            surname.setEditable(false);
            surname.setStyle(OFF_STYLE);
            surnameImageView.setImage(pencilImage);
            userBean.setSurname(surname.getText());
            surname.setText(surname.getText());
            setBoolean(2,true);
        }
    }

    private void editCity(){
        if(getBoolean(3))
        {
            cityImageView.setImage(checkBoxImage);
            cityChoicheBox.setStyle(ON_STYLE);
            cityChoicheBox.setVisible(true);
            setBoolean(3,false);
        }else
        {
            cityImageView.setImage(pencilImage);
            cityChoicheBox.setVisible(false);
            cityChoicheBox.setStyle(OFF_STYLE);
            userBean.setCity(cityChoicheBox.getSelectionModel().getSelectedItem());
            city.setText(cityChoicheBox.getSelectionModel().getSelectedItem().getNameCity());
            setBoolean(3,true);
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
