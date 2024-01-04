package com.example.mvcsinglepattern.controller.phones;

import com.example.mvcsinglepattern.db.DBConnection;
import com.example.mvcsinglepattern.model.PhoneModel;
import com.example.mvcsinglepattern.tm.PhoneTM;
import com.example.mvcsinglepattern.to.Phone;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
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
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PhoneLoadController implements Initializable {

    public AnchorPane loadRoot;
    @FXML
    private TableView<PhoneTM> vwTable;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //table initialization
        vwTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("imei"));
        vwTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("brand"));
        vwTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("model"));
        vwTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("ram"));
        vwTable.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("price"));

        setLoad();
    }

    @FXML
    void btnLoadOnAction(){
      setLoad();

    }

    public void btnLoadBackToLoginPage(MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage) this.loadRoot.getScene().getWindow();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/mvcsinglepattern/view/phone/phone-insert-data.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
    }
    public void setLoad() {

        //Get All Phones from PhoneModel Class
        ArrayList<Phone> loadPhone = PhoneModel.getLoadPhone();

        //Put all Phones TM List

        ArrayList<PhoneTM> tms = new ArrayList<>();

        for (Phone phone : loadPhone) {
            tms.add(new PhoneTM(phone.getImei(), phone.getBrand(), phone.getModel(), phone.getRam(), phone.getPrice()));

        }

        vwTable.setItems(FXCollections.observableArrayList(tms));

    }
}

