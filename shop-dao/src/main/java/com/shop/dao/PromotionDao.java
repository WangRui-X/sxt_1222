package com.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import com.shop.core.model.Promotion;
import com.shop.sqlprovider.PromotionProvider;

public interface PromotionDao {
	
	@SelectProvider(type=PromotionProvider.class,method="findPromotionList")
	List<Promotion> findPromotions(@Param("productCategoryId")Integer productCategoryId, @Param("count")int count, @Param("hasEnd")Boolean hasEnd);
	
	
}
