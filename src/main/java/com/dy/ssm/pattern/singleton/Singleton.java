package com.dy.ssm.pattern.singleton;

/**
 * 懒汉式，线程不安全
 * @author daiyun
 * @date 2018-6-29
 */
public class Singleton {

    private static  Singleton singleton;

    private Singleton(){}

    public static Singleton getInstance(){
        if(singleton == null){
            return new Singleton();
        }

        return singleton;
    }

}
