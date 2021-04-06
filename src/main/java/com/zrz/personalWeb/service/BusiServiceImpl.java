/**
 * 
 */
package com.zrz.personalWeb.service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.redis.util.RedisLockRegistry;
import org.springframework.stereotype.Service;

import com.zrz.personalWeb.domain.Business;
import com.zrz.personalWeb.repository.BusinessMapper;

/**
 * @author zrz
 *
 */

@Service
public class BusiServiceImpl implements BusiService {

	@Autowired
	private BusinessMapper busiDao;
	
	@Override
	public int searchBusiNum(long uid) {
		// TODO Auto-generated method stub
		return busiDao.searchBusiNum(uid);
	}

	@Override
	public List<Map<String, Object>> searchBusiKey(long uid, int begin, int num) {
		// TODO Auto-generated method stub
		return busiDao.searchBusiKey(uid, begin, num);
	}

	@Override
	public Business searchBusiInfo(long bid) {
		// TODO Auto-generated method stub
		return busiDao.searchBusiInfo(bid);
	}

	@Override
	public boolean updateBusiInfo(long bid, String btype, String binfo) {
		// TODO Auto-generated method stub
		if (busiDao.getBidCheck(bid) == false)
			return false;

		if (btype.compareTo("null") == 0) {
			busiDao.updateBusiInfo(bid, binfo);
			return true;
		} else if (binfo.compareTo("null") == 0) {
			busiDao.updateBusiType(bid, btype);
			return true;
		} else {
			busiDao.updateBusiType(bid, btype);
			busiDao.updateBusiInfo(bid, binfo);
			return true;
		}
	}

	@Override
	public boolean deleteBusiness(long bid) {
		// TODO Auto-generated method stub
		busiDao.deleteBusi(bid);

		try {
			if (busiDao.getBidCheck(bid) == false)
				return true;
		} catch (Exception e) {
			return true;
		}

		return false;
	}

	@Override
	public synchronized boolean handleBusiness(long uid, String btype, String binfo) {
		// TODO Auto-generated method stub
		long bid = -1;
		
		try {
			
			busiDao.insertToBusiness(btype, binfo);
			bid = busiDao.idFromBusiness();
			busiDao.insertToConnTable(uid, bid);
			
		}catch(Exception e) {
			return false;
		}

		if (busiDao.getBidCheck(bid) & busiDao.getConnTableCheck(bid))
			return true;

		return false;
	}
	
	@Override
	public List<Map<String, Object>> handleSearchBusi(long uid, String key) {
		
		return busiDao.addKeyToSearch(uid, key, key);
	}
}
