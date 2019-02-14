package com.dy.ssm.pattern.prototype;

/**
 * @author daiyun
 * @date 2018-7-1
 */
public class Rectangle extends Shape {

    public Rectangle(){
        type = "Rectangle";
    }

    @Override
    void draw() {
        System.out.println("rectangle draw ");
    }
}
