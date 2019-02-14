package com.dy.ssm.pattern.abstractfactory;

/**
 * @author daiyun
 * @date 2018-6-29
 */
public class ColorFactory extends AbstractFactory {
    @Override
    public Shape getShape(String shape) {
        return null;
    }

    @Override
    public Color getColor(String color) {

        if (color == null){
            return null;
        }

        if(color.equalsIgnoreCase("red")){
            return new Red();
        } else if (color.equalsIgnoreCase("green")){
            return new Green();
        }

        return null;
    }
}
