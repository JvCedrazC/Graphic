module com.example.phase4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.phase4 to javafx.fxml;
    exports com.example.phase4;
}