/**
 * 
 */
package com.zrz.personalWeb.service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.integration.redis.util.RedisLockRegistry;
import org.springframework.stereotype.Service;

import com.zrz.personalWeb.repository.ManageDao;

/**
 * @author zrz
 *
 */

@Service
public class ManageServiceImpl implements ManageService {

	@Autowired
	ManageDao manaDao;
	
	@Override
	public int searchTotalNum() {
		return manaDao.searchTotalNum();
	}

	@Override
	public List<Map<String, Object>> searchAllBusiness(int begin, int num) {
		// TODO Auto-generated method stub
		return manaDao.searchAllBusiness(begin, num);
	}

	@Override
	public synchronized boolean addBusiness(String uname, String btype, String binfo) {
		// TODO Auto-generated method stub
		try {
			
			manaDao.addBusiness(btype, binfo);

			long bid = manaDao.bidFromBusiness();
			long uid = manaDao.searchUid(uname);

			manaDao.insertIntoConnectTable(uid, bid);
			
		}catch(Exception e) {
			return false;
		}

		return true;
	}

	@Override
	public boolean modifyBusiness(long bid, String btype, String binfo) {
		// TODO Auto-generated method stub
		try {
			if (binfo.compareTo("null") != 0)
				manaDao.modifyBusinessInfo(bid, binfo);
			if (btype.compareTo("null") != 0)
				manaDao.modifyBusinessType(bid, btype);

		} catch (Exception e) {
			return false;
		}

		return false;
	}

	@Override
	public boolean deleteBusiness(long bid) {
		// TODO Auto-generated method stub
		try {
			manaDao.deleteBusiness(bid);
			
		}catch(Exception e) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public int searchTotalKeyNum(String key) {
		// TODO Auto-generated method stub
		return manaDao.searchTotalKeyNum(key);
	}

	@Override
	public List<Map<String, Object>> searchBusiByKey(String key, int begin, int num) {
		// TODO Auto-generated method stub
		return manaDao.searchBusinessByKey(key, begin, num);
	}
}
