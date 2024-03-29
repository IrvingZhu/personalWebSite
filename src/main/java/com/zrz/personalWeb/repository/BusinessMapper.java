package com.zrz.personalWeb.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zrz.personalWeb.domain.Business;

@Repository
public interface BusinessMapper {
	
	int searchBusiNum(long uid);
	
	List<Map<String, Object>> searchBusiKey(@Param("uid")long uid, @Param("begin")int begin, @Param("num")int num);
	
	Business searchBusiInfo(long bid);
	
	boolean getBidCheck(long bid);
	
	void updateBusiType(@Param("bid")long bid, @Param("btype")String btype);
	
	void updateBusiInfo(@Param("bid")long bid, @Param("binfo")String binfo);

	void deleteBusi(long bid);
	
	void insertToBusiness(@Param("btype")String btype, @Param("binfo")String binfo);
	
	long idFromBusiness();
	
	void insertToConnTable(@Param("uid")long uid, @Param("bid")long bid);
	
	boolean getConnTableCheck(@Param("bid")long bid);
	
	int searchBusiKeyNum(@Param("uid")long uid, @Param("first_key")String first_key, @Param("second_key")String second_key);
	
	List<Map<String, Object>> addKeyToSearch(@Param("uid")long uid, @Param("first_key")String first_key, @Param("second_key")String second_key, @Param("begin")int begin, @Param("num")int num);
}
