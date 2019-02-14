package com.dy.ssm.pattern.abstractfactory;

/**
 * @author daiyun
 * @date 2018-6-29
 */
public class ShapeFactory extends AbstractFactory {

    @Override
    public Shape getShape(String shape) {

        if (shape == null){
            return null;
        }

        if (shape.equalsIgnoreCase("CIRCLE")){

            return new Circle();
        } else if (shape.equalsIgnoreCase("rectangle")){

            return new Rectangle();
        }

        return null;
    }

    @Override
    public Color getColor(String color) {
        return null;
    }
}
