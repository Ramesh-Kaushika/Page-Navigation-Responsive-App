package com.example.mvcsinglepattern.model;

import com.example.mvcsinglepattern.db.DBConnection;
import com.example.mvcsinglepattern.to.Customer;
import com.example.mvcsinglepattern.to.Phone;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerModel {

    public static boolean saveCustomer(Customer customer) {
        try {
            Connection connection = DBConnection.getDBConnection().getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("insert into customer values (?,?,?,?)");
            preparedStatement.setObject(1, customer.getCustomerId());
            preparedStatement.setObject(2, customer.getCustomerName());
            preparedStatement.setObject(3, customer.getTelephoneNo());
            preparedStatement.setObject(4, customer.getAddress());

            int i = preparedStatement.executeUpdate();

            return i > 0;

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Customer customerSearch(String customerId) {

        try {

            Connection connection = DBConnection.getDBConnection().getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("select * from customer where customer_id = ?");

            preparedStatement.setObject(1, customerId);

            ResultSet resultSet = preparedStatement.executeQuery();

            Customer customer = new Customer();

            if (!resultSet.next()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Wrong Customer ID");
                alert.setContentText("Phone Id");
                alert.showAndWait();
            } else {
                do {
                    customer.setCustomerName(resultSet.getString(2));
                    customer.setTelephoneNo(resultSet.getInt(3));
                    customer.setAddress(resultSet.getString(4));


                } while (resultSet.next());
            }

            return customer;

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public static boolean updateCustomer(Customer customer) {


        try {
            Connection connection = DBConnection.getDBConnection().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("update customer set customer_name = ?,telephone = ?,address =? where customer_id = ?");

            preparedStatement.setObject(1, customer.getCustomerName());
            preparedStatement.setObject(2, customer.getTelephoneNo());
            preparedStatement.setObject(3, customer.getAddress());
            preparedStatement.setObject(4, customer.getCustomerId());

            int i = preparedStatement.executeUpdate();

            return i > 0;

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean deleteCustomer(String customerId) {
        try {


           Connection connection = DBConnection.getDBConnection().getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("delete from customer where customer_id = ? ");

            preparedStatement.setObject(1,customerId);

            int i = preparedStatement.executeUpdate();

            return i>0;


        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public static ArrayList<Customer> getAllCustomerData(){
        try {


          Connection connection = DBConnection.getDBConnection().getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("select * from customer");

            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList<Customer> customers = new ArrayList<>();

            while(resultSet.next()){
                Customer customer = new Customer();

                customer.setCustomerId(resultSet.getString(1));
                customer.setCustomerName(resultSet.getString(2));
                customer.setTelephoneNo(resultSet.getInt(3));
                customer.setAddress(resultSet.getString(4));

                customers.add(customer);

            }

            return customers;

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
