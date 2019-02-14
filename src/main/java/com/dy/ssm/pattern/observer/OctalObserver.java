package com.dy.ssm.pattern.observer;

/**
 * @author daiyun
 * @date 2018-6-29
 */
public class OctalObserver extends Observer {


    public OctalObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {

        System.out.println("octalObserver String:" + Integer.toBinaryString(subject.getState()));

    }
}
