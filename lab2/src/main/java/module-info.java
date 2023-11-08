module com.lab2.lab2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.lab2.lab2 to javafx.fxml;
    exports com.lab2.lab2;
    exports com.lab2.lab2.Shapes;
    opens com.lab2.lab2.Shapes to javafx.fxml;
}