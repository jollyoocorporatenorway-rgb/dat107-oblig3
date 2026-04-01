package no.company.app.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // JDBC URL, bruker miljøvariabler for sikkerhet
    private static final String URL = System.getenv().getOrDefault(
            "DB_URL", "jdbc:postgresql://ider-database.westeurope.cloudapp.azure.com:5433/h668784"
    );
    private static final String USER = System.getenv().getOrDefault("DB_USER", "h668784");
    private static final String PASSWORD = System.getenv().getOrDefault("DB_PASSWORD", "pass");

    static {
        try {
            // Forsikre oss om at driveren lastes eksplisitt
            Class.forName("org.postgresql.Driver");
            System.out.println("PostgreSQL JDBC Driver registered.");
        } catch (ClassNotFoundException e) {
            System.err.println("PostgreSQL JDBC Driver not found. Add it to your project.");
            e.printStackTrace();
        }
    }

    /**
     * Henter en databaseforbindelse.
     * @return Connection
     * @throws SQLException om tilkoblingen feiler
     */
    public static Connection getConnection() throws SQLException {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to PostgreSQL database!");
            return conn;
        } catch (SQLException e) {
            System.err.println("Connection failed! Check the URL, user, and password.");
            throw e;
        }
    }

    // Eksempel på bruk
    public static void main(String[] args) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            System.out.println("Database connection is valid: " + conn.isValid(2));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}