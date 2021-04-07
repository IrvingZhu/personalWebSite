/**
 * 
 */
package com.zrz.personalWeb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@RequestMapping(value = "/manageSearchTotal", method = RequestMethod.GET)
	public String searchTotalNum() {
		
		return Integer.toString(manaServ.searchTotalNum());
	}

	@RequestMapping(value = "/manageSearchAll", method = RequestMethod.GET)
	@ResponseBody
	public String searchAllBusiness(@RequestParam(value = "begin", required = true, defaultValue = "0") int begin,
									@RequestParam(value = "num", required = true, defaultValue = "0") int num) {
		return JSON.toJSONString(manaServ.searchAllBusiness(begin, num));
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
	
	@RequestMapping(value = "/manageSearchTotalKeyNum", method = RequestMethod.GET)
	@ResponseBody
	public String searchTotalKeyNum(@RequestParam(value = "key", required = true, defaultValue = "0") String key) {
		
		return Integer.toString(manaServ.searchTotalKeyNum(key));
	}
	
	@RequestMapping(value = "/manageSearchByKey", method = RequestMethod.GET)
	@ResponseBody
	public String searchAllByKey(@RequestParam(value = "key", required = true, defaultValue = "0") String key,
								 @RequestParam(value = "begin", required = true, defaultValue = "0") int begin,
								 @RequestParam(value = "num", required = true, defaultValue = "0") int num) {

		return JSON.toJSONString(manaServ.searchBusiByKey(key, begin, num));
	}
}
