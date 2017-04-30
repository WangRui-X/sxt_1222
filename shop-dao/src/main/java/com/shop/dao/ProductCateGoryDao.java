package com.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.shop.core.model.ProductCateGory;


public interface ProductCateGoryDao {
	
	@Select("SELECT id,name from xx_product_category where parent is null ORDER BY orders LIMIT #{count}")
	List<ProductCateGory> findRootList(@Param("count")int count);
	
	@Select("SELECT id,name from xx_product_category where parent=#{parentId} ORDER BY orders LIMIT #{count}")
	List<ProductCateGory> findChildrenList(@Param("count")int count, @Param("parentId")int parentId);
}
