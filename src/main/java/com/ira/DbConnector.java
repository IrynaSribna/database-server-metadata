package com.ira;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Iryna Sribna
 *
 */
public class DbConnector
{
    public static Connection connectToDb() throws SQLException {
        String url = "jdbc:mysql://localhost/";
        String database = "addressbook";
        String userName = "root";
        String password = "root";

        return DriverManager.getConnection(url, userName, password);
    }
}
