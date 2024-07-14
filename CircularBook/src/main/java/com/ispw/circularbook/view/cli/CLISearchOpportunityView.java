package com.ispw.circularbook.view.cli;

import com.ispw.circularbook.controller.graficcontroller.cli.CLIResearchOpportunityController;
import com.ispw.circularbook.engineering.bean.SearchOpportunityBean;
import com.ispw.circularbook.engineering.exception.CommandNotFoundException;
import com.ispw.circularbook.engineering.utils.CLIMessageSupport;
import com.ispw.circularbook.engineering.utils.MessageSupport;

import java.util.Scanner;

public class CLISearchOpportunityView {

    private final CLIResearchOpportunityController cliResearchOpportunityController;
    private final Scanner scanner = new Scanner(System.in);


    public CLISearchOpportunityView(CLIResearchOpportunityController cliResearchOpportunityController) {
        this.cliResearchOpportunityController = cliResearchOpportunityController;
    }




    public void start()
    {
        CLIMessageSupport.titleMessage("Search Opportunity");
        CLIMessageSupport.simpleMessage("Inserisci i parametri per la ricerca");
        CLIMessageSupport.simpleMessage("Se non inserisci parametri la ricerca mostrerà tutti i risultati disponibili");
        CLIMessageSupport.simpleMessage("1)Nome Book Shop");
        CLIMessageSupport.simpleMessage("2)Mese in cui effettuare la ricerca");
        CLIMessageSupport.simpleMessage("3)Tipologia di inserzione");
        CLIMessageSupport.simpleMessage("4)Effetua ricerca");
        CLIMessageSupport.simpleMessage("5)Azzera i parametri");
        CLIMessageSupport.simpleMessage("6)Mostra i parametri di ricerca");
        CLIMessageSupport.simpleMessage("7)go back");
        String command = scanner.nextLine();
        try {
            cliResearchOpportunityController.command(command);
        } catch (CommandNotFoundException e) {
            MessageSupport.cliExceptionSMessage(e.getMessage());
            start();
        }
    }

    public void searchParameters(SearchOpportunityBean searchOpportunityBean)
    {
        CLIMessageSupport.simpleMessage("Nome Book Shop"+ searchOpportunityBean.getNameLib());
        CLIMessageSupport.simpleMessage("Mese in cui effettuare la ricerca: "+ searchOpportunityBean.getMonthString());
        CLIMessageSupport.simpleMessage("Tipologia di inserzione: "+ searchOpportunityBean.getTypeOfOpportunity());
    }

    public void insertBookShopName()
    {
        CLIMessageSupport.delimiterMessage();
        CLIMessageSupport.titleMessage("Inserisci il nome di una libreria per la quale stai cercando inserzioni");
        CLIMessageSupport.simpleMessage("Non inserire nulla per effettuare la ricerca tra tutte le librerie");
        CLIMessageSupport.simpleMessage("Nome Libreria: ");
        String name = scanner.nextLine();
        cliResearchOpportunityController.insertBookShopName(name);
    }

    public void insertMonth() {
        CLIMessageSupport.titleMessage("Inserisci il nome del mese in cui vuoi effettuare la riceca ");
        CLIMessageSupport.simpleMessage("Non inserire niente per effettuare la ricerca su tutti i mesi ");
        CLIMessageSupport.simpleMessage("Il mese va inserito con la prima lettera maiuscola \"Jennuary\"");
        CLIMessageSupport.simpleMessage("Nome mese: ");
        String month = scanner.nextLine();
        cliResearchOpportunityController.insertMonth(month);
    }

    public void insertTypologyInsertion()
    {
        CLIMessageSupport.titleMessage("Inserisci la tipologia di inserzione");
        CLIMessageSupport.simpleMessage("Possono essere del tipo \"Evento\" oppure \"Promozione\"");
        CLIMessageSupport.simpleMessage("Non inserire niente per cercare tra entrambe le tipologie");
        CLIMessageSupport.simpleMessage("Tipologia: ");
        String type = scanner.nextLine();
        cliResearchOpportunityController.insertTypologyInsertion(type);
    }

}
