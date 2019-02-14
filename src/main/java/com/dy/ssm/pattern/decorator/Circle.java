package com.dy.ssm.pattern.decorator;

/**
 * @author daiyun
 * @date 2018-7-9
 */
public class Circle implements Shape{

    @Override
    public void draw() {
        System.out.println("circle draw ...");
    }

}
