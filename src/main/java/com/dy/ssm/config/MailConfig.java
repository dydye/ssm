package com.dy.ssm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

/**
 * 邮件配置
 * @author daiyun
 * @date 2018-6-26
 */
public class MailConfig {

    /**
     * JavaMailSenderImpl的几个属性设置说明如下：

     Host：邮箱服务器主机。

     Port：端口号。

     Username：发件方账户。

     Password：密码，qq邮箱的话此处设置16位授权码，不是邮箱密码，切记！

     mail.smtp.auth:认证机制开关，记得开启。

     mail.smtp.starttls.enable：TLS通讯协议开关，连接qq的SMTP服务器，需使用此通讯协议。

     mail.smtp.timeout ：连接超时时间，单位毫秒。

     发送文本消息用SimpleMailMessage类

     它的几个重要属性说明如下：

     From发件方的账户，和Username的值相同

     To收件方

     Subject邮件主题

     Text邮件内容
     * @return
     */
    @Bean
    public MailSender mailSender(){

        JavaMailSenderImpl  javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost("smtp.qq.com");
        javaMailSender.setPort(25);
        javaMailSender.setUsername("820047889");
        javaMailSender.setPassword("adkbwcrxcsvfbcie");

        //加认证机制
        Properties javaMailProperties = new Properties();
        javaMailProperties.put("mail.smtp.auth", true);
        javaMailProperties.put("mail.smtp.starttls.enable", true);
        javaMailProperties.put("mail.smtp.timeout", 5000);
        javaMailSender.setJavaMailProperties(javaMailProperties);

        //创建邮件内容
        SimpleMailMessage message=new SimpleMailMessage();
        String from = "820047889@qq.com";
        message.setFrom(from);
        message.setTo("daiyun@landray.com.cn");
        message.setSubject("测试");
        message.setText("这是一封测试邮件");

        return javaMailSender;
    }

}
