package com.pretosmind.f1.telemetry.server;

import com.pretosmind.f1.telemetry.protocol.F1Message2017;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;

import java.net.SocketAddress;
import java.nio.ByteOrder;

public class TelemetryMessageHandler extends IoHandlerAdapter {

    private final Logger _logger;
    private final F1Message2017 _message;


    public TelemetryMessageHandler(Logger logger) {
        _logger = logger;
        _message = new F1Message2017();
    }

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        if (message instanceof IoBuffer) {
            IoBuffer buffer = (IoBuffer)message;
            buffer.order(ByteOrder.LITTLE_ENDIAN);
            _message.setByteBuffer(buffer.buf(), buffer.position());
        }
    }
}
