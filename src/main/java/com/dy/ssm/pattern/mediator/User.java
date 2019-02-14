package com.dy.ssm.pattern.mediator;

/**
 * @author daiyun
 * @date 2018-7-2
 */
public class User {


    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String name){
        this.name = name;
    }

    public void sendMessage(String message){
        ChatRoom.showMessage(this, message);
    }
}
