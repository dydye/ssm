package com.dy.ssm.pattern.mediator;


import java.util.Date;

/**
 * @author daiyun
 * @date 2018-7-2
 */
public class ChatRoom {


    public static void showMessage(User user, String message){
        System.out.println(new Date().toString() + "[" + user.getName() + "]:" + message);
    }
}
