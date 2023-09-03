package com.evil.chainofresponsibility;

/**
 * DatabaseLogger
 *
 * @author qinhu
 * @version 1.0.0
 * @since 2023-09-03
 */
public class DatabaseLogger extends Logger {
    @Override
    protected boolean shouldHandleMessage(LogMessage message) {
        return message.getLevel() == LogLevel.ERROR;
    }

    @Override
    protected void writeMessage(LogMessage message) {
        // 将日志消息保存到数据库
        System.out.println("Database Logger: " + message.getMessage());
    }
}
