package no.company.app.employee;

import no.company.app.core.DatabaseConnection;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeRemove extends JFrame {

    private JTextField idField;

    public EmployeeRemove() {
        setTitle("Slett ansatt");
        setSize(300, 150);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(2, 2, 5, 5));

        idField = new JTextField();

        add(new JLabel("Employee ID:"));
        add(idField);

        JButton deleteButton = new JButton("Slett");
        deleteButton.addActionListener(e -> removeEmployee());

        add(new JLabel());
        add(deleteButton);

        setVisible(true);
    }

    private void removeEmployee() {
        String sql = "DELETE FROM Employee WHERE EmployeeID = ?";

        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setLong(1, Long.parseLong(idField.getText()));
            int rows = stmt.executeUpdate();

            if (rows > 0) {
                JOptionPane.showMessageDialog(this, "Ansatt slettet.");
            } else {
                JOptionPane.showMessageDialog(this, "Fant ingen ansatt med denne ID-en.");
            }

            dispose();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Databasefeil: " + ex.getMessage());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "ID må være et tall.");
        }
    }
}