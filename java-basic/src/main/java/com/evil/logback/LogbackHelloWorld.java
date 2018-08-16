package com.evil.logback;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogbackHelloWorld {
    public static void main(String[] args){
        Logger logger= LoggerFactory.getLogger(LogbackHelloWorld.class);
        logger.debug("Hello {}","logback");

        // print internal state
        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        StatusPrinter.print(lc);

    }
}
