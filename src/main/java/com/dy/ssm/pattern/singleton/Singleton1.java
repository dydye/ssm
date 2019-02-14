package com.dy.ssm.pattern.singleton;

/**
 * 懒汉式，线程安全
 * @author daiyun
 * @date 2018-6-29
 */
public class Singleton1 {

    private Singleton1(){}

    private static Singleton1 singleton1;

    public static synchronized Singleton1 getInstance(){

        if (singleton1 == null){
            return new Singleton1();
        }

        return singleton1;
    }

}
