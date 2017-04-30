package com.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.shop.core.model.Brand;

public interface BrandDao {
	
	/**
	 * 查询左边导航下的四个品牌
	 * @param productCategoryId
	 * @param count
	 * @return
	 */
	@Select("SELECT b.id,b.`name`,b.logo from xx_brand b LEFT JOIN xx_product_category_brand cb ON b.id=cb.brands WHERE "
             +" product_categories=#{productCategoryId} ORDER BY orders LIMIT #{count}")
	List<Brand> findBrandList(@Param("productCategoryId")Integer productCategoryId, @Param("count")int count);

}
