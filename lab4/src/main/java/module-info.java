module oop.lab4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens oop.lab4 to javafx.fxml;
    exports oop.lab4;
}