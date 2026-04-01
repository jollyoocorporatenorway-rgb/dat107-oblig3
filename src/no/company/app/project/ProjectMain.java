package no.company.app.project;

import javax.swing.*;
import java.awt.*;

public class ProjectMain extends JFrame {

    public ProjectMain() {
        setTitle("Project Module");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 1, 10, 10));

        JButton addButton = new JButton("Legg til prosjekt");
        JButton removeButton = new JButton("Slett prosjekt");
        JButton lookupButton = new JButton("Søk prosjekt");

        addButton.addActionListener(e ->
                JOptionPane.showMessageDialog(this, "Kommer senere.")
        );
        removeButton.addActionListener(e ->
                JOptionPane.showMessageDialog(this, "Kommer senere.")
        );
        lookupButton.addActionListener(e ->
                JOptionPane.showMessageDialog(this, "Kommer senere.")
        );

        add(addButton);
        add(removeButton);
        add(lookupButton);

        setVisible(true);
    }
}