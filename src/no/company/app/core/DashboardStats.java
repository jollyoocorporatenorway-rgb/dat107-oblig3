package no.company.app.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DashboardStats {

    public static int getTotalEmployees() {
        return getCount("SELECT COUNT(*) FROM Employee");
    }

    public static int getTotalDepartments() {
        return getCount("SELECT COUNT(*) FROM Division");
    }

    public static int getTotalProjects() {
        return getCount("SELECT COUNT(*) FROM Project");
    }

    public static double getTotalSalary() {
        String sql = "SELECT COALESCE(SUM(EmployeeSalary), 0) FROM Employee";

        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()
        ) {
            if (rs.next()) {
                return rs.getDouble(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    private static int getCount(String sql) {
        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()
        ) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }
}