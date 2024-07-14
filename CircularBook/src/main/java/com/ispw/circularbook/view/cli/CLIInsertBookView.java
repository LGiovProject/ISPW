package com.ispw.circularbook.view.cli;

import com.ispw.circularbook.controller.graficcontroller.cli.CLIInsertBookController;
import com.ispw.circularbook.engineering.exception.CommandNotFoundException;
import com.ispw.circularbook.engineering.exception.TitleCampRequiredException;
import com.ispw.circularbook.engineering.exception.WrongArgumentInsertException;
import com.ispw.circularbook.engineering.utils.CLIMessageSupport;
import com.ispw.circularbook.engineering.utils.MessageSupport;


import java.util.Scanner;

public class CLIInsertBookView {


    private final Scanner scanner = new Scanner(System.in);
    private final CLIInsertBookController cliInsertBookController;

    public CLIInsertBookView(CLIInsertBookController cliInsertBookController)
    {
        this.cliInsertBookController=cliInsertBookController;
    }

    public void start()
    {
        CLIMessageSupport.titleMessage("Insert new Book");
        CLIMessageSupport.simpleMessage("1)Start entering the data");
        CLIMessageSupport.simpleMessage("2)go back");
        String command = scanner.nextLine();
        try {
            cliInsertBookController.command(command);
        } catch (CommandNotFoundException e) {
            MessageSupport.cliExceptionSMessage(e.getMessage());
            start();
        }

    }

    public void finish()
    {
        CLIMessageSupport.titleMessage("Insert new Book");
        CLIMessageSupport.simpleMessage("1)Send data");
        CLIMessageSupport.simpleMessage("2)go back");
        String command = scanner.nextLine();
        try {
            cliInsertBookController.finishCommand(command);
        }catch (CommandNotFoundException e)
        {
            MessageSupport.cliExceptionSMessage(e.getMessage());
            finish();
        }
    }

    public void insertTitle()
    {

        CLIMessageSupport.titleMessage("Insert title");
        CLIMessageSupport.campObligatoryMessage();
        CLIMessageSupport.backValueMessage();
        String title= scanner.nextLine();
        try {
            cliInsertBookController.insertTitle(title);
        } catch (TitleCampRequiredException e) {
            MessageSupport.cliExceptionSMessage(e.getMessage());
            insertTitle();
        }

    }

    public void insertAuthor()
    {
        CLIMessageSupport.titleMessage("Insert Author");
        CLIMessageSupport.backValueMessage();
        String author= scanner.nextLine();
        cliInsertBookController.insertAuthor(author);
    }

    public void insertArgument()
    {
        CLIMessageSupport.titleMessage("Insert Argument");
        CLIMessageSupport.backValueMessage();
        String argument = scanner.nextLine();
        try {
            cliInsertBookController.insertArgument(argument);
        } catch (WrongArgumentInsertException e) {
          MessageSupport.cliExceptionSMessage(e.getMessage());
          insertArgument();
        }
    }

    public void insertPublisher()
    {
        CLIMessageSupport.titleMessage("Insert Publisher");
        CLIMessageSupport.backValueMessage();
        String publisher = scanner.nextLine();
        cliInsertBookController.insertPublisher(publisher);
    }

    public void insertTypeOfBook()
    {
        CLIMessageSupport.titleMessage("Insert TypeOfBook");
        CLIMessageSupport.simpleMessage("1 for lend Book 2 for a gift book");
        CLIMessageSupport.backValueMessage();
        int typeOfBook = Integer.parseInt(scanner.nextLine());
        cliInsertBookController.insertTypeOfBook(typeOfBook);
    }

    public void insertNPage()
    {
        CLIMessageSupport.titleMessage("Insert number of book page digit only number");
        CLIMessageSupport.backValueMessage();
        int nPage = Integer.parseInt(scanner.nextLine());
        cliInsertBookController.insertNPage(nPage);
    }

    public void insertComment()
    {
        CLIMessageSupport.titleMessage("Insert a description for a Book");
        CLIMessageSupport.backValueMessage();
        String comment = scanner.nextLine();
        cliInsertBookController.insertComment(comment);
    }
}
