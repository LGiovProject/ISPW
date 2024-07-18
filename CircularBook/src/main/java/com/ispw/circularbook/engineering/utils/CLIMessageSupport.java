package com.ispw.circularbook.engineering.utils;

import java.util.logging.*;

public class CLIMessageSupport {

    // Creazione di un logger statico
    private static final Logger logger = Logger.getLogger(CLIMessageSupport.class.getName());


    static {
        // Configurazione del logger per inviare i messaggi alla console
        // Il codice viene eseguito una sola volta quando la classe viene caricata in memoria.
        ConsoleHandler consoleHandler = new ConsoleHandler();
        // Un formatter personalizzato per rimuovere informazioni timestamp, livello di log, e altre informazioni meta
        consoleHandler.setFormatter(new Formatter() {
            @Override
            public String format(LogRecord recordTemp) {
                return recordTemp.getMessage() + "\n";
            }
        });
        consoleHandler.setLevel(Level.ALL);
        // Aggiungo il consoleHandler al logger
        logger.addHandler(consoleHandler);
        // Disabilito gli altri handler predefiniti, in modo che i messaggi vengano propagati solo all'handler specificatamente aggiunti
        // In questo caso il consoleHandler
        logger.setUseParentHandlers(false);
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
