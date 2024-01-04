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

public class CustomerFormController {
    public AnchorPane rootCustomerForm;
    public TextField txtCustomerID;
    public TextField txtCustomerName;
    public TextField txtTelephoneNo;
    public TextField txtAddress;

    public void btnBackToLoginPage(MouseEvent mouseEvent) {
        try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/mvcsinglepattern/view/dash-board.fxml"));
        Stage stage = (Stage) this.rootCustomerForm.getScene().getWindow();
          Scene scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnDeleteData(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/com/example/mvcsinglepattern/view/customer/customer-delete.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) rootCustomerForm.getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Customer Delete Form");
            stage.centerOnScreen();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnSave(ActionEvent actionEvent) {

        String customerId = txtCustomerID.getText();
        String customerName = txtCustomerName.getText();
        int telephoneNo = Integer.parseInt(txtTelephoneNo.getText());
        String address = txtAddress.getText();

        boolean b = CustomerModel.saveCustomer(new Customer(customerId, customerName, telephoneNo, address));

        System.out.println(b+" Query Executed");

        txtCustomerID.clear();
        txtCustomerName.clear();
        txtTelephoneNo.clear();
        txtAddress.clear();

    }

    public void btnClear(ActionEvent actionEvent) {
        txtCustomerID.clear();
        txtCustomerName.clear();
        txtTelephoneNo.clear();
        txtAddress.clear();
    }

    public void btnAllDataOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/mvcsinglepattern/view/dash-board.fxml"));
            Stage stage = (Stage) this.rootCustomerForm.getScene().getWindow();
            Scene scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnUpdateData(ActionEvent actionEvent) {
        try {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/com/example/mvcsinglepattern/view/customer/customer-search-update.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) rootCustomerForm.getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Search & Update Customer");
            stage.centerOnScreen();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
