package com.lc.springBoot.redis.service;

import com.lc.springBoot.redis.model.User;

import java.util.List;

/**
 * @author lengchuan <lishuijun1992@gmail.com>
 * @date 17-5-8
 */
public interface UserService {
    void createUser(User user);

    User getUser(Integer id);

    void insertUsers(List<User> users);
}
