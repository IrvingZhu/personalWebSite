/**
 * 
 */
package com.zrz.personalWeb.service;

import java.util.List;
import java.util.Map;

/**
 * @author zrz
 *
 */
public interface ManageService {
	
	public int searchTotalNum();
	
	public List<Map<String, Object>> searchAllBusiness(int begin, int num);
	
	public boolean addBusiness(String uname, String btype, String binfo);
	
	public boolean modifyBusiness(long bid, String btype, String binfo);
	
	public boolean deleteBusiness(long bid);
	
	public int searchTotalKeyNum(String key);
	
	public List<Map<String, Object>> searchBusiByKey(String key, int begin, int num);
}
