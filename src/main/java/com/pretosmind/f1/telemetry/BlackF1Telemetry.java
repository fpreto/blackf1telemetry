package com.pretosmind.f1.telemetry;

import javax.swing.*;

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
        javax.swing.SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
}
