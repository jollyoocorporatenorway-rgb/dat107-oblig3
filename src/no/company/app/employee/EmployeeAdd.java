package no.company.app.employee;

import no.company.app.core.DatabaseConnection;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeAdd extends JFrame {

    private JTextField idField, usernameField, firstNameField, lastNameField, positionField, salaryField, divisionField, startdateField;

    public EmployeeAdd() {
        setTitle("Legg til ansatt");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(9, 2, 5, 5));

        idField = new JTextField();
        usernameField = new JTextField();
        firstNameField = new JTextField();
        lastNameField = new JTextField();
        positionField = new JTextField();
        salaryField = new JTextField();
        divisionField = new JTextField();
        startdateField = new JTextField();

        add(new JLabel("Employee ID:")); add(idField);
        add(new JLabel("Username:")); add(usernameField);
        add(new JLabel("Fornavn:")); add(firstNameField);
        add(new JLabel("Etternavn:")); add(lastNameField);
        add(new JLabel("Stilling:")); add(positionField);
        add(new JLabel("Lønn:")); add(salaryField);
        add(new JLabel("Division ID:")); add(divisionField);
        add(new JLabel("Start Dato")); add(startdateField);

        JButton saveButton = new JButton("Lagre");
        saveButton.addActionListener(e -> addEmployee());

        add(new JLabel());
        add(saveButton);

        setVisible(true);
    }

    private void addEmployee() {
        String sql = """
                INSERT INTO Employee
                (EmployeeID, EmployeeUsername, EmployeeFirstName, EmployeeLastName,
                 EmployeePosition, EmployeeSalary, EmployeeDivisionID,EmployeeStartDate)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?)
                """;

        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setLong(1, Long.parseLong(idField.getText()));
            stmt.setString(2, usernameField.getText());
            stmt.setString(3, firstNameField.getText());
            stmt.setString(4, lastNameField.getText());
            stmt.setString(5, positionField.getText());
            stmt.setDouble(6, Double.parseDouble(salaryField.getText()));
            stmt.setInt(7, Integer.parseInt(divisionField.getText()));
            stmt.setDate(8, java.sql.Date.valueOf(java.time.LocalDate.now()));
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Ansatt lagt til!");
            dispose();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Databasefeil: " + ex.getMessage());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Sjekk at tallfeltene er riktige.");
        }
    }
}