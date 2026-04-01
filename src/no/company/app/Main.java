package no.company.app;

import javax.swing.SwingUtilities;
import no.company.app.core.DashboardFrame;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(DashboardFrame::new);
    }
}