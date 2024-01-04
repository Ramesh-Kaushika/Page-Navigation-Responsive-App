module com.example.mvcsinglepattern {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    requires mysql.connector.j;



    opens com.example.mvcsinglepattern to javafx.fxml;
    exports com.example.mvcsinglepattern;

    exports com.example.mvcsinglepattern.controller;
    opens com.example.mvcsinglepattern.controller to javafx.fxml;
    exports com.example.mvcsinglepattern.tm;
    opens com.example.mvcsinglepattern.tm to javafx.fxml;
    exports com.example.mvcsinglepattern.controller.user;
    opens com.example.mvcsinglepattern.controller.user to javafx.fxml;
    exports com.example.mvcsinglepattern.to;
    exports com.example.mvcsinglepattern.db;
    exports com.example.mvcsinglepattern.controller.phones;
    opens com.example.mvcsinglepattern.controller.phones to javafx.fxml;
    exports com.example.mvcsinglepattern.controller.customer;
    opens com.example.mvcsinglepattern.controller.customer to javafx.fxml;
}