package com.lc.springBoot.redis.service.impl;

import com.BaseTest;
import com.lc.springBoot.redis.model.User;
import com.lc.springBoot.redis.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author lengchuan <lishuijun1992@gmail.com>
 * @date 17-5-8
 */
public class UserServiceImplTest extends BaseTest {


	@Test
	public void getUser() throws Exception {
		System.out.println(userService.getUser(8));
	}

	@Autowired
	private UserService userService;

	@Test
	public void createUser() throws Exception {
		User user = new User();
		user.setId(8);
		user.setName("test1");
		user.setEmail("test@test.com");
		userService.createUser(user);
	}
	@Test
	public void insertUsers() throws Exception {
		List<User> users = new ArrayList<>();
		User user = new User();
		user.setId(1);
		user.setName("test1");
		user.setEmail("test@test.com");
		User user2 = new User();
		user2.setId(2);
		user2.setName("test2");
		user2.setEmail("test@test2.com");
		users.add(user2);
		users.add(user);
		userService.insertUsers(users);
	}


}