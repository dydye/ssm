package com.dy.ssm.pattern.observer;

/**
 * @author daiyun
 * @date 2018-6-29
 */
public abstract class Observer {

    protected Subject subject;

    public abstract void update();

}
