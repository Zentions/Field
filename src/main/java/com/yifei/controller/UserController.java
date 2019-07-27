package com.yifei.controller;

import org.aspectj.apache.bcel.classfile.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yifei.bean.Msg;
import com.yifei.bean.User;
import com.yifei.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	@ResponseBody
	@RequestMapping(value="/adduser",method=RequestMethod.POST)
	public Msg AddUser(User user) {
		
		int code = userService.insertUser(user);
		if(code==0) {
			return Msg.failure();
		}else {
			return Msg.success();
		}
		
	}
	
	@ResponseBody
	@RequestMapping("/getUser")
	public Msg getUserInfo(@RequestParam(value="phone")String phone) {
		User user = userService.getUser(phone);
		if(user== null) return Msg.failure();
		else return Msg.success().add("user", user);
	}
}
