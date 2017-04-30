package com.shop.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shop.core.model.AdPosition;
import com.shop.core.utils.AssertUtil;
import com.shop.dao.AdPositionDao;

@Service
public class AdPositionService {
	
	@Resource
	private AdPositionDao adPositionDao;

	public AdPosition findAdById(int id) {
		AssertUtil.isTrue(id<=0, "id不能为空");
		return adPositionDao.findAdById(id);
	}
}
