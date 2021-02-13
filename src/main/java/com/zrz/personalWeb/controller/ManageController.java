/**
 * 
 */
package com.zrz.personalWeb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zrz.personalWeb.service.ManageService;

/**
 * @author zrz
 *
 */

@RestController
@CrossOrigin(maxAge = 3600)
public class ManageController {
	
	@Autowired
	ManageService manaServ;

	@RequestMapping(value = "/manageSearchAll", method = RequestMethod.POST)
	public String searchAllBusiness() {
		return JSON.toJSONString(manaServ.searchAllBusiness());
	}
	
	@RequestMapping(value = "/manageAdd", method = RequestMethod.POST)
	@ResponseBody
	public synchronized String addBusiness(@RequestBody JSONObject jsobj) {
		String uname = jsobj.get("uname").toString();
		String btype = jsobj.get("btype").toString();
		String binfo = jsobj.get("binfo").toString();
		
		if(manaServ.addBusiness(uname, btype, binfo))
			return JSON.toJSONString("success");
		
		return JSON.toJSONString("error");
	}
	
	@RequestMapping(value = "/manageUpd", method = RequestMethod.POST)
	@ResponseBody
	public String modifyBusiness(@RequestBody JSONObject jsobj) {
		long bid = Long.parseLong(jsobj.get("bid").toString());
		
		String btype = jsobj.get("btype").toString();
		String binfo = jsobj.get("binfo").toString();
		
		if(manaServ.modifyBusiness(bid, btype, binfo))
			return JSON.toJSONString("success");
		
		return JSON.toJSONString("error");
	}
	
	@RequestMapping(value = "/manageDel", method = RequestMethod.POST)
	@ResponseBody
	public String deleteBusiness(@RequestBody JSONObject jsobj) {
		long bid = Long.parseLong(jsobj.get("bid").toString());
		
		if(manaServ.deleteBusiness(bid))
			return JSON.toJSONString("success");
		
		return JSON.toJSONString("error");
	}
	
	@RequestMapping(value = "/manageSearchByKey", method = RequestMethod.POST)
	@ResponseBody
	public String searchAllByKey(@RequestBody JSONObject jsobj) {
		String key = jsobj.get("key").toString();
		
		return JSON.toJSONString(manaServ.searchBusiByKey(key));
	}
}
