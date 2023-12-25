module oop.lab6.object2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javax.websocket.api;
    requires org.glassfish.tyrus.server;


    opens oop.lab6.object2 to javafx.fxml;
    exports oop.lab6.object2;
}