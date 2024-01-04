package com.example.mvcsinglepattern.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    //default null sign
    private static DBConnection dbConnection;

    private final Connection connection;

    // default constructor  because create non parameters
    private DBConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ACPT_3", "root", "ramesh2245");
    }

    //create getter create only one object create

    public static DBConnection getDBConnection() throws SQLException, ClassNotFoundException {
        if (dbConnection == null) {
            dbConnection = new DBConnection();
        }
        return dbConnection;
    }

    public Connection getConnection() {
        return connection;
    }
}
