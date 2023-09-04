package com.evil.behavioral.chainofresponsibility;

public abstract class Logger {
    private Logger nextLogger;

    public void setNextLogger(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void logMessage(LogMessage message) {
        if (shouldHandleMessage(message)) {
            writeMessage(message);
        }

        if (nextLogger != null) {
            nextLogger.logMessage(message);
        }
    }

    protected abstract boolean shouldHandleMessage(LogMessage message);
    protected abstract void writeMessage(LogMessage message);
}
