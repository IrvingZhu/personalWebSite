/**
 * 
 */
package com.zrz.personalWeb.service;

import com.zrz.personalWeb.domain.User;

/**
 * @author zrz
 *
 */
public interface UserService {
	
	User login(String name, String pwd);
	
	boolean register(String name, String pwd, String email);
	
	User showInfo(String name);
	
	boolean updateInfo(String name, String newName, String newMail);
	
	boolean updatePwd(String name, String newPwd);
}
