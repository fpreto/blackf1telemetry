package com.pretosmind.f1.telemetry.server;

import org.apache.commons.configuration2.Configuration;
import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.filter.logging.LogLevel;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.DatagramSessionConfig;
import org.apache.mina.transport.socket.nio.NioDatagramAcceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;

public class TelemetryServer {

    private final Configuration _config;
    private final Logger _logger;

    private final NioDatagramAcceptor _datagramAcceptor;
    private final TelemetryMessageHandler _messageHandler;

    public TelemetryServer(Configuration config) throws IOException {
        _config = config;
        _logger = LoggerFactory.getLogger(TelemetryServer.class);

        _datagramAcceptor = new NioDatagramAcceptor();

        _messageHandler = new TelemetryMessageHandler(_logger);
        _datagramAcceptor.setHandler(_messageHandler);

        DatagramSessionConfig sessionConfig = _datagramAcceptor.getSessionConfig();
        sessionConfig.setReuseAddress(true);

        DefaultIoFilterChainBuilder filterChain = _datagramAcceptor.getFilterChain();

        LoggingFilter loggingFilter = new LoggingFilter();
        loggingFilter.setMessageReceivedLogLevel(LogLevel.DEBUG);
        filterChain.addLast("logger", loggingFilter);

        int port = config.getInt("server.port", 20777);
        _logger.info("Starting server at port {}", port);
        _datagramAcceptor.bind(new InetSocketAddress(port));
    }
}
