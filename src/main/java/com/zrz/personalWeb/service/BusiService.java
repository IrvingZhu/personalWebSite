/**
 * 
 */
package com.zrz.personalWeb.service;

import java.util.List;
import java.util.Map;

import com.zrz.personalWeb.domain.Business;

/**
 * @author zrz
 *
 */
public interface BusiService {
	
	int searchBusiNum(long uid);
	
	List<Map<String, Object>> searchBusiKey(long uid, int begin, int num);
	
	Business searchBusiInfo(long bid);
	
	boolean updateBusiInfo(long bid, String btype, String binfo);
	
	boolean deleteBusiness(long bid);
	
	boolean handleBusiness(long uid, String btype, String binfo);
	
	int searchBusiKeyNum(long uid, String key);
	
	List<Map<String, Object>> handleSearchBusi(long uid, String key, int begin, int num);
}
