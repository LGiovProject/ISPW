package com.ispw.circularbook.view.cli;

import com.ispw.circularbook.controller.graficcontroller.cli.CLISettingBookShopController;
import com.ispw.circularbook.engineering.bean.CircularBookInfoBean;
import com.ispw.circularbook.engineering.bean.BookShopBean;
import com.ispw.circularbook.engineering.exception.CommandNotFoundException;
import com.ispw.circularbook.engineering.utils.CLIMessageSupport;
import com.ispw.circularbook.engineering.utils.MessageSupport;

import java.util.Scanner;

public class CLISettingBookShopView {

    private final CLISettingBookShopController cliSettingBookShopController;

    private final Scanner scanner = new Scanner(System.in);

    public CLISettingBookShopView(CLISettingBookShopController cliSettingBookShopController){this.cliSettingBookShopController = cliSettingBookShopController;}


    public void start()
    {
        CLIMessageSupport.titleMessage("Book Shop Setting");
        CLIMessageSupport.simpleMessage("1)Modify personal info");
        CLIMessageSupport.simpleMessage("2)Show persona info");
        CLIMessageSupport.simpleMessage("3)Show circular book use");
        CLIMessageSupport.simpleMessage("4)go back");
        String command = scanner.nextLine();
        try {
            cliSettingBookShopController.command(command);
        } catch (CommandNotFoundException e) {
            MessageSupport.cliExceptionSMessage(e.getMessage());
            start();
        }
    }

    public void choseCamp()
    {
        CLIMessageSupport.titleMessage("Book Shop Setting");
        CLIMessageSupport.simpleMessage("1)For change view");
        CLIMessageSupport.simpleMessage("2)Phone number");
        CLIMessageSupport.simpleMessage("3)City");
        CLIMessageSupport.simpleMessage("4)Apply change");
        CLIMessageSupport.simpleMessage("5)go to Book Shop Setting");
        String command =scanner.nextLine();
        try {
            cliSettingBookShopController.modifyPersonalInfo(command);
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
        CLIMessageSupport.simpleMessage(circularBookInfoBean.getOpportunityInsert()+" inserzioni inserite");
    }

    public void showPersonalInfo(BookShopBean bookShopBean)
    {
        CLIMessageSupport.delimiterMessage();
        CLIMessageSupport.simpleMessage("Nome: "+ bookShopBean.getBookShopName());
        CLIMessageSupport.simpleMessage("via: "+ bookShopBean.getAddress());
        CLIMessageSupport.simpleMessage("nTel: "+ bookShopBean.getPhoneNumber());
        CLIMessageSupport.simpleMessage("Citta: "+ bookShopBean.getCity());
    }


    public void insertView()
    {
        CLIMessageSupport.titleMessage("Inser new view");
        String address = scanner.nextLine();
        cliSettingBookShopController.getView(address);
    }

    public void insertNPhone()
    {
        CLIMessageSupport.titleMessage("Insert new phone number");
        int phoneNumber = scanner.nextInt();
        cliSettingBookShopController.getPhoneNumber(phoneNumber);
    }

    public void insertCity()
    {
        CLIMessageSupport.titleMessage("Insert City");
        String city = scanner.nextLine();
        cliSettingBookShopController.getCity(city);
    }



}
