package com.pretosmind.f1.telemetry;

import javax.swing.*;
import org.apache.logging.log4j.LogManager;

public class BlackF1Telemetry {
    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Black F1 Telemetry");
        frame.setSize(640, 480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Black F1 Telemetry");
        frame.getContentPane().add(label);

        //Display the window.
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        LogManager.getLogger(BlackF1Telemetry.class).info("Starting application");

        javax.swing.SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
}
