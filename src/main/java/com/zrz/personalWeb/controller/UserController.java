package com.zrz.personalWeb.controller;

import java.util.HashMap;
import java.util.Map;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.zrz.personalWeb.domain.User;
import com.zrz.personalWeb.service.UserService;

@RestController
@CrossOrigin(maxAge = 3600)
public class UserController {

	@Autowired
	UserService uservice;

	@RequestMapping(value = "/loginIn", method = RequestMethod.POST)
	@ResponseBody
	public Object loginIn(@RequestBody JSONObject jsobj, HttpServletRequest request) throws JSONException {
		String name = jsobj.get("username").toString();
		String pwd = jsobj.get("pwd").toString();

		HttpSession sess = request.getSession();

		User us = uservice.login(name, pwd);
		if (us != null) {
			sess.setAttribute("uid", us.getId());
			sess.setAttribute("uname", us.getName());
			return JSON.toJSONString("success");
		}
		else {
			return JSON.toJSONString("error");
		}
	}

	@RequestMapping(value = "/registerIn", method = RequestMethod.POST)
	@ResponseBody
	public Object registerIn(@RequestBody JSONObject jsobj) {
		String name = jsobj.get("username").toString();
		String pwd = jsobj.get("pwd").toString();
		String email = jsobj.get("email").toString();
		
		if (uservice.register(name, pwd, email))
			return JSON.toJSONString("success");
		
		return JSON.toJSONString("error");
	}

	@RequestMapping(value = "/info", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public String showUserInfo(HttpServletRequest request) {
		Map<String, Object> mp = new HashMap<>();
		
		User user = uservice.showInfo(request.getSession().getAttribute("uname").toString());
		
		mp.put("id", user.getId());
		mp.put("name", user.getName());
		mp.put("mail", user.getEmail());
		return JSON.toJSONString(mp);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public String updateUserInfo(@RequestBody JSONObject jsobj, HttpServletRequest request) {
		String name = request.getSession().getAttribute("uname").toString();
		String newName = jsobj.get("newName").toString();
		
		if(newName.compareTo("null") != 0)
			request.getSession().setAttribute("uname", newName);
		
		String newMail = jsobj.get("newMail").toString();
		
		if(uservice.updateInfo(name, newName, newMail) == true)
			return JSON.toJSONString("success");
			
		return JSON.toJSONString("error");
	}

	@RequestMapping(value = "/updatepwd", method = RequestMethod.POST)
	@ResponseBody
	public String updatePwd(@RequestBody JSONObject jsobj, HttpServletRequest request) {
		String name = request.getSession().getAttribute("uname").toString();
		String newPwd = jsobj.get("newPwd").toString();
		
		if(uservice.updatePwd(name, newPwd) == true)
			return JSON.toJSONString("success");
		
		return JSON.toJSONString("error");
	}
}
