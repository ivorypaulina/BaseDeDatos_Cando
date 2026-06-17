module com.example.cando_basededatos {

    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example.cando_basededatos to javafx.fxml;

    exports com.example.cando_basededatos;
}