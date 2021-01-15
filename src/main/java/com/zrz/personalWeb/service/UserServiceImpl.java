package com.zrz.personalWeb.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zrz.personalWeb.domain.User;
import com.zrz.personalWeb.repository.UserMapper;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public User login(String name, String pwd) {
		// TODO Auto-generated method stub
		return userMapper.getInfo(name, pwd);
	}
	
	@Override
	public boolean register(String name, String pwd, String email) {
		if(userMapper.getInfo_check(name) == null) {
			userMapper.setInfo(name, pwd, email);
			return true;
		}
		return false;
	}
}
