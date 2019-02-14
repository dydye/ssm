package com.dy.ssm.pattern.observer;

/**
 * @author daiyun
 * @date 2018-6-29
 */
public class BinaryObserver extends Observer {

    public  BinaryObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update(){
        System.out.println("binaryObserver String:" + Integer.toBinaryString(subject.getState()));
    }
}
