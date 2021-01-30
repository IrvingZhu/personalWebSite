package com.zrz.personalWeb.service;

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
	
	@Override
	public User showInfo(String name) {
		return userMapper.showInfo(name);
	}
	
	@Override
	public boolean updateInfo(String name, String newName, String newMail) {
		try {
			userMapper.updateUserInfo(name, newName, newMail);
			return true;
		}
		catch(Exception e) {
			throw e;
		}
	}
	
	@Override
	public boolean updatePwd(String name, String newPwd) {
		try {
			userMapper.updatePwd(name, newPwd);
			return true;
		}catch(Exception e) {
			throw e;
		}
	}
}
