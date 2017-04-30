package com.shop.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shop.core.model.Goods;
import com.shop.dao.GoodsDao;


@Service
public class GoodsService {
	
	@Resource
	private GoodsDao goodsDao;
	
	/**
	 * 查询分类下的商品
	 * @param tagId
	 * @param count
	 * @param productCategoryId
	 * @return
	 */
	public List<Goods> findGoodList(Integer tagId,Integer count,Integer productCategoryId){
		
		return goodsDao.findGoodList(tagId, count, productCategoryId);
	}
}
