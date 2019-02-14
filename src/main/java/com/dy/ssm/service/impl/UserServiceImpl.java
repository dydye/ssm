package com.dy.ssm.service.impl;

import com.dy.ssm.dao.UserMapper;
import com.dy.ssm.model.User;
import com.dy.ssm.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author daiyun
 * @date 2018-6-4
 */
@Service
public class UserServiceImpl implements UserService{

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> getAll() {
        return userMapper.getAll();
    }

    @Override
    public void save(User user) {
        userMapper.save(user);
    }

    @Override
    public void delete(int id) {
        userMapper.delete(id);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public User getUserById(int id) {
        return userMapper.getUserById(id);
    }

}
