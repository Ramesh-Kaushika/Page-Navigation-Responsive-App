package com.example.mvcsinglepattern.controller.phones;


import com.example.mvcsinglepattern.db.DBConnection;
import com.example.mvcsinglepattern.model.PhoneModel;
import com.example.mvcsinglepattern.tm.PhoneTM;
import com.example.mvcsinglepattern.to.Phone;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PhoneSaveViewController implements Initializable {


    public TextField txtDeleteImei;
    public AnchorPane root2;
    @FXML
    private TextField txtPhoneBrand;

    @FXML
    private TextField txtPhoneModel;

    @FXML
    private TextField txtPhonePrice;

    @FXML
    private TextField txtPhoneImei;

    @FXML
    private TextField txtRAM;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        txtPhoneImei.requestFocus();
    }

    public void btnSave(ActionEvent actionEvent) throws ClassNotFoundException, SQLException {

        String imei =txtPhoneImei.getText();
        String brand = txtPhoneBrand.getText();
        String model = txtPhoneModel.getText();
        int ram = Integer.parseInt(txtRAM.getText());
        double price = Double.parseDouble(txtPhonePrice.getText());

        PhoneModel.savePhone(new Phone(imei,brand,model,ram,price));

    }

    public void btndelete(ActionEvent actionEvent) {

        PhoneModel.deletePhone(txtDeleteImei.getText());
        txtDeleteImei.clear();

    }


    public void btnUpdateOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) this.root2.getScene().getWindow();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/mvcsinglepattern/view/phone/phone-update.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
    }

    public void btnLoadOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) this.root2.getScene().getWindow();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/mvcsinglepattern/view/phone/phone-load.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
    }

    public void btnBackToLoginPage(MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage) this.root2.getScene().getWindow();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/mvcsinglepattern/view/dash-board.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
    }
}
