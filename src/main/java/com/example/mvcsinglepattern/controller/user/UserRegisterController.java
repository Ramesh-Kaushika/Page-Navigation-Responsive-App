package com.example.mvcsinglepattern.controller.user;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Base64;

public class UserRegisterController {
    public AnchorPane rootUserRegister;
    @FXML
    private TextField txtDeleteImei;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUserEmail;

    @FXML
    private TextField txtUserID;

    @FXML
    void btnSave(ActionEvent event) throws ClassNotFoundException, SQLException {
        String uid =txtUserID.getText();
        String email = txtUserEmail.getText();
        String password = txtPassword.getText();



        String originalInput = txtPassword.getText();
        String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ACPT_3", "root", "ramesh2245");

        PreparedStatement stm = connection.prepareStatement("insert into user values(?,?,?)");

        stm.setObject (  1,uid);
        stm.setObject ( 2, email);
        stm.setObject ( 3, encodedString);


        int executed = stm.executeUpdate();

        System.out.println(executed);

    }

    @FXML
    void btndelete(ActionEvent event) {

    }

    public void btnClear(ActionEvent actionEvent) {
    }

    public void btnShowData(ActionEvent actionEvent) {
    }

    public void btnBackToLoginPage(MouseEvent mouseEvent) {
        try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/mvcsinglepattern/view/login-view.fxml"));
        Stage stage = (Stage) this.rootUserRegister.getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.centerOnScreen();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
