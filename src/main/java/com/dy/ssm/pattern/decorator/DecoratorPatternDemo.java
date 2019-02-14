package com.dy.ssm.pattern.decorator;

/**
 * 装饰器模式
 * 用来包装原有的类，并在保持类方法签名完整性的前提下，提供了额外的功能。
 * @author daiyun
 * @date 2018-7-9
 */
public class DecoratorPatternDemo {


    public static void main(String[] args) {

        Shape circle = new Circle();
        circle.draw();

        System.out.println("------------分隔-----------");
        Shape redCircle = new RedShapeDecorator(new Circle());
        redCircle.draw();

    }
}
