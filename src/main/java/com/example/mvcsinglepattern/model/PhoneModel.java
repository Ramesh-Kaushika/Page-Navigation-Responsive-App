package com.example.mvcsinglepattern.model;

import com.example.mvcsinglepattern.controller.phones.PhoneUpdateController;
import com.example.mvcsinglepattern.db.DBConnection;
import com.example.mvcsinglepattern.tm.PhoneTM;
import com.example.mvcsinglepattern.to.Phone;
import javafx.scene.control.Alert;

import java.sql.*;
import java.util.ArrayList;

public class PhoneModel {

    public static boolean savePhone(Phone phone) throws ClassNotFoundException, SQLException {

    Connection connection = DBConnection.getDBConnection().getConnection();


    PreparedStatement stm = connection.prepareStatement("insert into phones values(?,?,?,?,?)");

        stm.setObject(1,phone.getImei());
        stm.setObject(2,phone.getBrand());
        stm.setObject(3,phone.getModel());
        stm.setObject(4,phone.getRam());
        stm.setObject(5,phone.getPrice());

    int executed = stm.executeUpdate();

    return executed>0;

 }
    public static Phone search (String imei) throws ClassNotFoundException, SQLException {

       Connection connection = DBConnection.getDBConnection().getConnection();

        PreparedStatement stm = connection.prepareStatement("select * from phones where imei=?");

        stm.setObject (  1,imei);

        ResultSet resultSet = stm.executeQuery();

        Phone phone = new Phone();

        if (!resultSet.next()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Wrong ID");
            alert.setContentText("Phone ID");
            alert.show();
        }
        else {
            do {
                phone.setBrand(resultSet.getString(2));
                phone.setModel(resultSet.getString(3));
                phone.setRam((resultSet.getInt(4)));
                phone.setPrice((resultSet.getDouble(5)));
            }while (resultSet.next());
        }
        return phone;

    }

    public static boolean deletePhone(String imei){

        try {
            Connection connection = DBConnection.getDBConnection().getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("delete from phones where imei = ?");

            preparedStatement.setObject(1,imei);

            int i = preparedStatement.executeUpdate();

            return i>0;


        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

      //  return imei;
    }

    public static boolean updatePhone(Phone phone) {

        try {


            Connection connection = DBConnection.getDBConnection().getConnection();

            PreparedStatement stm = connection.prepareStatement("update phones set brand=?,model=?,ram=?,price=? where imei=?");


            stm.setObject(1, phone.getBrand());
            stm.setObject(2, phone.getModel());
            stm.setObject(3, phone.getRam());
            stm.setObject(4, phone.getPrice());
            stm.setObject(5, phone.getImei());

            int executed = stm.executeUpdate();

            System.out.println(executed);

             return executed>0;


        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public static ArrayList<Phone> getLoadPhone(){

        try{
            Connection connection = DBConnection.getDBConnection().getConnection();

            PreparedStatement stm = connection.prepareStatement("select * from phones");


            ResultSet resultSet = stm.executeQuery();

            ArrayList<Phone> phones = new ArrayList<>();


            while (resultSet.next()) {
                Phone phone = new Phone();


                phone.setImei(resultSet.getString(1));
                phone.setBrand(resultSet.getString(2));
                phone.setModel(resultSet.getString(3));
                phone.setRam(resultSet.getInt(4));
                phone.setPrice(resultSet.getDouble(5));

                phones.add(phone);

            }
            return phones;
        }
        catch (ClassNotFoundException | SQLException e){
            throw new RuntimeException(e);
        }

    }

}



