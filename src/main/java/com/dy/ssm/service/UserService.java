package com.dy.ssm.service;

import com.dy.ssm.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author daiyun
 * @date 2018-6-4
 */
@Transactional(rollbackFor = Exception.class)
public interface UserService {

    List<User> getAll();

    void save(User user);

    void delete(int id);

    void update(User user);

    User getUserById(int id);

}
