module oop.lab6.object1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens oop.lab6.object1 to javafx.fxml;
    exports oop.lab6.object1;
}