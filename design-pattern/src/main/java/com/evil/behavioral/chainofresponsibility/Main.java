package com.evil.behavioral.chainofresponsibility;

public class Main {
    public static void main(String[] args) {
        Logger consoleLogger = new ConsoleLogger();
        Logger fileLogger = new FileLogger();
        Logger databaseLogger = new DatabaseLogger();

        consoleLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(databaseLogger);

        LogMessage message1 = new LogMessage("This is an information message.", LogLevel.INFO);
        LogMessage message2 = new LogMessage("This is a warning message.", LogLevel.WARNING);
        LogMessage message3 = new LogMessage("This is an error message.", LogLevel.ERROR);

        consoleLogger.logMessage(message1);
        consoleLogger.logMessage(message2);
        consoleLogger.logMessage(message3);
    }
}
