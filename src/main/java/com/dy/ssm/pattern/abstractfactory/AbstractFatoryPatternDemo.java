package com.dy.ssm.pattern.abstractfactory;

/**
 * @author daiyun
 * @date 2018-6-29
 */
public class AbstractFatoryPatternDemo {


    public static void main(String[] args){

        AbstractFactory abstractFactory = FactoryProducer.getFactory("shape");
        Shape shape = abstractFactory.getShape("circle");
        shape.draw();

        shape = abstractFactory.getShape("rectangle");
        shape.draw();

        abstractFactory = FactoryProducer.getFactory("color");
        Color color = abstractFactory.getColor("red");
        color.fill();

        color = abstractFactory.getColor("green");
        color.fill();


    }
}
