package com.dy.ssm.pattern.chainofresponsibility;

/**
 * @author daiyun
 * @date 2018-7-2
 */
public class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger(int level){
        this.level = level;
    }

    @Override
    public void write(String message) {
        System.out.println("consoleLogger write:" + message);
    }

}
