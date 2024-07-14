module com.ispw.circularbook {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;
    requires mysql.connector.j;
    requires junit;

    opens com.ispw.circularbook to javafx.fxml;
    exports com.ispw.circularbook;
    exports com.ispw.circularbook.controller.graficcontroller.gui to javafx.fxml;
    opens com.ispw.circularbook.controller.graficcontroller.gui to javafx.fxml;
    exports com.ispw.circularbook.controller.appcontroller;
    exports com.ispw.circularbook.engineering.bean;
    exports com.ispw.circularbook.engineering.exception;
    exports com.ispw.circularbook.engineering.dao;
    exports com.ispw.circularbook.engineering.connection;
    exports com.ispw.circularbook.engineering.mediator.concretemediator;
    exports com.ispw.circularbook.engineering.observer;
}