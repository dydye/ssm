package com.dy.ssm.pattern.prototype;

/**
 * @author daiyun
 * @date 2018-7-1
 */
public class PrototypePatternDemo {


    public static void main(String[] args) {
        ShapeCache.loadCache();

        Shape cloneShape = ShapeCache.getShape("1");
        System.out.println(cloneShape.getType());


        Shape cloneCircle = ShapeCache.getShape("2");
        System.out.println(cloneCircle.getType());
    }
}
