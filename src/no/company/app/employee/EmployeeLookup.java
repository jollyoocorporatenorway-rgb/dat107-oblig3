package no.company.app.employee;

import no.company.app.core.DatabaseConnection;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeLookup extends JFrame {

    private JTextField idField;
    private JTextArea resultArea;

    public EmployeeLookup() {
        setTitle("Søk opp ansatt");
        setSize(450, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new GridLayout(1, 3, 5, 5));
        idField = new JTextField();
        JButton searchButton = new JButton("Søk");

        topPanel.add(new JLabel("Employee ID:"));
        topPanel.add(idField);
        topPanel.add(searchButton);

        resultArea = new JTextArea();
        resultArea.setEditable(false);

        searchButton.addActionListener(e -> lookupEmployee());

        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(resultArea), BorderLayout.CENTER);

        setVisible(true);
    }

    private void lookupEmployee() {
        String sql = """
                SELECT EmployeeID, EmployeeUsername, EmployeeFirstName, EmployeeLastName,
                       EmployeePosition, EmployeeSalary, EmployeeDivisionID
                FROM Employee
                WHERE EmployeeID = ?
                """;

        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setLong(1, Long.parseLong(idField.getText()));
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String result = """
                        Employee ID: %d
                        Username: %s
                        Navn: %s %s
                        Stilling: %s
                        Lønn: %.2f
                        Division ID: %d
                        """.formatted(
                        rs.getLong("EmployeeID"),
                        rs.getString("EmployeeUsername"),
                        rs.getString("EmployeeFirstName"),
                        rs.getString("EmployeeLastName"),
                        rs.getString("EmployeePosition"),
                        rs.getDouble("EmployeeSalary"),
                        rs.getInt("EmployeeDivisionID")
                );

                resultArea.setText(result);
            } else {
                resultArea.setText("Fant ingen ansatt med denne ID-en.");
            }

        } catch (SQLException ex) {
            resultArea.setText("Databasefeil: " + ex.getMessage());
        } catch (NumberFormatException ex) {
            resultArea.setText("ID må være et tall.");
        }
    }
}