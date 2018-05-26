package com.itstudy.service;

import java.util.Arrays;
import java.util.Map;

import com.itstudy.exception.UserNotExitsException;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class LogController {

	@ResponseBody
	@RequestMapping("/name")
	public String getName() {
		return "lishenming";
	}
	
	@RequestMapping("/sucess")
	public String hello(Map<String, Object> map) {
		map.put("hello", "<h1>你好</h1>");
		map.put("users", Arrays.asList("zhangsan","wanger","lisi"));
		return "sucess";
	}

	@RequestMapping("/hello")
	public String hello(@RequestParam("user")String user) {
		if(user.equals("aaa")){
			throw  new UserNotExitsException();
		}
		return "sucess";
	}

	@PostMapping(value = "/user/login")
	public String login(@RequestParam("username") String username,
						@RequestParam("password") String password,
						Map<String ,Object> map , HttpSession session){
		if(!StringUtils.isEmpty(username) && "123456".equals(password)){
			//为了防止表单重复提交，我们重定向
			session.setAttribute("loginUser",username);
			return "redirect:/main.html";
		}else {
			map.put("msg","用户名密码错误");
			return  "login";
		}

	}

}
