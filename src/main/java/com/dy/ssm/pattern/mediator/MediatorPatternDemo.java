package com.dy.ssm.pattern.mediator;

/**
 * @author daiyun
 * @date 2018-7-2
 */
public class MediatorPatternDemo {


    /**
     * 中介者模式
     * @param args
     */
    public static void main(String[] args) {
        User robert = new User("robert");
        User join = new User("join");

        robert.sendMessage("hi!join");
        join.sendMessage("hello!robert");
    }
}
