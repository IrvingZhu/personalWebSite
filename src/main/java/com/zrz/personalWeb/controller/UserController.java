package com.zrz.personalWeb.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.zrz.personalWeb.domain.User;
import com.zrz.personalWeb.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService uservice;

	// test, when deployed delete it.
	@RequestMapping("/hello")
	public String index() {
		return "hello";
	}

	@RequestMapping(value = "/loginIn", method = RequestMethod.POST)
	public String loginIn(@RequestParam("username") String name, @RequestParam("pwd") String pwd) {
		User us = uservice.login(name, pwd);
		if (us != null)
			return "success\nThis is only test, and the Business handling function is not opening";
		else
			return "error";
	}

	@RequestMapping(value = "/registerIn", method = RequestMethod.POST)
	public String registerIn(@RequestParam("username") String name, @RequestParam("pwd") String pwd,
			@RequestParam("email") String email) {
		if (uservice.register(name, pwd, email))
			return "success\nThis is only test, and the Business handling function is not opening";
		return "error";
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
	public String updateUserInfo(String name, String mail) {
		return "success";
	}

	@RequestMapping(value = "/updatepwd", method = RequestMethod.POST)
	public String updatePwd(String pwd, String newPwd) {
		return "success";
	}
}
