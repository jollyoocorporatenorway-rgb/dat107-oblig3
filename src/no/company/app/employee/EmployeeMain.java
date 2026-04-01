package no.company.app.employee;

import javax.swing.*;
import java.awt.*;

public class EmployeeMain extends JFrame {

    public EmployeeMain() {
        setTitle("Employee Module");
        setSize(450, 300);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1, 10, 10));

        JButton addButton = new JButton("Legg til ansatt");
        JButton removeButton = new JButton("Slett ansatt");
        JButton lookupButton = new JButton("Søk opp ansatt");
        JButton listButton = new JButton("Vis alle ansatte");

        addButton.addActionListener(e -> new EmployeeAdd());
        removeButton.addActionListener(e -> new EmployeeRemove());
        lookupButton.addActionListener(e -> new EmployeeLookup());
        listButton.addActionListener(e ->
                JOptionPane.showMessageDialog(this, "Vis alle ansatte kommer snart.")
        );

        add(addButton);
        add(removeButton);
        add(lookupButton);
        add(listButton);

        setVisible(true);
    }
}