package com.yifei.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yifei.bean.User;
import com.yifei.dao.UserMapper;

@Service
public class UserService {
    
	@Autowired
	UserMapper userMapper;
	
    public int insertUser(User user) {
    	int code=1;
    	try {
    		code = userMapper.insert(user);
    		
		} catch (Exception e) {
			code = 0;
		}
    	
    	System.out.println("code="+code);
    	return code;
    			
	}
    
    public User getUser(String phone) {
    	return userMapper.selectByPrimaryKey(phone);
    }
}
