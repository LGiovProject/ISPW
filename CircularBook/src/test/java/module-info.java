module CircularBook {
    requires org.junit.jupiter.api;
    requires com.ispw.circularbook;
    requires java.sql;
    requires javafx.fxml;
    requires javafx.graphics;
    exports junit;
    opens junit;
}