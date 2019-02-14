package com.dy.ssm.pattern.abstractfactory;

/**
 * 抽象工厂
 * @author daiyun
 * @date 2018-6-29
 */
public abstract class AbstractFactory {

    public abstract Shape getShape(String shape);

    public abstract Color getColor(String color);
}
