module com.example.lab04fx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lab04fx to javafx.fxml;
    exports com.example.lab04fx;
}