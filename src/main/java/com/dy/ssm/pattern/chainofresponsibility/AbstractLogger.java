package com.dy.ssm.pattern.chainofresponsibility;

/**
 * @author daiyun
 * @date 2018-7-2
 */
public abstract class AbstractLogger {

    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;

    protected int level;

    //责任链中的下一个元素
    protected AbstractLogger nextLogger;


    public void setNextLogger(AbstractLogger nextLog){
        this.nextLogger = nextLog;
    }

    public void loadMessage(int level, String message){
        if (this.level <= level){
            write(message);
        }
        if (nextLogger != null){
            nextLogger.loadMessage(level, message);
        }

    }

    protected abstract void write(String message);
}
