package com.dy.ssm.test;

import com.dy.ssm.model.User;
import com.dy.ssm.service.FtpService;
import com.dy.ssm.service.UserService;
import com.dy.ssm.util.ArrayUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

/**
 * @author daiyun
 * @date 2018-7-5
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:mybatis-config.xml")
@WebAppConfiguration
public class MyBatisMainTest {

    @Autowired
    private UserService userService;

    @Autowired
    private FtpService ftpService;
//    private ApplicationContext applicationContext;

    /*@Before
    public void setUp() throws Exception{
        applicationContext = new ClassPathXmlApplicationContext("");
    }*/

    @Test
    public void testMybatis(){

        List<User> users = userService.getAll();
        if (ArrayUtils.isEmpty(users)){
            System.out.println("users:" + null);
        } else {
            for (User user : users){
                System.out.println(user);
            }
        }
    }
}
