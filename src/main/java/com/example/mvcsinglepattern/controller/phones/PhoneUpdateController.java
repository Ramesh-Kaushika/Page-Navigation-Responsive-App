package com.example.mvcsinglepattern.controller.phones;

import com.example.mvcsinglepattern.model.PhoneModel;
import com.example.mvcsinglepattern.to.Phone;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class PhoneUpdateController {
    public AnchorPane updateRoot;
    @FXML
    private TextField txtId;
    
    @FXML
    private TextField txtBrand;


    @FXML
    private TextField txtModel;

    @FXML
    private TextField txtPrice;

    @FXML
    private TextField txtRam;

    @FXML
    void btnCancelOnAction(ActionEvent event) {
                txtId.clear();
                txtPrice.clear();
                txtModel.clear();
                txtBrand.clear();
                txtRam.clear();

    }

    @FXML
    void btnSearchOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        
        String imei = txtId.getText();

        Phone search = PhoneModel.search(imei);

        txtBrand.setText(search.getBrand());
        txtModel.setText(search.getModel());
        txtRam.setText(String.valueOf(search.getRam()));
        txtPrice.setText(String.valueOf(search.getPrice()));

                
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) throws ClassNotFoundException, SQLException {

        String imei =txtId.getText();
        String brand = txtBrand.getText();
        String model = txtModel.getText();
        int ram = Integer.parseInt(txtRam.getText());
        double price = Double.parseDouble(txtPrice.getText());

        PhoneModel.updatePhone(new Phone(imei,brand,model,ram,price));
        txtId.clear();
        txtBrand.clear();
        txtModel.clear();
        txtRam.clear();
        txtPrice.clear();
    }

    public void backToLoginPage(MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage) this.updateRoot.getScene().getWindow();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/mvcsinglepattern/view/phone/phone-insert-data.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
    }
}
