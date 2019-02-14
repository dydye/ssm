package com.dy.ssm.pattern.factory;

/**
 * @author daiyun
 * @date 2018-6-29
 */
public class ShapeFactory {

    public Shape getShape(String shapeType){

        if (shapeType == null){
            throw new NullPointerException("getShape - the param is null");
        }

        if (shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        }

        return null;
    }
}
