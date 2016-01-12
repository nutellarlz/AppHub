package com.jtechme.apphub.net.bluetooth;

public class UnexpectedResponseException extends Exception {

    public UnexpectedResponseException(String message) {
        super(message);
    }

    public UnexpectedResponseException(String message, Throwable cause) {
        super("Unexpected response from Bluetooth server: '" + message + "'", cause);
    }
}