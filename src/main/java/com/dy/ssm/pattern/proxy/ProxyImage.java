package com.dy.ssm.pattern.proxy;

/**
 * @author daiyun
 * @date 2018-7-2
 */
public class ProxyImage implements Image {


    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null){
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}
