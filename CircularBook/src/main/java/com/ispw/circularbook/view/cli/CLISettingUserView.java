package com.ispw.circularbook.view.cli;

import com.ispw.circularbook.controller.graficcontroller.cli.CLISettingUserController;
import com.ispw.circularbook.engineering.bean.CircularBookInfoBean;
import com.ispw.circularbook.engineering.bean.UserBean;
import com.ispw.circularbook.engineering.exception.CommandNotFoundException;
import com.ispw.circularbook.engineering.exception.WrongCityInsertException;
import com.ispw.circularbook.engineering.utils.CLIMessageSupport;
import com.ispw.circularbook.engineering.utils.MessageSupport;

import java.util.Scanner;

public class CLISettingUserView {

    private final CLISettingUserController cliSettingUserController;
    private final Scanner scanner = new Scanner(System.in);



    public CLISettingUserView(CLISettingUserController cliSettingUserController){this.cliSettingUserController = cliSettingUserController;}

    public void start()
    {
        CLIMessageSupport.titleMessage("User Setting");
        CLIMessageSupport.simpleMessage("1)Modify personal info");
        CLIMessageSupport.simpleMessage("2)Show persona info");
        CLIMessageSupport.simpleMessage("3)Show circular book use");
        CLIMessageSupport.simpleMessage("4)go back");
        String command = scanner.nextLine();
        try {
            cliSettingUserController.command(command);
        } catch (CommandNotFoundException e) {
            MessageSupport.cliExceptionSMessage(e.getMessage());
            start();
        }
    }

    public void choseCamp()
    {

        CLIMessageSupport.titleMessage("Scegli il campo che vuoi modificare");
        CLIMessageSupport.simpleMessage("1)Name");
        CLIMessageSupport.simpleMessage("2)Surname");
        CLIMessageSupport.simpleMessage("3)Username");
        CLIMessageSupport.simpleMessage("4)City");
        CLIMessageSupport.simpleMessage("5)Confirm change");
        CLIMessageSupport.simpleMessage("6)Back to setting");
        String command = scanner.nextLine();
        try {
            cliSettingUserController.modifyPersonalInfo(command);
        } catch (CommandNotFoundException e) {
            MessageSupport.cliExceptionSMessage(e.getMessage());
            choseCamp();
        }
    }

    public void showInfoCircularBook(CircularBookInfoBean circularBookInfoBean)
    {
        CLIMessageSupport.delimiterMessage();
        CLIMessageSupport.simpleMessage(circularBookInfoBean.getRegisterBook()+" registrati");
        CLIMessageSupport.simpleMessage(circularBookInfoBean.getLendedBook()+" messi in prestito");
        CLIMessageSupport.simpleMessage(circularBookInfoBean.getGiftedBook()+" messi in regalo");
        CLIMessageSupport.simpleMessage(circularBookInfoBean.getLendedBookTaked()+" presi in regalo");
        CLIMessageSupport.simpleMessage(circularBookInfoBean.getGiftedBooktaked()+" presi in prestito");
    }

    public void showPersonalInfo(UserBean userBean)
    {
        CLIMessageSupport.delimiterMessage();
        CLIMessageSupport.simpleMessage("Name: "+userBean.getName());
        CLIMessageSupport.simpleMessage("Surname: "+userBean.getSurname());
        CLIMessageSupport.simpleMessage("Username: "+userBean.getUsername());
        CLIMessageSupport.simpleMessage("City: "+userBean.getCityString());
    }

    public void insertName()
    {
        CLIMessageSupport.titleMessage("Insert Name");
        String name = scanner.nextLine();
        cliSettingUserController.getName(name);
    }

    public void insertSurname()
    {
        CLIMessageSupport.titleMessage("Insert Surname");
        String surname = scanner.nextLine();
        cliSettingUserController.getSurname(surname);
    }

    public void insertUsername()
    {
        CLIMessageSupport.titleMessage("Insert Username");
        String username= scanner.nextLine();
        cliSettingUserController.getUsername(username);
    }

    public void insertCity()
    {
        CLIMessageSupport.titleMessage("Insert city");
        String city = scanner.nextLine();
        try {
            cliSettingUserController.getCity(city);
        } catch (WrongCityInsertException e) {
            MessageSupport.cliExceptionSMessage(e.getMessage());
            insertCity();
        }
    }


}
