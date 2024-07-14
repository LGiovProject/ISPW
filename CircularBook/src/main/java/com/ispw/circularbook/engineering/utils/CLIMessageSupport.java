package com.ispw.circularbook.engineering.utils;

import java.util.logging.*;

public class CLIMessageSupport {

    // Creazione di un logger statico
    private static final Logger logger = Logger.getLogger(CLIMessageSupport.class.getName());


    static {
        // Configurazione del logger per inviare i messaggi alla console
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setFormatter(new Formatter() {
            @Override
            public String format(LogRecord recordTemp) {
                return recordTemp.getMessage() + "\n";
            }
        });
        consoleHandler.setLevel(Level.ALL);
        logger.addHandler(consoleHandler);
        logger.setUseParentHandlers(false); // Disabilita i gestori predefiniti del logger di root
        logger.setLevel(Level.ALL);
    }

    //Costruttore privato per evitare l'istanziamento della classe
    private CLIMessageSupport(){}

    public static void backValueMessage()
    {
        logger.info("Insert -1 for go back\n");

    }

    public static void campObligatoryMessage()
    {
        logger.info("*****************Required Field*****************\n");
    }

    public static void delimiterMessage()
    {
        logger.info("\n***********************************\n");
    }

    public static void titleMessage(String title)
    {
        logger.info(() -> "\n*****************" + title + "*****************\n");
    }

    public static void simpleMessage(String message)
    {
        logger.info(() -> message+"\n");
    }
}
