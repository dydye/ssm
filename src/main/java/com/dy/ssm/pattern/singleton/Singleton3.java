package com.dy.ssm.pattern.singleton;

/**
 * 双检锁/双重校验锁（DCL，即 double-checked locking）
 * @author daiyun
 * @date 2018-6-29
 */
public class Singleton3 {

    private Singleton3(){}

    private volatile static Singleton3 singleton3 ;

    private static Singleton3 getInstance(){
        if (singleton3 == null){
            synchronized (Singleton3.class){
                if (singleton3 == null){
                    return new Singleton3();
                }
            }
        }
        return singleton3;
    }
}
