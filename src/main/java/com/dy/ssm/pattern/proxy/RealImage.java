package com.dy.ssm.pattern.proxy;

/**
 * @author daiyun
 * @date 2018-7-2
 */
public class RealImage implements Image {


    private String fileName;

    public RealImage(String fileName){
        this.fileName = fileName;
        loadFromDisk(fileName);

    }
    @Override
    public void display() {
        System.out.println("display:" + fileName);
    }

    private void loadFromDisk(String fileName){
        System.out.println("loadFormDisk:" + fileName);
    }
}
