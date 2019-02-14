package com.dy.ssm.pattern.singleton;

/**
 * 登记式/静态内部类
 * @author daiyun
 * @date 2018-6-29
 */
public class Singleton4 {

    private Singleton4 (){}

    public static Singleton4 getInstance() {
        return SingletonHolder.SINGLETON4;
    }

    private static class SingletonHolder{
        private static final Singleton4 SINGLETON4 = new Singleton4();
    }
}
