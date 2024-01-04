package com.example.mvcsinglepattern.controller.customer;

import com.example.mvcsinglepattern.model.CustomerModel;
import com.example.mvcsinglepattern.to.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class CustomerDeleteController {


    public TextField txtCustomerID;
    public TextField txtCustomerName;
    public TextField txtCustomerAddress;
    public TextField txtCustomerTelephoneNo;
    public AnchorPane rootDeleteForm;

    public void backToLoginPage(MouseEvent mouseEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/com/example/mvcsinglepattern/view/customer/customer-data-form.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) rootDeleteForm.getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnSearchOnAction(ActionEvent actionEvent) {
        String customerId = txtCustomerID.getText();

        Customer customer = CustomerModel.customerSearch(customerId);

        txtCustomerName.setText(customer.getCustomerName());
        txtCustomerTelephoneNo.setText(String.valueOf(customer.getTelephoneNo()));
        txtCustomerAddress.setText(customer.getAddress());
    }

    public void btnCustomerDeleteOnAction(ActionEvent actionEvent) {

        CustomerModel.deleteCustomer(txtCustomerID.getText());
        txtCustomerID.clear();
        txtCustomerName.clear();
        txtCustomerTelephoneNo.clear();
        txtCustomerAddress.clear();

    }

    public void btnClearOnAction(ActionEvent actionEvent) {

        txtCustomerID.clear();
        txtCustomerName.clear();
        txtCustomerTelephoneNo.clear();
        txtCustomerAddress.clear();
    }
}
