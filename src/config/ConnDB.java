package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnDB {
    private static final String URL = "jdbc:mysql://localhost:3306/library_system";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Ryanny1003";

    private static ConnDB instance;
    private Connection connection;

    // Private constructor to prevent multiple instances
    private ConnDB() {
        connect();
    }

    // Method to establish the connection
    private void connect() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Database Connected!");
        } catch (SQLException ex) {
            Logger.getLogger(ConnDB.class.getName()).log(Level.SEVERE, "Database connection failed", ex);
        }
    }

    public static ConnDB getInstance() {
        if (instance == null) {
            instance = new ConnDB();
        }
        return instance;
    }

    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                System.out.println("Reconnecting to the database...");
                connect();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnDB.class.getName()).log(Level.SEVERE, "Error checking connection status", ex);
        }
        return connection;
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Database Connection Closed.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnDB.class.getName()).log(Level.SEVERE, "Failed to close connection", ex);
        } finally {
            instance = null; // Reset instance after closing
        }
    }
}
