package com.example.mvcsinglepattern.controller.customer;

import com.example.mvcsinglepattern.model.CustomerModel;
import com.example.mvcsinglepattern.tm.CustomerTM;
import com.example.mvcsinglepattern.tm.PhoneTM;
import com.example.mvcsinglepattern.to.Customer;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CustomerLoadDataController implements Initializable {


    public TableView <CustomerTM> tblCustomerAllData;
    public AnchorPane rootAllDataForm;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tblCustomerAllData.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("customer_id"));
        tblCustomerAllData.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("customer_name"));
        tblCustomerAllData.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("telephone"));
        tblCustomerAllData.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("address"));

        setCustomerAllData();
    }

    public void btnLoadOnAction(ActionEvent actionEvent) {

        setCustomerAllData();

    }

    public void btnLoadBackToLoginPage(MouseEvent mouseEvent) {
        try {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/mvcsinglepattern/view/customer/customer-data-form.fxml"));
        Stage stage = (Stage) this.rootAllDataForm.getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.centerOnScreen();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setCustomerAllData(){

        ArrayList<Customer> allCustomerData = CustomerModel.getAllCustomerData();

        ArrayList<CustomerTM> tms = new ArrayList<>();

        for (Customer cus : allCustomerData) {

            tms.add(new CustomerTM(cus.getCustomerId(),cus.getCustomerName(),cus.getTelephoneNo(),cus.getAddress()));

        }

        tblCustomerAllData.setItems(FXCollections.observableArrayList(tms));
    }
}
