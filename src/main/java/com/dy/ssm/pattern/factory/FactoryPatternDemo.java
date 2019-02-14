package com.dy.ssm.pattern.factory;

/**
 * @author daiyun
 * @date 2018-6-29
 */
public class FactoryPatternDemo {


    public static void main(String[] args){
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shape = shapeFactory.getShape("circle");
        shape.draw();

        shape = shapeFactory.getShape("rectangle");
        shape.draw();

    }
}
