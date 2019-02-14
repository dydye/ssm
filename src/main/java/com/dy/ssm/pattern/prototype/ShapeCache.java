package com.dy.ssm.pattern.prototype;

import java.util.Hashtable;

/**
 * @author daiyun
 * @date 2018-7-1
 */
public class ShapeCache {

    private static Hashtable<String, Shape> shapedMap = new Hashtable<String, Shape>();

    public static Shape getShape(String shapedId){
        Shape cachedShape = shapedMap.get(shapedId);
        return (Shape) cachedShape.clone();
    }


    public static void loadCache(){
        Circle circle = new Circle();
        circle.setId("1");
        shapedMap.put(circle.getId(), circle);

        Rectangle rectangle = new Rectangle();
        rectangle.setId("2");
        shapedMap.put(rectangle.getId(), rectangle);
    }
}
