package com.ispw.circularbook.view.cli;

import com.ispw.circularbook.controller.graficcontroller.cli.CLIModifyMyAvailableBookController;
import com.ispw.circularbook.engineering.bean.BookBean;
import com.ispw.circularbook.engineering.exception.CommandNotFoundException;
import com.ispw.circularbook.engineering.utils.CLIMessageSupport;
import com.ispw.circularbook.engineering.utils.MessageSupport;

import java.util.Scanner;

public class CLIModifyMyAvailableBookView {

    private final Scanner scanner = new Scanner(System.in);
    private final CLIModifyMyAvailableBookController cliModifyMyAvailableBookController;

    public CLIModifyMyAvailableBookView(CLIModifyMyAvailableBookController cliModifyMyAvailableBookController)
    {
        this.cliModifyMyAvailableBookController = cliModifyMyAvailableBookController;
    }

    public void start()
    {
        CLIMessageSupport.titleMessage("Chose which data to modify");
        CLIMessageSupport.simpleMessage("1)Title");
        CLIMessageSupport.simpleMessage("2)Author");
        CLIMessageSupport.simpleMessage("3)Publisher");
        CLIMessageSupport.simpleMessage("4)Argument");
        CLIMessageSupport.simpleMessage("5)Type of insert");
        CLIMessageSupport.simpleMessage("6)Number of page");
        CLIMessageSupport.simpleMessage("7)Comment");
        CLIMessageSupport.simpleMessage("8)Apply change");
        CLIMessageSupport.simpleMessage("9)Show actually value");
        CLIMessageSupport.simpleMessage("10)go back");
        String command = scanner.nextLine();
        try {
            cliModifyMyAvailableBookController.command(command);
        } catch (CommandNotFoundException e) {
            MessageSupport.cliExceptionSMessage(e.getMessage());
            start();
        }
    }

    public void actualyValue(BookBean bookBean)
    {
        CLIMessageSupport.simpleMessage("Title :"+bookBean.getTitle());
        CLIMessageSupport.simpleMessage("Publisher :"+bookBean.getPublisher());
        CLIMessageSupport.simpleMessage("Author :"+bookBean.getAuthor());
        CLIMessageSupport.simpleMessage("Argument :"+bookBean.getArgument());
        CLIMessageSupport.simpleMessage("Type of insert :"+bookBean.getTypeOfDisponibilityString());
        CLIMessageSupport.simpleMessage("Number of page : "+bookBean.getNPageString());
        CLIMessageSupport.simpleMessage("Comment :"+bookBean.getComment());
    }


    public void insertTitle()
    {
        CLIMessageSupport.titleMessage("Insert title");
        CLIMessageSupport.backValueMessage();
        String title = scanner.nextLine();
        cliModifyMyAvailableBookController.insertTitle(title);
    }

    public void insertAuthor()
    {
        CLIMessageSupport.titleMessage("Insert Author");
        CLIMessageSupport.backValueMessage();
        String author = scanner.nextLine();
        cliModifyMyAvailableBookController.insertAuthor(author);
    }

    public void insertPublisher()
    {
        CLIMessageSupport.titleMessage("Insert Publisher");
        CLIMessageSupport.backValueMessage();
        String publisher = scanner.nextLine();
        cliModifyMyAvailableBookController.setInsertPublisher(publisher);
    }

    public void insertArgument()
    {
        CLIMessageSupport.titleMessage("Insert Argument");
        CLIMessageSupport.backValueMessage();
        String argument = scanner.nextLine();
        cliModifyMyAvailableBookController.insertArgument(argument);
    }

    public void insertTypeOfBook()
    {
        CLIMessageSupport.titleMessage("Insert TypeOfBook");
        CLIMessageSupport.simpleMessage("1 for lend Book 2 for a gift book\n");
        CLIMessageSupport.backValueMessage();
        int typeOfBook = Integer.parseInt(scanner.nextLine());
        cliModifyMyAvailableBookController.insertTypeOfBook(typeOfBook);
    }

    public void insertNPage()
    {
        CLIMessageSupport.titleMessage("Insert number of book page digit only number");
        CLIMessageSupport.backValueMessage();
        int nPage = Integer.parseInt(scanner.nextLine());
        cliModifyMyAvailableBookController.insertNPage(nPage);
    }

    public void insertComment()
    {
        CLIMessageSupport.titleMessage("Insert a description for a Book");
        CLIMessageSupport.backValueMessage();
        String comment = scanner.nextLine();
        cliModifyMyAvailableBookController.insertComment(comment);
    }
}
