package com.dy.ssm.pattern.proxy;

/**
 * @author daiyun
 * @date 2018-7-2
 */
public class ProxyPatternDemo {


    public static void main(String[] args) {
        Image image = new ProxyImage("text.jpg");
        image.display();
        System.out.println("");
        image.display();
    }
}
