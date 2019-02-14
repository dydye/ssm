package com.dy.ssm.pattern.chainofresponsibility;

/**
 * @author daiyun
 * @date 2018-7-2
 */
public class FileLogger extends AbstractLogger {

    public FileLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("fileLogger write:" + message);
    }
}
