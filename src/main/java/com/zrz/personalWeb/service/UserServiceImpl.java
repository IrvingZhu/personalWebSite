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
//		only name
		if(newMail.compareTo("null") == 0) {
			if(userMapper.getInfo_check(newName) == null) {
				userMapper.updateName(name, newName);
				return true;
			}else {
				return false;
			}
		}
//		only mail
		else if(newName.compareTo("null") == 0) {
			userMapper.updateMail(name, newMail);
			return true;
		}
//		also name and mail
		else {
			if(userMapper.getInfo_check(newName) == null) {
				userMapper.updateMail(name, newMail);
				userMapper.updateName(name, newName);
				return true;
			}
			return false;
		}
	}
	
	@Override
	public boolean updatePwd(String name, String newPwd) {
		userMapper.updatePwd(name, newPwd);
		return true;
	}
}
