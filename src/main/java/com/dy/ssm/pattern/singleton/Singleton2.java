package com.dy.ssm.pattern.singleton;

/**
 * 饿汉式
 * @author daiyun
 * @date 2018-6-29
 */
public class Singleton2 {

    private Singleton2(){}

    private static Singleton2 singleton2 = new Singleton2();

    private static Singleton2 getInstance(){
        return  singleton2;
    }
}
