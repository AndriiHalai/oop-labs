module oop.lab5.lab5 {
    requires javafx.controls;
    requires javafx.fxml;


    opens oop.lab5.lab5 to javafx.fxml;
    exports oop.lab5.lab5;
}