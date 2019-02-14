package com.dy.ssm.pattern.chainofresponsibility;

/**
 * @author daiyun
 * @date 2018-7-2
 */
public class ErrorLogger extends AbstractLogger {

    public ErrorLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("errorLogger write:" + message);
    }
}
