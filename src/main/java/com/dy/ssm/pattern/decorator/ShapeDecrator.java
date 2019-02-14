package com.dy.ssm.pattern.decorator;

/**
 * @author daiyun
 * @date 2018-7-9
 */
public abstract class ShapeDecrator implements Shape{

    protected Shape decratorShape;

    public ShapeDecrator(Shape shape){
        decratorShape = shape;
    }

    @Override
    public void draw(){

        if (decratorShape != null){
            decratorShape.draw();
        }
    }


}
