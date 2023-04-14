package entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *  Database class to represent a database connection
 */
public class Database {
    public static Connection getDatabaseConnection() throws SQLException {
        //Set the database connection properties
        String protocol = "jdbc";
        String dbServer = "mysql";
        String host = "localhost";
        String port = "3306";
        String dbName = "world";
        //Format the connection string
        String dbUrl = String.format("%s:%s://%s:%s/%s", protocol, dbServer, host, port, dbName);
        //Return the connection
        return DriverManager.getConnection(dbUrl, "root", "Theboys2!");
    }
}