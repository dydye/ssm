package com.dy.ssm.pattern.prototype;

/**
 * @author daiyun
 * @date 2018-7-1
 */
public class Circle extends Shape {

    public Circle(){
        type = "Circle";
    }

    @Override
    void draw() {
        System.out.println("circle draw ");
    }
}
