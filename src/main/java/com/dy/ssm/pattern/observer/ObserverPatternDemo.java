package com.dy.ssm.pattern.observer;

/**
 * @author daiyun
 * @date 2018-6-29
 */
public class ObserverPatternDemo {


    public static void main(String[] args){
        Subject subject = new Subject();

        new BinaryObserver(subject);
        new OctalObserver(subject);

        System.out.println("change state to 10");
        subject.setState(10);

        System.out.println("change state to 15");
        subject.setState(15);

    }
}
