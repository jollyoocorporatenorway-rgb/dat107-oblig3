package no.company.app.core;

import no.company.app.employee.EmployeeMain;
import no.company.app.project.ProjectMain;
import no.company.app.department.DepartmentMain;

import javax.swing.*;
import java.awt.*;

public class DashboardFrame extends JFrame {

    private JLabel employeeLabel;
    private JLabel departmentLabel;
    private JLabel projectLabel;
    private JLabel salaryLabel;

    public DashboardFrame() {
        setTitle("Bedriftssystem - Dashboard");
        setSize(800, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel statsPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        statsPanel.setBorder(BorderFactory.createTitledBorder("Nøkkeltall"));

        employeeLabel = new JLabel();
        departmentLabel = new JLabel();
        projectLabel = new JLabel();
        salaryLabel = new JLabel();

        statsPanel.add(employeeLabel);
        statsPanel.add(departmentLabel);
        statsPanel.add(projectLabel);
        statsPanel.add(salaryLabel);

        JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        buttonPanel.setBorder(BorderFactory.createTitledBorder("Moduler"));

        JButton employeeButton = new JButton("Ansatte");
        JButton departmentButton = new JButton("Avdelinger");
        JButton projectButton = new JButton("Prosjekter");
        JButton refreshButton = new JButton("Oppdater dashboard");

        employeeButton.addActionListener(e -> new EmployeeMain());
        departmentButton.addActionListener(e -> new DepartmentMain());
        projectButton.addActionListener(e -> new ProjectMain());
        refreshButton.addActionListener(e -> refreshStats());

        buttonPanel.add(employeeButton);
        buttonPanel.add(departmentButton);
        buttonPanel.add(projectButton);
        buttonPanel.add(refreshButton);

        add(statsPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

        refreshStats();
        setVisible(true);
    }

    private void refreshStats() {
        employeeLabel.setText("Totalt ansatte: " + DashboardStats.getTotalEmployees());
        departmentLabel.setText("Totalt avdelinger: " + DashboardStats.getTotalDepartments());
        projectLabel.setText("Totalt prosjekter: " + DashboardStats.getTotalProjects());
        salaryLabel.setText("Total lønn: " + DashboardStats.getTotalSalary());
    }
}