package com.shop.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Service;

import com.shop.core.model.Promotion;
import com.shop.dao.PromotionDao;
import com.shop.sqlprovider.PromotionProvider;

@Service
public class PromotionService {
	
	@Resource
	private PromotionDao promotionDao;
	
	/**
	 * 获取优惠促销
	 * @param productCategoryId
	 * @param intValue
	 * @param hasEnd
	 * @return
	 */
	public List<Promotion> findPromotions(Integer productCategoryId, int count, Boolean hasEnd) {
		
		List<Promotion> promotions=promotionDao.findPromotions(productCategoryId,count,hasEnd);
		
		return promotions;
	}
}
