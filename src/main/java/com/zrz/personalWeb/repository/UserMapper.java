package com.zrz.personalWeb.repository;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zrz.personalWeb.domain.User;

@Repository
public interface UserMapper {
	
	User getInfo(@Param("name")String name, @Param("pwd")String pwd);
	
	void setInfo(@Param("name")String name, @Param("pwd")String pwd, @Param("email")String email);
	
	Boolean getInfo_check(String name);
	
	User showInfo(String name);
	
	void updateName(@Param("name")String name, @Param("newName")String newName);
	
	void updateMail(@Param("name")String name, @Param("newMail")String newMail);
	
	void updatePwd(@Param("name")String name, @Param("newPwd")String newPwd);
}
