package com.example.mvcsinglepattern.controller;

import com.example.mvcsinglepattern.db.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.Base64;

public class LoginController {

    public Label lblAdminLog;
    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtPassword;

    @FXML
    private AnchorPane root;

    public void initialize() {
        txtEmail.requestFocus();
    }


    @FXML
    void login(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
        display();

    }

    public void emailOnKeyPress(KeyEvent keyEvent) {

        txtEmail.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                txtPassword.requestFocus();
            }
        });
    }

    public void txtPasswordOnAction(ActionEvent actionEvent) throws ClassNotFoundException, SQLException, IOException {
        display();
    }

    public void display() throws ClassNotFoundException, SQLException, IOException {
        String email = txtEmail.getText();
        txtEmail.requestFocus();


        String originalInput = txtPassword.getText();
        String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());

        Connection connection = DBConnection.getDBConnection().getConnection();


        PreparedStatement stm = connection.prepareStatement("select * from user where email = ?");

        stm.setObject(1, email);

        ResultSet resultSet = stm.executeQuery();

        while (resultSet.next()) {
            byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
            String decodedString = new String(decodedBytes);
            if (encodedString.equals(resultSet.getString(3))) {

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/mvcsinglepattern/view/dash-board.fxml"));
                Stage stage = (Stage) this.root.getScene().getWindow();

                Scene scene = new Scene(fxmlLoader.load());
                stage.setScene(scene);
                stage.setTitle("Dash Board");
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Login Error");
                alert.setContentText("Email or Password incorrect");
                alert.show();
            }
        }

        System.out.println(resultSet);
    }

    public void lblAdminUserRegister(MouseEvent mouseEvent) {
        try {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/com/example/mvcsinglepattern/view/user/user-register.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) this.root.getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Admin Register Form");
            stage.centerOnScreen();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

