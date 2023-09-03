package com.evil.chainofresponsibility;

public class ConsoleLogger extends Logger {
    @Override
    protected boolean shouldHandleMessage(LogMessage message) {
        return message.getLevel() == LogLevel.INFO;
    }

    @Override
    protected void writeMessage(LogMessage message) {
        System.out.println("Console Logger: " + message.getMessage());
    }
}

