package com.zrz.personalWeb.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zrz.personalWeb.domain.User;
import com.zrz.personalWeb.service.UserService;

import javax.servlet.http.HttpSession;

@RestController
public class UserController {

	@Autowired
	UserService uservice;

	@RequestMapping(value = "/loginIn", method = RequestMethod.POST)
	public String loginIn(@RequestParam("username") String name, @RequestParam("pwd") String pwd, HttpSession sess) {
		User us = uservice.login(name, pwd);
		if (us != null) {
			sess.setAttribute("uid", us.getId());
			sess.setAttribute("uname", us.getName());
			return "success\n" + us.getId() + "\n" + us.getName() + "\n";
		}
		else
			return "error\n";
	}

	@RequestMapping(value = "/registerIn", method = RequestMethod.POST)
	public String registerIn(@RequestParam("username") String name, @RequestParam("pwd") String pwd,
			@RequestParam("email") String email) {
		if (uservice.register(name, pwd, email))
			return "success\n";
		return "error\n";
	}

	@RequestMapping(value = "/info", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> showUserInfo(@RequestParam("username") String name) {
		Map<String, Object> mp = new HashMap<>();
		User user = uservice.showInfo(name);
		mp.put("id", user.getId());
		mp.put("name", user.getName());
		mp.put("mail", user.getEmail());
		return mp;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateUserInfo(String name, String newName, String newMail) {
		if(uservice.updateInfo(name, newName, newMail) == true)
			return "success\n";
		return "error\n";
	}

	@RequestMapping(value = "/updatepwd", method = RequestMethod.POST)
	public String updatePwd(String name, String newPwd) {
		if(uservice.updatePwd(name, newPwd) == true)
			return "success\n";
		return "error\n";
	}
}