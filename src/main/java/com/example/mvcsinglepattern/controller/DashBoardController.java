package com.example.mvcsinglepattern.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class DashBoardController {
    public AnchorPane rootDashboard;
    public Label lblAdminLog;

    public void btnPhonesLogin(ActionEvent actionEvent) {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/mvcsinglepattern/view/phone/phone-insert-data.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) this.rootDashboard.getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    

    public void btnOrderLogin(ActionEvent actionEvent) {
    }



    public void btnLogOut(ActionEvent actionEvent) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Do you want log out", ButtonType.YES,ButtonType.NO);
        Optional<ButtonType> buttonType = alert.showAndWait();

        if (buttonType.get().equals(ButtonType.YES)){
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/mvcsinglepattern/view/login-view.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                Stage stage = (Stage) this.rootDashboard.getScene().getWindow();
                stage.setScene(scene);
                stage.centerOnScreen();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }


    }

    public void btnCustomerLogin(ActionEvent actionEvent) {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/com/example/mvcsinglepattern/view/customer/customer-data-form.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) this.rootDashboard.getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Customer Form");
            stage.centerOnScreen();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
