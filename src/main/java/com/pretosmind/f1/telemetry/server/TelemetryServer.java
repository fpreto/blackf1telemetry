package com.pretosmind.f1.telemetry.server;

import java.net.DatagramSocket;
import java.net.SocketException;

public class TelemetryServer {

    private DatagramSocket _socket;

    public TelemetryServer() throws SocketException {
        _socket = createSocket(8080);
    }

    protected DatagramSocket createSocket(int port) throws SocketException {
        return new DatagramSocket(port);
    }
}
