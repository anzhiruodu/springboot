package com.lc.springBoot.redis.service.impl;

import com.lc.springBoot.redis.dao.UserDao;
import com.lc.springBoot.redis.model.User;
import com.lc.springBoot.redis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lengchuan <lishuijun1992@gmail.com>
 * @date 17-5-8
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public void createUser(User user) {
        userDao.insertUser(user);
    }


    @Override
    public User getUser(Integer id) {
        User user = userDao.getUser(id);
        return user;
    }

    @Override
    public void insertUsers(List<User> users) {
        userDao.insertUsers(users);
    }
}
