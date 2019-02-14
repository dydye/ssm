package com.dy.ssm.pattern.decorator;

/**
 * @author daiyun
 * @date 2018-7-9
 */
public class RedShapeDecorator extends ShapeDecrator{

    public RedShapeDecorator(Shape shape) {
        super(shape);
    }

    @Override
    public void draw(){
        decratorShape.draw();
        setRedBorder(decratorShape);
    }


    public void setRedBorder(Shape redBorder) {
        System.out.println("border color : red");
    }
}
