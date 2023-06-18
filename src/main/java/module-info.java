module com.example.sample {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;


    opens com.example.sample to javafx.fxml;
    exports com.example.sample;
    exports com.example.sample.Controller;
    opens com.example.sample.Controller to javafx.fxml;
    exports com.example.sample.Views;
    opens com.example.sample.Views to javafx.fxml;
    exports com.example.sample.Class;
    opens com.example.sample.Class to javafx.fxml;
}