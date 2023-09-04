package com.evil.behavioral.chainofresponsibility;

/**
 * FileLogger
 *
 * @author qinhu
 * @version 1.0.0
 * @since 2023-09-03
 */
public class FileLogger extends Logger {
    @Override
    protected boolean shouldHandleMessage(LogMessage message) {
        return message.getLevel() == LogLevel.WARNING;
    }

    @Override
    protected void writeMessage(LogMessage message) {
        // 写入日志消息到文件
        System.out.println("File Logger: " + message.getMessage());
    }
}
