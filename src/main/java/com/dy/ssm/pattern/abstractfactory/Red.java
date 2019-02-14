package com.dy.ssm.pattern.abstractfactory;

/**
 * @author daiyun
 * @date 2018-6-29
 */
public class Red implements Color {

    @Override
    public void fill() {
        System.out.println("red fill");
    }
}
