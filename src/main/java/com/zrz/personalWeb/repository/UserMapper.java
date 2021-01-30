package com.zrz.personalWeb.repository;

import org.springframework.stereotype.Repository;

import com.zrz.personalWeb.domain.User;

@Repository
public interface UserMapper {
	
	User getInfo(String name, String pwd);
	
	void setInfo(String name, String pwd, String email);
	
	Boolean getInfo_check(String name);
	
	User showInfo(String name);
	
	void updateUserInfo(String name, String newName, String newMail);
	
	void updatePwd(String name, String newPwd);
}
