module com.example.hi1029 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    exports com.example.hi1029.F11;


    opens com.example.hi1029 to javafx.fxml;
    exports com.example.hi1029.F1;
}