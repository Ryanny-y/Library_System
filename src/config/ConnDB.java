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

    private static ConnDB instance;  // Singleton instance
    private Connection connection;

    // Private constructor to prevent multiple instances
    private ConnDB() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Database Connected!");
        } catch (SQLException ex) {
            Logger.getLogger(ConnDB.class.getName()).log(Level.SEVERE, "Database connection failed", ex);
        }
    }

    // Public method to get the singleton instance
    public static ConnDB getInstance() {
        if (instance == null) {
            instance = new ConnDB(); // Create instance if not exists
        }
        return instance;
    }

    // Get database connection
    public Connection getConnection() {
        return connection;
    }

    // Close connection method
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Database Connection Closed.");
                instance = null; // Reset instance after closing
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnDB.class.getName()).log(Level.SEVERE, "Failed to close connection", ex);
        }
    }
}
