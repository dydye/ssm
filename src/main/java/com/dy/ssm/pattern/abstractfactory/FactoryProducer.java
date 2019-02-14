package com.dy.ssm.pattern.abstractfactory;

/**
 * @author daiyun
 * @date 2018-6-29
 */
public class FactoryProducer {

    public static AbstractFactory getFactory(String choice){

        if (choice == null){
            return null;
        }

        if (choice.equalsIgnoreCase("shape")){
            return new ShapeFactory();
        } else if (choice.equalsIgnoreCase("color")){
            return new ColorFactory();
        }
        return null;

    }
}
