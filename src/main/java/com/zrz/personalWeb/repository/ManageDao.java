/**
 * 
 */
package com.zrz.personalWeb.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author zrz
 *
 */

@Repository
public interface ManageDao {
	
	public int searchTotalNum();
	
	public List<Map<String, Object>> searchAllBusiness(@Param("begin")int begin, @Param("num")int num);
	
	public void addBusiness(@Param("btype")String btype, @Param("binfo")String binfo);
	
	public long bidFromBusiness();
	
	public long searchUid(String uname);
	
	public void insertIntoConnectTable(@Param("uid")long uid, @Param("bid")long bid);
	
	public void modifyBusinessType(@Param("bid")long bid, @Param("btype")String btype);
	
	public void modifyBusinessInfo(@Param("bid")long bid, @Param("binfo")String binfo);
	
	public boolean deleteBusiness(long bid);
	
	public int searchTotalKeyNum(@Param("key")String key);
	
	public List<Map<String, Object>> searchBusinessByKey(@Param("key")String key, @Param("begin")int begin, @Param("num")int num);
}
