package com.dy.ssm.pattern.chainofresponsibility;

/**
 * @author daiyun
 * @date 2018-7-2
 */
public class ChainPatternDemo {


    private static AbstractLogger getChainOfLoggers(){

        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);

        return errorLogger;
    }

    public static void main(String[] args) {
        AbstractLogger loggerChain = getChainOfLoggers();
        loggerChain.loadMessage(AbstractLogger.INFO, "this is an information");
        System.out.println("");
        loggerChain.loadMessage(AbstractLogger.DEBUG, "this is a information");
        System.out.println("");
        loggerChain.loadMessage(AbstractLogger.ERROR, "this is a information");
    }
}
