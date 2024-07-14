package com.ispw.circularbook.view.cli;

import com.ispw.circularbook.controller.graficcontroller.cli.CLIResearchBookController;
import com.ispw.circularbook.engineering.bean.SearchBookBean;
import com.ispw.circularbook.engineering.exception.CommandNotFoundException;
import com.ispw.circularbook.engineering.exception.WrongArgumentInsertException;
import com.ispw.circularbook.engineering.utils.CLIMessageSupport;
import com.ispw.circularbook.engineering.utils.MessageSupport;

import java.util.Scanner;

public class CLISearchBookView {

    private final Scanner scanner = new Scanner(System.in);
    private final CLIResearchBookController cliResearchBookController;

    public CLISearchBookView(CLIResearchBookController cliResearchBookController){
        this.cliResearchBookController = cliResearchBookController;
    }
    public void start()
    {
        CLIMessageSupport.delimiterMessage();
        CLIMessageSupport.titleMessage("Start research ");
        CLIMessageSupport.simpleMessage("Inserisci i parametri per la ricerca del libro");
        CLIMessageSupport.simpleMessage("Se non metti alcun parametro la ricerca mostrerà tutti i risultati disponibili");
        CLIMessageSupport.simpleMessage("1)Insert title");
        CLIMessageSupport.simpleMessage("2)insert argument");
        CLIMessageSupport.simpleMessage("3)Inserisci Autore");
        CLIMessageSupport.simpleMessage("4)Effetua ricerca");
        CLIMessageSupport.simpleMessage("5)Pulisci i parametri");
        CLIMessageSupport.simpleMessage("6)go back");
        String command = scanner.nextLine();
        try {
            cliResearchBookController.command(command);
        } catch (CommandNotFoundException e) {
            MessageSupport.cliExceptionSMessage(e.getMessage());
            start();
        }
    }

    public void searchParameters(SearchBookBean searchBookBean)
    {
        CLIMessageSupport.simpleMessage("Titolo : "+searchBookBean.getTitle());
        CLIMessageSupport.simpleMessage("Argomento : "+searchBookBean.getArgument());
        CLIMessageSupport.simpleMessage("Autore : "+searchBookBean.getAuthor());
    }

    public void insertTitle()
    {
        CLIMessageSupport.delimiterMessage();
        CLIMessageSupport.titleMessage("Inserisci il titolo per il quale vuoi effettuare la ricerca");
        CLIMessageSupport.simpleMessage("Se non viene inserito nulla, verrà fatta la ricerca su ogni titolo");
        CLIMessageSupport.simpleMessage("Titolo :");
        String title = scanner.nextLine();
        cliResearchBookController.insertTitle(title);
    }

    public void insertArgument()
    {
        CLIMessageSupport.delimiterMessage();
        CLIMessageSupport.titleMessage("Inserisci l'argomento per cui vuoi effettuare la ricerca");
        CLIMessageSupport.simpleMessage("Se non viene inserito nulla, verrà fatta la ricerca per ogni argomento");
        CLIMessageSupport.simpleMessage("Argomento: ");
        String argument = scanner.nextLine();
        try {
            cliResearchBookController.insertArgument(argument);
        } catch (WrongArgumentInsertException e) {
            MessageSupport.cliExceptionSMessage(e.getMessage());
            insertArgument();
        }
    }

    public void insertAuthor()
    {
        CLIMessageSupport.delimiterMessage();
        CLIMessageSupport.titleMessage("Inserisci l'autore per cui va effettuare la ricerca");
        CLIMessageSupport.simpleMessage("Se non viene inserito nulla verrà fatto la ricerca per ogni autore");
        CLIMessageSupport.simpleMessage("Autore: ");
        String author = scanner.nextLine();
        cliResearchBookController.insertAuthor(author);
    }

}
