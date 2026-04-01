package no.company.app.department;

import javax.swing.*;
import java.awt.*;

public class DepartmentMain extends JFrame {

    public DepartmentMain() {
        setTitle("Department Module");
        setSize(400, 350);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1, 10, 10));

        JButton addButton = new JButton("Legg til avdeling");
        JButton removeButton = new JButton("Slett avdeling");
        JButton lookupButton = new JButton("Søk avdeling");
        JButton testButton = new JButton("dette virker aldri");

        addButton.addActionListener(e ->
                JOptionPane.showMessageDialog(this, "Kommer senere.")
        );
        removeButton.addActionListener(e ->
                JOptionPane.showMessageDialog(this, "Kommer senere.")
        );
        lookupButton.addActionListener(e ->
                JOptionPane.showMessageDialog(this, "Kommer senere.")
        );
        testButton.addActionListener(e ->
                JOptionPane.showMessageDialog(this, "Kommer aldri.")
        );

        add(addButton);
        add(removeButton);
        add(lookupButton);
        add(testButton);

        setVisible(true);
    }
}