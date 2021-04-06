/**
 * 
 */
package com.zrz.personalWeb.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
import com.zrz.personalWeb.domain.Business;
import com.zrz.personalWeb.service.BusiService;

/**
 * @author zrz
 *
 */

@RestController
@CrossOrigin(maxAge = 3600)
public class BusinessController {
	
	@Autowired
	private BusiService serv;
	
//	search business total number
	@RequestMapping(value = "/getTotalResult", method = RequestMethod.GET)
	@ResponseBody
	public String searchBusiNum(HttpServletRequest request) {
		
		return Integer.toString(serv.searchBusiNum(Long.parseLong(request.getSession().getAttribute("uid").toString())));
	}
	
//	search business key to front-end's table
	@RequestMapping(value = "/searchBusi", method = RequestMethod.GET)
	@ResponseBody
	public String searchBusiKey(HttpServletRequest request,
								@RequestParam(value = "begin", required = true, defaultValue = "0") int begin,
								@RequestParam(value = "num", required = true, defaultValue = "0") int num){
		
		return JSON.toJSONString(serv.searchBusiKey(Long.parseLong(request.getSession().getAttribute("uid").toString()), begin, num));
	}
	
//	search information to right side drawer
	@RequestMapping(value = "/busiDetail", method = RequestMethod.GET)
	@ResponseBody
	public String searchBusiInfo(@RequestParam(value = "bid", required = true, defaultValue = "0") long bid){
		Business busi = serv.searchBusiInfo(bid);
		
		Map<String, Object> mp = new HashMap<>();
		mp.put("bid", busi.getBid());
		mp.put("btype", busi.getBtype());
		mp.put("binfo", busi.getBinfo());
		
		return JSON.toJSONString(mp);
	}
	
//	modify business information
	@RequestMapping(value = "/updateBusiInfo", method = RequestMethod.POST)
	@ResponseBody
	public String updateBusiInfo(@RequestBody JSONObject jsobj) {
		long bid = Long.parseLong(jsobj.get("bid").toString());
		
		String btype = jsobj.get("btype").toString();
		String binfo = jsobj.get("binfo").toString();
		
		if(serv.updateBusiInfo(bid, btype, binfo))
			return JSON.toJSONString("success");
		
		return JSON.toJSONString("error");
	}
	
//	delete such information
	@RequestMapping(value = "/deleteBusiness", method = RequestMethod.POST)
	@ResponseBody
	public String deleteBusiness(@RequestBody JSONObject jsobj) {
		if(serv.deleteBusiness(Long.parseLong(jsobj.get("bid").toString())))
			return JSON.toJSONString("success");
		
		return JSON.toJSONString("error");
	}
	
	@RequestMapping(value = "/addBusi", method = RequestMethod.POST)
	@ResponseBody
	public String addBusiness(@RequestBody JSONObject jsobj, HttpServletRequest request) {
		long uid = Long.parseLong(request.getSession().getAttribute("uid").toString());
		String btype = jsobj.get("btype").toString();
		String binfo = jsobj.get("binfo").toString();
		
		if(serv.handleBusiness(uid, btype, binfo))
			return JSON.toJSONString("success");
		
		return JSON.toJSONString("error");
	}
	
//search input function
	@RequestMapping(value = "/searchBusiByKey", method = RequestMethod.GET)
	@ResponseBody
	public String searchBusiByKey(HttpServletRequest request,
								  @RequestParam(value = "key", required = true, defaultValue = "0") String key) {
		
		return JSON.toJSONString(serv.handleSearchBusi(Long.parseLong(request.getSession().getAttribute("uid").toString()), key));
	}
}
