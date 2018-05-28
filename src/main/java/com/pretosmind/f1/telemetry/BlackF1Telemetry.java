package com.pretosmind.f1.telemetry;

import javax.swing.*;

import com.pretosmind.f1.telemetry.server.TelemetryServer;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class BlackF1Telemetry {

    private final Configuration _config;
    private final Logger _logger;
    private final TelemetryServer _server;

    public BlackF1Telemetry(Configuration config) throws IOException {
        _config = config;
        _logger = LoggerFactory.getLogger(BlackF1Telemetry.class);
        _server = new TelemetryServer(_config);

        createAndShowGUI();
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Black F1 Telemetry");
        frame.setSize(640, 480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Black F1 Telemetry");
        frame.getContentPane().add(label);

        //Display the window.
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        Logger logger = LoggerFactory.getLogger(BlackF1Telemetry.class);

        // Load configuration
        Configuration config = null;
        try {
            Configurations configs = new Configurations();
            config = configs.properties("blackf1telemetry.properties");
        } catch (ConfigurationException e) {
            logger.error("Failed to load blackf1telemetry.properties");
            System.err.println("Failed to load config file");
            System.exit(-1);
        }

        // Start app
        try {
            BlackF1Telemetry app = new BlackF1Telemetry(config);
        } catch (IOException e) {
            logger.error("Failed to start application", e);
            System.err.println("Failed to start application");
            e.printStackTrace();
            System.exit(-1);
        }

        //javax.swing.SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
}
