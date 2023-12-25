module oop.lab6.object1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javax.websocket.api;


    opens oop.lab6.object1 to javafx.fxml;
    exports oop.lab6.object1;
}