package com.dy.ssm.dao;

import com.dy.ssm.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author daiyun
 * @date 2018-6-4
 */
@Repository
public interface UserMapper {

    /**
     * 在service层直接通过注解@Resource注入这个dao就可以使用了，service层传入SQLID来区别执行哪句SQL，通用性还是不错的
     */
    /*@Resource
    SqlSessionTemplate sqlSessionTemplate;

    public void update(String name) {
        sqlSessionTemplate.update(name, null);
    }*/

    List<User> getAll();

    void save(User user);

    void delete(int id);

    void update(User user);

    User getUserById(int id);

}
